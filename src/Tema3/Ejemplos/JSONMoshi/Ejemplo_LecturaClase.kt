package Tema3.Ejemplos.JSONMoshi

import com.squareup.moshi.Moshi
import java.io.File

fun main() {
    val json = File("Recursos/Empresa.json").readText()

    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(Empresa::class.java)
    val empresa = adapter.fromJson(json)

    val llEmpleats = empresa!!.empresa.empleats
    println("Hi ha ${llEmpleats.size} empleats")
    for (e in llEmpleats) {
        println("${e.nom} (${e.sou})")
    }
}