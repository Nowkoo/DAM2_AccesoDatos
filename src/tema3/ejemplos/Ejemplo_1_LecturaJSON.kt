package tema3.ejemplos

import org.json.JSONObject
import org.json.JSONTokener
import java.io.FileReader

fun main() {
    val r_json = FileReader("Recursos/parelles.json")
    val arrel = JSONTokener(r_json).nextValue() as JSONObject
    println(arrel.get("p3"));
}