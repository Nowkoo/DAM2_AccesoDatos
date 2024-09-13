package Tema1.Ejercicios

import java.io.File

var directory = File.listRoots()[0]

fun main() {
    while (true) {
        mostrarDirectorio(directory)

        val input = readLine()!!.toInt()
        if(input == -1) break
        procesarOpcion(input)
    }

}

fun mostrarDirectorio(file: File) {
    if (file.exists()) {
        var indice = 0
        println("$indice ${file.absolutePath}")

        indice++
        for (e in file.listFiles()) {
            if (e.isDirectory) {
                println("$indice- ${e.name} es directorio")
            } else if (e.isFile) {
                println("$indice- ${e.name} es fichero y pesa ${e.length().dec()}")
            }

            indice++
        }
    }
}

fun procesarOpcion(input: Int) {
    if (input != null) {
        when (input) {
            0 -> directory = File.listRoots()[0]

        }
    }
}

fun directorioAnterior(currentFile: File) {
    var newDirectory = currentFile.parentFile
    if (newDirectory != null && newDirectory.isDirectory) {

    }
}