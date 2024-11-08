package Tema4.Ejemplos

import java.sql.DriverManager

fun main() {
    val url = "jdbc:mysql://89.36.214.106:3306/factura"
    val usuari = "factura"
    val password = "factura"

    val con = DriverManager.getConnection(url, usuari, password)
    println("Connexió completada")
    con.close()
}