package Tema3.Ejercicios

import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main() {
    val f = ObjectInputStream(FileInputStream("Recursos/Rutes.obj"))

    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    val arrel = doc.createElement("rutes")
    doc.appendChild(arrel)

    try {
        while (true) {
            val ruta = f.readObject() as Ruta
            val rutaElement = doc.createElement("ruta")
            arrel.appendChild(rutaElement)

            val nom = doc.createElement("nom")
            nom.appendChild(doc.createTextNode(ruta.nom))
            rutaElement.appendChild(nom)

            val desnivell = doc.createElement("desnivell")
            desnivell.appendChild(doc.createTextNode(ruta.desnivell.toString()))
            rutaElement.appendChild(desnivell)

            val desnivellAcumulat = doc.createElement("desnivellAcumulat")
            desnivellAcumulat.textContent = ruta.desnivellAcumulat.toString()
            rutaElement.appendChild(desnivellAcumulat)

            val punts = doc.createElement("punts")
            rutaElement.appendChild(punts)

            for (i in ruta.llistaDePunts.indices) {
                val punt = doc.createElement("punt")
                punt.setAttribute("num", (i+1).toString())
                punts.appendChild(punt)

                val puntNom = doc.createElement("nom")
                puntNom.textContent = ruta.llistaDePunts[i].nom
                punt.appendChild(puntNom)

                val puntLongitud = doc.createElement("longitud")
                puntLongitud.textContent = ruta.llistaDePunts[i].coord.longitud.toString()
                punt.appendChild(puntLongitud)

                val puntLatitud = doc.createElement("latitud")
                puntLatitud.textContent = ruta.llistaDePunts[i].coord.latitud.toString()
                punt.appendChild(puntLatitud)
            }
        }

    } catch (e: Exception) {
        f.close()
    }

    val trans = TransformerFactory.newInstance().newTransformer()
    trans.transform(DOMSource(doc), StreamResult("Recursos/Rutes.xml"))
}