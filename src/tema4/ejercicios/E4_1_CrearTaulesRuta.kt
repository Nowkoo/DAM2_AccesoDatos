package tema4.ejercicios

import java.sql.DriverManager

fun main() {
    val url = "jdbc:sqlite:./bbdd/Rutes.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("CREATE TABLE IF NOT EXISTS RUTES (" +
            "num_r INTEGER CONSTRAINT cp_rutes PRIMARY KEY," +
            "nom_r TEXT," +
            "desn INTEGER," +
            "desn_ac INTEGER);")

    st.executeUpdate("CREATE TABLE IF NOT EXISTS PUNTS (" +
            "num_r INTEGER," +
            "num_p INTEGER," +
            "nom_p TEXT," +
            "latitud REAL," +
            "longitud REAL," +
            "CONSTRAINT pk_punts PRIMARY KEY(num_r,num_p)," +
            "CONSTRAINT fk_rutes FOREIGN KEY(num_r) REFERENCES RUTES(num_r));")
}