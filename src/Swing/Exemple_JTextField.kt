package Swing

import java.awt.EventQueue
import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class FinestraAmbTextField: JFrame() {
    val t1 = JTextField(15)
    val t2 = JTextField(15)
    val boto = JButton(">>")
    val eixir = JButton("Eixir")
    val label = JLabel("Apreta per a eixir-> ")

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        title = "Exemple de JTextField"
        setSize(500, 110)
        setLayout(GridLayout(2,1))
        val panel1 = JPanel(FlowLayout())
        val panel2 = JPanel(FlowLayout())

        add(panel1)
        panel1.add(t1)
        panel1.add(boto)
        panel1.add(t2)
        t2.setEditable(false)

        add(panel2)
        panel2.add(label)
        panel2.add(eixir)

        boto.addActionListener {t2.setText(t1.getText())}
        eixir.addActionListener {System.exit(0)}
    }
}

fun main () {
    EventQueue.invokeLater {
        FinestraAmbTextField().isVisible = true
    }
}
