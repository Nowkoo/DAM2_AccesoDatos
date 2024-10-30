package Tema3.Ejercicios

import java.io.*

const val RUTA_EMPLEATS = "Recursos/Empleats.obj"
val empleats = listOf(
    Empleat(1, "Marta", "Contabilitat", 26, 1500.0),
    Empleat(1, "Juan", "Informática", 33, 1500.0)
)

fun main() {
    while (true) {
        println("1.-Generar fitxer empleats")
        println("2.-Llegit fitxer empleats")
        var input = readLine()!!.toInt()

        when (input) {
            1 -> { writeEmpleats(empleats) }
            2 -> { readEmpleats() }
        }
    }
}

// ObjectInputStream no té un final d'arxiu explícit.
// Sabem que acaba perquè llança l'error EOFException
// (el fi de la lectura es gestiona amb try-catch)
fun readEmpleats() {
    val fileIn = FileInputStream(RUTA_EMPLEATS)
    val objectIn = ObjectInputStream(fileIn)

    try {
        while (true) {
            var empleat = objectIn.readObject() as Empleat
            println(empleat)
        }
    } catch (e: EOFException) {
        //Si s'acaba el contingut del fitxer, no fem res.
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        objectIn.close() //independentment de si hi ha o no excepció, lliberem recursos (sempre s'executa).
    }
}

fun writeEmpleats(empleats: List<Empleat>) {
    val fileOut = FileOutputStream(RUTA_EMPLEATS)
    val objectOut = ObjectOutputStream(fileOut)

    for (empleat in empleats) {
        objectOut.writeObject(empleat)
    }

    objectOut.close()
}

data class Empleat (
        val id: Int,
        val nom: String,
        val departament: String,
        val edat: Int,
        val sou: Double
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
}

// En el fitxer es guarda, a més del nom del paquet i el nom de la classe,
// l'identificador de la classe: el serialVersionUID, per a poder identificar
// unívocament la classe. Això ens pot donar problemes si intentem compartir
// la informació entre nosaltres, ja que perfectament ens pot generar UID diferents.
// Per a evitar-lo podríem definir nosaltres aquest serialVersionUID, i aleshores
// no hi haurà problemes per a compartir. Fins i tot serviria per a poder compartir
// el fitxer d'objectes entre Kotlin i Java.