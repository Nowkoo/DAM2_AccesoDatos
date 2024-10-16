package Tema3.Ejercicios

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

const val RUTA_EMPLEATS = "Recursos/Empleats.obj"
val empleats = listOf(
    Empleat(1, "Marta", "Contabilitat", 26, 1500.0),
    Empleat(1, "Juan", "Informática", 33, 1500.0)
)

fun main() {
    while (true) {
        var input = readLine()!!.toInt()

        when (input) {
            1 -> { writeEmpleats(empleats) }
            2 -> { readEmpleats() }
        }
    }
}

data class Empleat (
    val id: Int,
    val nom: String,
    val departament: String,
    val edat: Int,
    val sou: Double
) : Serializable {}

fun readEmpleats() {
    val fileIn = FileInputStream(RUTA_EMPLEATS)
    val objectIn = ObjectInputStream(fileIn)

    try {
        while (true) {
            var empleat = objectIn.readObject() as Empleat
            println(empleat)
        }
    } catch (e: Exception) {
        println(e.message)
    }

    objectIn.close()
}

fun writeEmpleats(empleats: List<Empleat>) {
    val fileOut = FileOutputStream(RUTA_EMPLEATS)
    val objectOut = ObjectOutputStream(fileOut)

    for (empleat in empleats) {
        objectOut.writeObject(empleat)
    }

    objectOut.close()
}