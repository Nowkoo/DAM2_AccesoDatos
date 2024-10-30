package Tema3.Ejercicios

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream

const val RUTA_RUTES_OBJ = "Recursos/Rutes.obj"
const val RUTA_RUTES_DAT = "Recursos/Rutes.dat"


fun main() {
    val rutes = mutableListOf<Ruta>()

    val f_in = DataInputStream(FileInputStream(RUTA_RUTES_DAT))
    while (f_in.available() > 0) {
        val nom = f_in.readUTF()
        val desnivell = f_in.readInt()
        val desnivellAcumulat = f_in.readInt()
        val numPunts = f_in.readInt()
        val llistaDePunts = mutableListOf<PuntGeo>()
        for (i in 1..numPunts) {
            val nomPunt = f_in.readUTF()
            val l2 = f_in.readDouble()
            val l1 = f_in.readDouble()
            llistaDePunts.add(PuntGeo(nomPunt, Coordenades(l1, l2)))
        }

        val ruta = Ruta(nom, desnivell, desnivellAcumulat, llistaDePunts)
        rutes.add(ruta)
        ruta.mostrarRuta()
        println()
    }
    f_in.close()

    escriureRutes(rutes)
}

fun escriureRutes(rutas: List<Ruta>) {
    val fileOut = FileOutputStream(RUTA_RUTES_OBJ)
    val objectOut = ObjectOutputStream(fileOut)

    for (ruta in rutas) {
        objectOut.writeObject(ruta)
    }

    objectOut.close()
}