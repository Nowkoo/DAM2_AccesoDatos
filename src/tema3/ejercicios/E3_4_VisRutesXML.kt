package tema3.ejercicios

import org.w3c.dom.Element
import java.awt.BorderLayout
import java.awt.EventQueue
import java.awt.FlowLayout
import java.io.File
import javax.swing.*
import javax.xml.parsers.DocumentBuilderFactory

class Finestra: JFrame() {
    init {
        val dbFactory = DocumentBuilderFactory.newInstance()
        val documentBuilder = dbFactory.newDocumentBuilder()
        val doc = documentBuilder.parse(File("Recursos/Rutes.xml"))

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

        val llistaRutes = arrayListOf<String>()
        val rutes = doc.getElementsByTagName("ruta")
        for (i in 0 until rutes.length) {
            val ruta = rutes.item(i) as Element
            val nom = ruta.getElementsByTagName("nom").item(0)
            llistaRutes.add(nom.textContent)
        }

        val combo = JComboBox(llistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener{
            area.text = ""
            val ruta = rutes.item(combo.selectedIndex) as Element
            val punts = ruta.getElementsByTagName("punt")
            for (i in 0 until punts.length) {
                val puntChildNodes = punts.item(i).childNodes as Element
                val puntNom = puntChildNodes.getElementsByTagName("nom").item(0).textContent
                val puntLongitud = puntChildNodes.getElementsByTagName("longitud").item(0).textContent
                val puntLatitud = puntChildNodes.getElementsByTagName("latitud").item(0).textContent

                area.text += "$puntNom ($puntLongitud, $puntLatitud)\n"
            }
        }
    }
}

fun main() {
    EventQueue.invokeLater {
        Finestra().isVisible = true
    }
}