package Tema3.Ejercicios

import Tema1.Ejercicios.mostrarDirectorio
import java.io.Serializable

class Coordenades(
    var longitud: Double,
    var latitud: Double
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
}

class PuntGeo(
    var nom: String,
    var coord: Coordenades
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
}

class Ruta (var nom: String, var desnivell: Int, var desnivellAcumulat: Int, var llistaDePunts: MutableList<PuntGeo>):
    Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }

    fun addPunt(p: PuntGeo){
        llistaDePunts.add(p)
    }

    fun getPunt(i: Int): PuntGeo{
        return llistaDePunts.get(i)
    }

    fun getPuntNom(i: Int): String {
        return llistaDePunts.get(i).nom
    }

    fun getPuntLatitud(i: Int): Double {
        return llistaDePunts.get(i).coord.latitud
    }

    fun getPuntLongitud(i: Int): Double {
        return llistaDePunts.get(i).coord.longitud
    }

    fun size(): Int {
        return llistaDePunts.size
    }

    fun mostrarRuta() {
        println("Ruta: $nom")
        println("Desnivell: $desnivell")
        println("Desnivell Acumulat: $desnivellAcumulat")
        println("Té ${llistaDePunts.size} punts")
        for (i in 1 .. llistaDePunts.size) {
            println("Punt $i: ${getPuntNom(i-1)} (${getPuntLongitud(i-1)}, ${getPuntLatitud(i-1)})")
        }
    }
}

class Rutes(var rutes: MutableList<Ruta> = mutableListOf<Ruta>())
