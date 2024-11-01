package Tema3.Ejercicios

import com.squareup.moshi.Moshi
import java.io.EOFException
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main() {
    val fileIn = FileInputStream("Recursos/Rutes.obj")
    val objectIn = ObjectInputStream(fileIn)

    var rutesObj = getRutesFromObj(objectIn)
    val rutes = Rutes(rutesObj)

    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(Rutes::class.java)
    val json = adapter.toJson(rutes)

    File("Recursos/RutesMoshi.json").writeText(json)
}

//llegim les rutes serialitzades y les afegim a un array rutes
private fun getRutesFromObj(objectIn: ObjectInputStream): MutableList<Ruta> {
    var rutes = arrayListOf<Ruta>()
    try {
        while (true) {
            var rutaObj = objectIn.readObject() as Ruta
            rutes.add(rutaObj)
        }
    } catch (e: EOFException) {

    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        objectIn.close()
    }

    return rutes
}