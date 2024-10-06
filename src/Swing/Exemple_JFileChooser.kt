package Swing

import java.awt.EventQueue
import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.*

class FinestraAmbFileChooser() : JFrame() {
    val boto1 = JButton("FileChooser")
    val fc = JFileChooser()

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
//            val fc = JFileChooser()
//            val r = fc.showOpenDialog(this)
            val r = fc.showSaveDialog(this)
            if (r == JFileChooser.APPROVE_OPTION) {
                println("Fitxer seleccionat: " + fc.getSelectedFile().getName())
            } else {
                println("No s'ha seleccionat res")
            }
        }
    }
}

fun main () {
    EventQueue.invokeLater {
        FinestraAmbFileChooser().isVisible = true
    }
}