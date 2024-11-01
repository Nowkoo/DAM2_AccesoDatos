package Tema3.Ejercicios

import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import org.w3c.dom.Element
import java.awt.BorderLayout
import java.awt.EventQueue
import java.awt.FlowLayout
import java.io.File
import java.io.FileReader
import javax.swing.*
import javax.xml.parsers.DocumentBuilderFactory

class FinestraJSON: JFrame() {
    init {
        val r_json = FileReader("Recursos/Rutes.json")
        val arrel = JSONTokener(r_json).nextValue() as JSONObject

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

        val llistaRutes = arrayListOf<String>()
        val rutes = arrel.getJSONArray("rutes") as JSONArray
        for (i in 0 until rutes.length()) {
            val ruta = (rutes[i] as JSONObject)
            llistaRutes.add(ruta.get("nom").toString())
        }

        val combo = JComboBox(llistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener{
            area.text = ""
            val ruta = rutes.getJSONObject(combo.selectedIndex) as JSONObject
            val punts = ruta.getJSONArray("llistaDePunts")
            for (i in 0 until punts.length()) {
                val punt = punts[i] as JSONObject
                val coord = punt.get("coord") as JSONObject

                area.text += "${punt.get("nom")} (${coord.get("longitud")}, ${coord.get("latitud")})\n"
            }
        }
    }
}

fun main() {
    EventQueue.invokeLater {
        FinestraJSON().isVisible = true
    }
}