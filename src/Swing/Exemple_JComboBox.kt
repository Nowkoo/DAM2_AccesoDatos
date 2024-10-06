package Swing

import java.awt.Color
import java.awt.EventQueue
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JLabel

class FinestraAmbComboBox : JFrame() {

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Exemple de JComboBox")
        setSize(400,300)
        setLayout(FlowLayout())

        add(JLabel("Tria un color"))

        val llista = arrayOf("Roig", "Blau", "Verd")
        val combo = JComboBox(llista)
        combo.addItem("Groc")
        add(combo)

        val boto1 = JButton("Color")
        add(boto1)

        combo.addActionListener {
            when(combo.getSelectedItem()) {
                "Roig" -> boto1.setBackground(Color.red)
                "Blau" -> boto1.setBackground(Color.blue)
                "Verd" -> boto1.setBackground(Color.green)
                "Groc" -> boto1.setBackground(Color.yellow)
            }
        }
        combo.setSelectedIndex(0)
    }
}

fun main () {
    EventQueue.invokeLater {
        FinestraAmbComboBox().isVisible = true
    }
}