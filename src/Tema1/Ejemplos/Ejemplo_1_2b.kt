package Ejemplos

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {
    println("Introduce un directorio:")
    val ent = readLine().toString()
    val f = File(ent)
    println("Lista de ficheros y directorios del directorio actual")
    println("---------------------------------------------------")

    if (f.exists()) {
        for (e in f.walk()) {
            if (e.isDirectory) {
                println("${e.name} es directorio")
            } else if (e.isFile) {
                println("${e.name} es fichero y pesa ${e.length().dec()}")
            }
        }
    }
}