package Tema3.Ejercicios

import Tema3.Ejemplos.documentBuilder
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory

fun main() {
    val f = ObjectInputStream(FileInputStream("Recursos/Empleats.obj"))

    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    val arrel = doc.createElement("empleats")
    doc.appendChild(arrel)

    try {
        while (true) {
            val empleat = f.readObject() as Empleat
            val empleatElement = doc.createElement("empleat")
            empleatElement.setAttribute("id", empleat.id.toString())

            val nom = doc.createElement("nom")
            nom.appendChild(doc.createTextNode(empleat.nom))
            empleatElement.appendChild(nom)

            val dep = doc.createElement("departament")
            dep.setTextContent(empleat.departament)
            empleatElement.appendChild(dep)

            val edat = doc.createElement("edat")

        }
    } catch (e: Exception) {}
}