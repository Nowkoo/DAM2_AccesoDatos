package tema_mongodb.exercicis

import com.mongodb.MongoClient
import org.bson.Document
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.net.URL

fun main() {
    val url = URL("http://gestiona.bicicas.es/apps/apps.php")
    val rd = url.openConnection().getInputStream().reader()
    val arrel = JSONTokener(rd).nextValue() as JSONArray
    val estacions = arrel.getJSONObject(0).getJSONArray("ocupacion") as JSONArray

    val con = MongoClient("localhost", 27017)
    val bd = con.getDatabase("test")

    for (i in 0 until estacions.length()) {
        val estacio = estacions[i] as JSONObject
        val doc = Document()

        doc.put("_id", estacio.get("id"))
        doc.put("punto", estacio.get("punto"))
        doc.put("puestos", estacio.get("puestos"))
        doc.put("ocupados", estacio.get("ocupados"))
        doc.put("latitud", estacio.get("latitud"))
        doc.put("longitud", estacio.get("longitud"))
        doc.put("porcentajeAltaOcupacion", estacio.get("porcentajeAltaOcupacion"))
        doc.put("porcentajeBajaOcupacion", estacio.get("porcentajeBajaOcupacion"))

        bd.getCollection("bicicas").insertOne(doc)
    }

    con.close()
}