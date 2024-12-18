package tema3.ejemplos.JSONMoshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.File

fun main() {
    val json = File("Recursos/bicicas2.json").readText()

    val moshi = Moshi.Builder().build()
    val llistaTipus = Types.newParameterizedType(List::class.java, Estacions::class.java)
    val adapter: JsonAdapter<List<Estacions>> = moshi.adapter(llistaTipus)
    val estacions = adapter.fromJson(json)!!.get(0)!!.ocupacion

    val llistaEstDesti = arrayListOf<EstDesti>()
    val bicicas2 = Bicicas2(llistaEstDesti)
    for (e in estacions) {
        llistaEstDesti.add(EstDesti(e.id.toInt(), e.punto, e.puestos, e.ocupados, e.puestos - e.ocupados))
    }

    val adapter2 = moshi.adapter(Bicicas2::class.java)
    val json2 = adapter2.toJson(bicicas2)

    File("Recursos/bicicas3.json").writeText(json2)
}