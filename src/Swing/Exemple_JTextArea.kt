package Swing

import java.awt.BorderLayout
import java.awt.EventQueue
import java.awt.FlowLayout
import javax.swing.*

class FinestraAmbTextArea: JFrame() {
    val t1 = JTextArea(10, 35)
    val eixir = JButton("Eixir")
    val label = JLabel("Apreta per a eixir-> ")

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        title = "Exemple de JTextArea"
        setLayout(BorderLayout(2,1))
        val panel1 = JPanel(FlowLayout())
        val panel2 = JPanel(FlowLayout())

        add(panel1, BorderLayout.CENTER)
        val scroll = JScrollPane(t1)
        panel1.add(scroll)

        add(panel2, BorderLayout.SOUTH)
        panel2.add(label)
        panel2.add(eixir)

        pack()

        eixir.addActionListener {System.exit(0)}
    }
}

fun main () {
    EventQueue.invokeLater {
        FinestraAmbTextArea().isVisible = true
    }
}
