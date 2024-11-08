package Tema4.Ejemplos

import java.sql.DriverManager

fun main() {
    val url = "jdbc:postgresql://89.36.214.106:5432/geo_ad"
    val usuari = "geo_ad"
    val password = "geo_ad"

    val con = DriverManager.getConnection(url, usuari, password)
    println("Connexió completada")
    con.close()
}