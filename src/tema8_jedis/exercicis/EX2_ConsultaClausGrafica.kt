package tema8_jedis.exercicis

import redis.clients.jedis.Jedis
import java.awt.Color
import java.awt.EventQueue
import java.awt.FlowLayout
import javax.swing.DefaultListModel
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.JTextField

class EstadisticaRD : JFrame() {
    val etTipClau = JLabel("Tipus:")
    val tipClau = JTextField(8)
    val contClau = JTextArea(8, 15)
    val con = Jedis("localhost")
    val listModel = DefaultListModel<String>()
    val llClaus = JList(listModel)

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 450, 450)
        setLayout(FlowLayout())

        llClaus.setForeground(Color.blue)
        val scroll = JScrollPane(llClaus)
        llClaus.setVisibleRowCount(20)

        val scroll2 = JScrollPane(contClau)

        add(scroll)
        add(etTipClau)
        add(tipClau)
        add(scroll2)

        setSize(600, 400)
        setVisible(true)

        inicialitzar()

        llClaus.addListSelectionListener{valorCanviat()}
    }

    fun inicialitzar() {
        val claus = con.keys("*").toList()
        val clausOrdenades = claus.sorted()
        listModel.clear()
        for (clau in clausOrdenades) {
            listModel.addElement(clau)
        }
    }

    fun valorCanviat() {
        val clauSeleccionada = llClaus.selectedValue

        if (clauSeleccionada != null) {
            val tipus = con.type(clauSeleccionada)
            tipClau.text = tipus

            when (tipus) {
                "string" -> {
                    contClau.text = con.get(clauSeleccionada)
                }
                "list" -> {
                    contClau.text = con.lrange(clauSeleccionada, 0, -1).joinToString(", ")
                }
                "set" -> {
                    contClau.text = con.smembers(clauSeleccionada).joinToString(", ")
                }
                "zset" -> {
                    contClau.text = con.zrangeWithScores(clauSeleccionada, 0, -1).joinToString(", ")
                }
                "hash" -> {
                    contClau.text = con.hgetAll(clauSeleccionada).toString()
                }
            }
        }
    }
}

fun main() {
    EventQueue.invokeLater {
        EstadisticaRD().isVisible = true
    }
}