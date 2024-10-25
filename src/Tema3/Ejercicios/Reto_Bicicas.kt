package Tema3.Ejercicios

import org.json.JSONArray
import org.json.JSONObject
import java.io.FileWriter

fun main() {
    val nums = arrayOf("01", "02", "03", "03")
    val noms = arrayOf("UJI - FCHS", "ESTACIÓN DE FERROCARRIL Y AUTOBUSES", "PLAZA DE PESCADERÍA")
    val llocs = arrayOf(28, 28, 28)
    val ocupats = arrayOf(11, 8, 13)
    val lliures = arrayOf(17, 20, 15)

    val arrel = JSONObject()
    val bicicas = JSONArray()
    arrel.put("bicicas", bicicas)

    for (i in 0..2) {
        val estacio = JSONObject()
        estacio.put("num", nums[i])
        estacio.put("nom", noms[i])
        estacio.put("llocs", llocs[i])
        estacio.put("ocupats", ocupats[i])
        estacio.put("lliures", lliures[i])
        bicicas.put(estacio)
    }

    val f = FileWriter("Recursos/bicicas.json")
    f.write(arrel.toString(4))
    f.close()
}