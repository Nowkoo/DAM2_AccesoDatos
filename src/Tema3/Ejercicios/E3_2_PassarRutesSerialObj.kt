package Tema3.Ejercicios

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main() {
    val ruta = mutableListOf<Ruta>()

    val f_in = DataInputStream(FileInputStream("Recursos/Rutes.dat"))
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
        ruta.mostrarRuta()
        println()
    }
    f_in.close()

}

fun writeRutes(empleats: List<Empleat>) {
    val fileOut = FileOutputStream(RUTA_EMPLEATS)
    val objectOut = ObjectOutputStream(fileOut)

    for (empleat in empleats) {
        objectOut.writeObject(empleat)
    }

    objectOut.close()
}