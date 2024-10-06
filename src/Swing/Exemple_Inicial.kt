package Swing

import java.awt.EventQueue
import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

class Finestra: JFrame() {
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Exemple inicial")
        setSize(400, 300)
        setLayout(FlowLayout())
        val boto1 = JButton("Botó 1")
        val boto2 = JButton("Botó 2")

//        boto1.setBounds(10, 10, 100, 20)
        add(boto1)

//        boto2.setBounds(50, 50, 80, 60)
        add(boto2)
    }
}

class Finestra2: JFrame() {
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Exemple de JPanel")
        setSize(400, 300)
        setLayout(GridLayout())

        val panel1 = JPanel(FlowLayout())
        val panel2 = JPanel(GridLayout(2, 2))

        val boto1 = JButton("Botó 1")
        val boto2 = JButton("Botó 2")
        val boto3 = JButton("Botó 3")
        val boto4 = JButton(ImageIcon("Recursos/icon.png"))
        boto4.addActionListener { System.exit(0) }


        add(panel1)
        add(panel2)

        panel1.add(boto1)
        panel1.add(boto2)

        panel2.add(boto3)
        panel2.add(boto4)
    }
}

fun main () {
    EventQueue.invokeLater {
        Finestra().isVisible = true
        Finestra2().isVisible = true
    }
}