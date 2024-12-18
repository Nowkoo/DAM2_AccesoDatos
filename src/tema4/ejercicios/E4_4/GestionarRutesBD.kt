package tema4.ejercicios.E4_4

import tema3.ejercicios.Coordenades
import tema3.ejercicios.PuntGeo
import tema3.ejercicios.Ruta
import java.sql.Connection
import java.sql.DriverManager

class GestionarRutesBD {
    var con: Connection = DriverManager.getConnection("jdbc:sqlite:./bbdd/Rutes.sqlite")

    init {
        crearTaulaRuta()
        crearTaulaPunts()
    }

    fun inserir(ruta: Ruta) {
        val numRuta = ultimNumRuta() + 1
        val st = con.createStatement()
        st.executeUpdate("INSERT INTO RUTES VALUES ($numRuta, '${ruta.nom}', ${ruta.desnivell}, ${ruta.desnivellAcumulat})")

        var numPunt = ultimNumPunt(numRuta) + 1
        for (punt in ruta.llistaDePunts) {
            st.executeUpdate("INSERT INTO PUNTS VALUES ($numRuta, $numPunt, '${punt.nom}', ${punt.coord.latitud}, ${punt.coord.longitud})")
            numPunt++
        }
        st.close()
    }

    fun ultimNumRuta(): Int {
        val stQuery = con.createStatement()
        val resultSet = stQuery.executeQuery("select max(num_r) from RUTES")
        val lastNumRuta = resultSet.getInt(1)
        resultSet.close()
        stQuery.close()
        return lastNumRuta
    }

    fun ultimNumPunt(numRuta: Int): Int {
        val stQuery = con.createStatement()
        val resultSet = stQuery.executeQuery("select max(num_p) from PUNTS where num_r = $numRuta")
        val lastNumPunt = resultSet.getInt(1)
        resultSet.close()
        stQuery.close()
        return lastNumPunt
    }

    fun buscar(numRuta: Int): Ruta {
        val stQueryRuta = con.createStatement()
        val rsRuta = stQueryRuta.executeQuery("select * from RUTES where num_r = $numRuta")
        val ruta = Ruta(rsRuta.getString(2), rsRuta.getInt(3), rsRuta.getInt(4), mutableListOf<PuntGeo>())
        rsRuta.close()
        stQueryRuta.close()
        return afegirPunts(numRuta, ruta)
    }

    fun afegirPunts(numRuta: Int, ruta: Ruta): Ruta {
        val stQueryPunts = con.createStatement()
        val rsPunts = stQueryPunts.executeQuery("select * from PUNTS where num_r = $numRuta")
        while (rsPunts.next()) {
            val coordenada = Coordenades(rsPunts.getDouble(4), rsPunts.getDouble(5))
            ruta.addPunt(PuntGeo(rsPunts.getString(3), coordenada))
        }
        rsPunts.close()
        stQueryPunts.close()
        return ruta
    }

    fun llistat(): ArrayList<Ruta> {
        val rutes = mutableListOf<Ruta>()
        val st = con.createStatement()
        val rs = st.executeQuery("select * from RUTES")
        while (rs.next()) {
            val numRuta = rs.getInt(1)
            val ruta = Ruta(rs.getString(2), rs.getInt(3), rs.getInt(4), mutableListOf<PuntGeo>())
            afegirPunts(numRuta, ruta)
            rutes.add(ruta)
        }
        return rutes as ArrayList<Ruta>
    }

    fun esborrar(numRuta: Int) {
        val st = con.createStatement()
        st.executeUpdate("DELETE FROM PUNTS where num_r = ${numRuta}")
        st.executeUpdate("DELETE FROM RUTES where num_r = ${numRuta}")
        st.close()
    }

    fun close() {
        con.close()
        println("Conexión cerrada")
    }

    fun crearTaulaRuta() {
        val st = con.createStatement()
        st.executeUpdate("CREATE TABLE IF NOT EXISTS RUTES (" +
                "num_r INTEGER CONSTRAINT cp_rutes PRIMARY KEY," +
                "nom_r TEXT," +
                "desn INTEGER," +
                "desn_ac INTEGER);")
    }

    fun crearTaulaPunts() {
        val st = con.createStatement()
        st.executeUpdate("CREATE TABLE IF NOT EXISTS PUNTS (" +
                "num_r INTEGER," +
                "num_p INTEGER," +
                "nom_p TEXT," +
                "latitud REAL," +
                "longitud REAL," +
                "CONSTRAINT pk_punts PRIMARY KEY(num_r,num_p)," +
                "CONSTRAINT fk_rutes FOREIGN KEY(num_r) REFERENCES RUTES(num_r));")
    }
}