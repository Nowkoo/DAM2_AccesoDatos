package Tema3.Ejercicios

import com.squareup.moshi.Moshi
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

class FinestraJSONMoshi: JFrame() {
    init {
        val json = File("Recursos/RutesMoshi.json").readText()

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Rutes::class.java)
        val rutes = adapter.fromJson(json)!!

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

//        val llistaRutes = arrayListOf<String>()
//
//        for (i in 0 until rutes.rutes.size) {
//            llistaRutes.add(rutes.rutes[i].nom)
//        }

        val combo = JComboBox(rutes.rutes.stream().map { ruta -> ruta.nom }.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener{
            area.text = ""
            val ruta = rutes.rutes[combo.selectedIndex]
            val punts = ruta.llistaDePunts
            for (punt in punts) {
                area.text += "${punt.nom} (${punt.coord.longitud}, ${punt.coord.latitud})\n"
            }
        }
    }
}

fun main() {
    EventQueue.invokeLater {
        FinestraJSONMoshi().isVisible = true
    }
}