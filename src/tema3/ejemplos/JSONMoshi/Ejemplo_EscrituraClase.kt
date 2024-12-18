package tema3.ejemplos.JSONMoshi

import com.squareup.moshi.Moshi
import java.io.File

fun main() {
    val noms = arrayOf("Andreu", "Bernat", "Clàudia", "Damià")
    val departaments = arrayOf(10, 20, 10, 10)
    val edats = arrayOf(32, 28, 26, 40)
    val sous = arrayOf(1000.0, 1200.0, 1100.0, 1500.0)

    val empleats = arrayListOf<Empleat>()
    for (i in 0..3) {
        empleats.add(Empleat((i+1), noms[i], departaments[i], edats[i], sous[i]))
    }

    val empresa = Empresa(Empleats(empleats))

    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(Empresa::class.java)
    val json = adapter.toJson(empresa)

    File("Recursos/Empresa2.json").writeText(json)
}