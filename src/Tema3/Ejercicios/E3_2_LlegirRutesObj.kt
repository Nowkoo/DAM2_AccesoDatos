package Tema3.Ejercicios

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main() {
    llegirRutes()
}

fun llegirRutes() {
    val fileIn = FileInputStream(RUTA_RUTES_OBJ)
    val objIn = ObjectInputStream(fileIn)

    try {
        while (true) {
            var ruta = objIn.readObject() as Ruta
            ruta.mostrarRuta()
            println()
        }
    } catch (e: EOFException) {
        //Si s'acaba el contingut del fitxer, no fem res.
    } catch (e: Exception) {
        println(e.message)
    } finally {
        objIn.close()
    }
}