package Tema3.Ejemplos.JSONMoshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.FileReader

fun main() {
    val json = FileReader("Recursos/bicicas2.json").readText()

    val moshi = Moshi.Builder().build()
    val llistaTipus = Types.newParameterizedType(List::class.java, Estacions::class.java)
    val adapter: JsonAdapter<List<Estacions>> = moshi.adapter(llistaTipus)
    val bicicas = adapter.fromJson(json)

    val estacions = bicicas!!.get(0).ocupacion
    println("Hi ha ${estacions.size} estacions:")
    for (e in estacions) {
        println("${e.id}: ${e.punto} (${e.ocupados}/${e.puestos})")
    }
}