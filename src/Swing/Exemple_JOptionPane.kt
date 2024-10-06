package Swing

import java.awt.EventQueue
import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.*

class FinestraAmbOptionPanes() : JFrame() {
    val boto1 = JButton("MessageDialog")
    val boto2 = JButton("MessageDialog ERROR")
    val boto3 = JButton("ConfirmDialog")
    val boto4 = JButton("InputDialog")

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Exemple de JDialog")
        setSize(400, 300)
        setLocationRelativeTo(null)
        setLayout(GridLayout(2, 1))
        val panel1 = JPanel(FlowLayout())
        val panel2 = JPanel(FlowLayout())
        add(panel1)
        add(panel2)

        panel1.add(JLabel("Programa principal. Per anar al diàleg apreta el botó"))
        panel2.add(boto1)
        panel2.add(boto2)
        panel2.add(boto3)
        panel2.add(boto4)

        boto1.addActionListener {
            JOptionPane.showMessageDialog(this, "Hola")
        }

        boto2.addActionListener {
            JOptionPane.showMessageDialog(this, "Hola", "Diàleg", JOptionPane.ERROR_MESSAGE)
        }

        boto3.addActionListener {
            when (JOptionPane.showConfirmDialog(this, "D'acord?")) {
                JOptionPane.OK_OPTION -> { println("Sí") }
                JOptionPane.NO_OPTION -> { println("No") }
                JOptionPane.CANCEL_OPTION -> { println("Cancel·lat") }
            }
        }

        boto4.addActionListener {
            val nom = JOptionPane.showInputDialog("Introdueix el teu nom")
            println("Hola, $nom")
        }
    }
}

fun main () {
    EventQueue.invokeLater {
        FinestraAmbOptionPanes().isVisible = true
    }
}