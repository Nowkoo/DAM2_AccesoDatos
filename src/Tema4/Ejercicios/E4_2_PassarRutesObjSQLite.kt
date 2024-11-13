package Tema4.Ejercicios

import Tema3.Ejercicios.Ruta
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.sql.DriverManager

fun main() {
    val f = ObjectInputStream(FileInputStream("Recursos/Rutes.obj"))
    val url = "jdbc:sqlite:./bbdd/Rutes.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    try {
        var num_ruta = 1;
        while (true) {
            val ruta = f.readObject() as Ruta
            st.executeUpdate("INSERT INTO RUTES VALUES($num_ruta, ${ruta.nom}, ${ruta.desnivell}, ${ruta.desnivellAcumulat});")

            var num_punt = 1
            for (punt in ruta.llistaDePunts) {
                st.executeUpdate("INSERT INTO PUNTS VALUES($num_ruta, $num_punt, ${punt.nom}, ${punt.coord.latitud}, ${punt.coord.longitud});")
                num_punt++
            }
            num_ruta++
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        f.close()
    }
}