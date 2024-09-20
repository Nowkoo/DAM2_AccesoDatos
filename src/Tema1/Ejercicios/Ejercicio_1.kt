package Tema1.Ejercicios

import java.io.File

var directorio = File.listRoots()[0]
var directorioCambiado = true

fun main() {
    var input : Int

    do {
        if (directorioCambiado)
            mostrarDirectorio(directorio)
        directorioCambiado = false

        do {
            println("Introduce una opción (-1 para acabar): ")
            input = pedirInput()
        } while (!inputValido(input))

        when (input) {
            0 -> {
                directorioAnterior(directorio)
            }
            else -> {
                seleccionarFichero(input)
            }
        }
    } while (input != -1)
}

fun mostrarDirectorio(file: File) {
    if (file.exists()) {
        var indice = 0
        println("$indice ${file.absolutePath}")

        indice++
        for (e in file.listFiles()!!) {
            if (e.isDirectory) {
                println("$indice- ${e.name} <Directorio>")
            } else if (e.isFile) {
                println("$indice- ${e.name} ${e.length().dec()}")
            }

            indice++
        }
    }
}

private fun seleccionarFichero(input: Int) {
    var selectedFile = ficheroSeleccionado(input)
    if (selectedFile != null && selectedFile.exists()) {
        if (selectedFile.isDirectory) {
            seleccionarDirectorio(selectedFile)
        } else if (selectedFile.isFile) {
            println("¡Eso no es un directorio!")
        }
    }
}

private fun inputValido(input : Int): Boolean {
    var numFicheros = directorio.listFiles()!!.size
    return input in -1..numFicheros
}

private fun ficheroSeleccionado(input: Int): File? {
    var numFicheros = directorio.listFiles()!!.size
    if (input in 1..numFicheros) {
        return directorio.listFiles()!![input - 1]
    }
    return null
}

private fun seleccionarDirectorio(selectedFile: File) {
    if (selectedFile.canRead()) {
        directorio = selectedFile
        directorioCambiado = true
    } else {
        println("No tienes permisos para leer esto...")
    }
}

fun directorioAnterior(currentFile: File) {
    var nuevoDirectorio = currentFile.parentFile
    if (nuevoDirectorio != null) {
        directorio = nuevoDirectorio
        directorioCambiado = true
    }
}

fun pedirInput(): Int {
    try {
        return readln().toInt()
    } catch (e: NumberFormatException) {
        println("¡Eso no es un número!")
        return -2
    }
}