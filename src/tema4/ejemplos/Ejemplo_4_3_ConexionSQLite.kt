package tema4.ejemplos

import java.sql.DriverManager

fun main() {
    val url = "jdbc:sqlite:./proveta.sqlite"

    val con = DriverManager.getConnection(url)
    println("Connexió completada")
    con.close()
}