package tema3.ejemplos

import org.json.JSONArray
import org.json.JSONObject
import java.io.FileWriter

fun main() {
    val noms = arrayOf("Andreu", "Bernat", "Clàudia", "Damià")
    val departaments = arrayOf(10, 20, 10, 10)
    val edats = arrayOf(32, 28, 26, 40)
    val sous = arrayOf(1000.0, 1200.0, 1100.0, 1500.0)

    val arrel = JSONObject()
    val empresa = JSONObject()
    arrel.put("empresa", empresa)
    val empleats = JSONArray()
    empresa.put("empleats", empleats)

    for (i in 0..3) {
        val empleat = JSONObject()
        empleat.put("num", i + 1)
        empleat.put("nom", noms[i])
        empleat.put("departament", departaments[i])
        empleat.put("edat", edats[i])
        empleat.put("sou", sous[i])
        empleats.put(empleat)
    }

    val f = FileWriter("Recursos/empleats.json")
    f.write(arrel.toString(4))
    f.close()
}