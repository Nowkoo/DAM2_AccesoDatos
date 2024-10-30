package Tema3.Ejercicios

import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

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
            edat.textContent = empleat.edat.toString()
            empleatElement.appendChild(edat)

            val sou = doc.createElement("sou")
            sou.textContent = empleat.sou.toString()
            empleatElement.appendChild(sou)

            arrel.appendChild(empleatElement)
        }
    } catch (e: Exception) {
        f.close()
    }

    val trans = TransformerFactory.newInstance().newTransformer()
    trans.transform(DOMSource(doc), StreamResult("Recursos/Empleats.xml"))
}