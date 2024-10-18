package Tema3.Ejemplos

import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

fun main() {
    val dbFactory = DocumentBuilderFactory.newInstance()
    val documentBuilder = dbFactory.newDocumentBuilder()
    val doc = documentBuilder.parse(File("Recursos/coches.xml"))

//    val a = doc.getDocumentElement()
//    val fa = a.childNodes
//
//    println("método 1")
//    for(i in 0 until fa.length) {
//        if (fa.item(i).nodeType.toInt() == 1) {
//            println(fa.item(i).nodeName)
//        }
//    }
//
//    println("método 2")
//    for(i in 0 until fa.length) {
//        if (fa.item(i).nodeType != Node.TEXT_NODE) {
//            println(fa.item(i).nodeName)
//        }
//    }
//
//    println("método 3")
//    val fa2 = a.getElementsByTagName("vehiculo")
//    for(i in 0 until fa2.length) {
//        println(fa2.item(i).nodeName)
//    }

    val coches = doc.getElementsByTagName("vehiculo")
    for(i in 0 until coches.length) {
        var coche = coches.item(i) as Element
        println("${coche.getNodeName()} ${i + 1}")

        val marca = coche.getElementsByTagName("marca")
        println(marca.item(0).nodeValue)

        for(i in 0 until coches.length) {
            println(coches.item(i).getNodeName())
        }





//        for (i in 0 until childNodes.length) {
////            if (childNodes.item(i).nodeType != Node.TEXT_NODE) {
////                println("${childNodes.item(i).getNodeName()}")
////            }
//        }
    }
}