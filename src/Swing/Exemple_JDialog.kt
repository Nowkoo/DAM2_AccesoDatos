package Swing

import java.awt.EventQueue
import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.*

class Finestra_dialeg(f: FinestraAmbDialeg) : JDialog (f, "Diàleg", true) {
    init {
        setSize(200, 100)
        setLocationRelativeTo(null)
        val panell = JPanel()
        panell.add(JLabel("Hola, què tal?"))
        add(panell)
        setVisible(true)
    }
}
class FinestraAmbDialeg() : JFrame() {
    val boto1 = JButton("Botó 1")

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

        boto1.addActionListener {
            println("Obrint diàleg")
            Finestra_dialeg(this)
        }
    }
}

fun main () {
    EventQueue.invokeLater {
        FinestraAmbDialeg().isVisible = true
    }
}