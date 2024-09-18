package Tema1.Ejercicios

import java.io.File

var directorio = File.listRoots()[0]
var mostrarDirectorio = true

fun main() {
    var input : Int?

    do {
        if (mostrarDirectorio) {
            mostrarDirectorio(directorio)
        }

        do {
            println("Introdueix una opció (-1 per acabar): ")
            input = readln().toInt()
        } while (!inputValido(input))

        procesarOpcion(input)

    } while (input != -1)
}

fun inputValido(input: Int?): Boolean {
    return (input == -1 || input == 0 || ficheroExiste(input))
}

fun mostrarDirectorio(file: File) {
    if (file.exists()) {
        var indice = 0
        println("$indice ${file.absolutePath}")

        indice++
        for (e in file.listFiles()) {
            if (e.isDirectory) {
                println("$indice- ${e.name} <Directorio>")
            } else if (e.isFile) {
                println("$indice- ${e.name} ${e.length().dec()}")
            }

            indice++
        }
    }
}

fun procesarOpcion(input: Int?) {
    when (input) {
        -1 -> {
            return
        }

        0 -> {
            directorioAnterior(directorio)
        }

        else -> {
            seleccionarFichero(input)
        }
    }
}

private fun seleccionarFichero(input: Int?) {
    var selectedFile = ficheroSeleccionado(input)
    if (selectedFile != null && selectedFile.exists()) {
        if (selectedFile.isDirectory) {
            seleccionarDirectorio(selectedFile)
        } else if (selectedFile.isFile) {
            seleccionarArchivo(selectedFile)
        }
    }
}

private fun ficheroExiste(input : Int): Boolean {
    var numFicheros = directorio.listFiles().size
    if (input >= 0 && input <= numFicheros) {
        return true
    }
    return false
}

private fun ficheroSeleccionado(input: Int?): File? {
    if (directorio.length() <= input!! && directorio.length() >= 0) {
        return directorio.listFiles().get(input - 1)
    }
    return null
}

private fun seleccionarDirectorio(selectedFile: File) {
    if (selectedFile.canRead()) {
        directorio = selectedFile
        mostrarDirectorio = true
    } else {
        println("No tiene permisos de lectura de este directorio")
        mostrarDirectorio = false
    }
}

private fun seleccionarArchivo(selectedFile: File) {
    println("El archivo seleccionado no es un directorio, seleccione un directorio.")
}

fun directorioAnterior(currentFile: File) {
    var nuevoDirectorio = currentFile.parentFile
    if (nuevoDirectorio != null && nuevoDirectorio.isDirectory) {
        directorio = nuevoDirectorio
        mostrarDirectorio = true
    }
    mostrarDirectorio = false
}