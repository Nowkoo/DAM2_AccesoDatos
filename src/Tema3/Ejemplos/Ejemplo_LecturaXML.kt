package Tema3.Ejemplos

import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

val dbFactory = DocumentBuilderFactory.newInstance()
val documentBuilder = dbFactory.newDocumentBuilder()
val doc = documentBuilder.parse(File("Recursos/coches.xml"))
fun main() {
    coches()
}

fun coches() {
    val coches = doc.getElementsByTagName("vehiculo")

    for(i in 0..<coches.length) {
        val coche = coches.item(i) as Element
        val marca = coche.getElementsByTagName("marca").item(0).textContent
        val modelo = coche.getElementsByTagName("modelo").item(0).textContent
        val matricula = coche.getElementsByTagName("matricula").item(0).textContent

        println("${coche.getNodeName()} ${i + 1}")
        println("Marco: $marca")
        println("Modelo: $modelo")
        println("Matrícula: $matricula")
        println()
    }
}

fun nodes1() {
    val a = doc.getDocumentElement()
    val fa = a.childNodes

    println("método 1")
    for(i in 0 until fa.length) {
        if (fa.item(i).nodeType.toInt() == 1) {
            println(fa.item(i).nodeName)
        }
    }
}

fun nodes2() {
    val a = doc.getDocumentElement()
    val fa = a.childNodes

    println("método 2")
    for(i in 0 until fa.length) {
        if (fa.item(i).nodeType != Node.TEXT_NODE) {
            println(fa.item(i).nodeName)
        }
    }
}

fun nodes3() {
    val a = doc.getDocumentElement()
    val fa = a.getElementsByTagName("vehiculo")
    for(i in 0 until fa.length) {
        println(fa.item(i).nodeName)
    }
}