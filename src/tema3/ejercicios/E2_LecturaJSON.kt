package tema3.ejercicios

import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.FileReader

fun main() {
    //Serviría para leer tanto empleadosv1.json como empleadosv2.json
    val r_json = FileReader("Recursos/empleadosv1.json")
    val arrel = JSONTokener(r_json).nextValue() as JSONObject
    val empleatsV1 = arrel.getJSONArray("empleats") as JSONArray

    for (i in 0..< empleatsV1.length()) {
        val empleat = empleatsV1[i] as JSONObject
        println("${empleat.get("nom")} té un sou de ${empleat.get("sou")} euros")
    }
}