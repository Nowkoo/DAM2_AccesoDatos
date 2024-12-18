package tema3.ejercicios

import org.json.JSONArray
import org.json.JSONObject
import java.io.EOFException
import java.io.FileInputStream
import java.io.FileWriter
import java.io.ObjectInputStream

fun main() {
    val fileIn = FileInputStream("Recursos/Rutes.obj")
    val objectIn = ObjectInputStream(fileIn)

    val arrel = JSONObject()
    val rutes = JSONArray()
    arrel.put("rutes", rutes)

    try {
        while (true) {
            var rutaObj = objectIn.readObject() as Ruta
            var ruta = JSONObject()
            ruta.put("nom", rutaObj.nom)
            ruta.put("desnivell", rutaObj.desnivell)
            ruta.put("desnivellAcumulat", rutaObj.desnivellAcumulat)

            val punts = JSONArray()
            for (puntObj in rutaObj.llistaDePunts) {
                val punt = JSONObject()
                punt.put("nom", puntObj.nom)

                val coord = JSONObject()
                coord.put("longitud", puntObj.coord.longitud)
                coord.put("latitud", puntObj.coord.latitud)

                punt.put("coord", coord)
                punts.put(punt)
            }
            ruta.put("llistaDePunts", punts)
            rutes.put(ruta)
        }

    } catch (e: EOFException) {

    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        objectIn.close()
        val f = FileWriter("Recursos/Rutes.json")
        f.write(arrel.toString(4))
        f.close()
    }
}