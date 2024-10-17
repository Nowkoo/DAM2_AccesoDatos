package Ejemplos

import java.io.File

fun main(args: Array<String>) {
    val directorioActual = File(".")
    println("Lista de ficheros y directorios del directorio actual")
    println("---------------------------------------------------")
    for (file in directorioActual.list().sorted())
        println(file)
}
