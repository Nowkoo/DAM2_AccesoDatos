package Ejemplos

import java.io.File

fun main(args: Array<String>) {
    val f = File("fitxers/../fitxers/f1.txt")
    println("Nom: " + f.getName())
    println("Ruta relativa: " + f.getPath())
    println("Ruta absoluta: " + f.absolutePath)
    println("Ruta canònica: " + f.getCanonicalPath())
}