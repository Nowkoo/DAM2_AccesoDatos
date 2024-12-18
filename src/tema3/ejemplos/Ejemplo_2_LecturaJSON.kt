package tema3.ejemplos

import org.json.JSONObject
import org.json.JSONTokener
import java.io.FileReader

fun main() {
    val r_json = FileReader("Recursos/empleado.json")
    val arrel = JSONTokener(r_json).nextValue() as JSONObject
    val empleat = arrel.get("empleat") as JSONObject
    println("${empleat.get("nom")} té un sou de ${empleat.get("sou")} euros")
}