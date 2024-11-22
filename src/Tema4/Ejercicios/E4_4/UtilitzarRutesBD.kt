package Tema4.Ejercicios.E4_4

import Tema3.Ejercicios.Coordenades
import Tema3.Ejercicios.PuntGeo
import Tema3.Ejercicios.Ruta

fun main() {
    val gRutes =  GestionarRutesBD()

//    //Inserció d'una ruta
//    val noms = arrayOf("Les Useres", "Les Torrocelles", "Lloma Bernat", "Xodos (Molí)", "El Marinet", "Sant Joan")
//    val latituds = arrayOf(40.158126, 40.196046, 40.219210, 40.248003, 40.250977, 40.251221)
//    val longituds = arrayOf(-0.166962, -0.227611, -0.263560, -0.296690, -0.316947, -0.354052)
//    val punts = arrayListOf<PuntGeo>()
//    for (i in 0 until 6) {
//        punts.add(PuntGeo(noms[i], Coordenades(latituds[i], longituds[i])))
//    }
//    gRutes.inserir(Ruta("Pelegrins de Les Useres", 896, 1738, punts))

//    //Listat de totes les rutes
//    for (ruta in gRutes.llistat()) {
//        ruta.mostrarRuta()
//    }
//
//    //Buscar ruta determinada
//    val r2 = gRutes.buscar(2)
//    if (r2 != null) {
//        r2.mostrarRuta()
//    }
//
    gRutes.esborrar(5)

//    gRutes.close()
}