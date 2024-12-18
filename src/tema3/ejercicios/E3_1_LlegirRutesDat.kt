package tema3.ejercicios

import java.io.DataInputStream
import java.io.FileInputStream

fun main() {
    val f_in = DataInputStream(FileInputStream("Recursos/Rutes.dat"))
    while (f_in.available() > 0) {
        println("Nom: " + f_in.readUTF())
        println("Desnivell: " + f_in.readInt())
        println("Desnivell acumulat: " + f_in.readInt())
        val numPunts = f_in.readInt()
        println("Té $numPunts punts")
        for (i in 1..numPunts) {
            println("Punt $i: ${f_in.readUTF()} (${f_in.readDouble()}, ${f_in.readDouble()})")
        }
        println()
    }
    f_in.close()
}