package Swing

import java.awt.EventQueue
import javax.swing.*

class FinestraAmbJMenu : JFrame() {
    val menu_p = JMenuBar()

    val menu_1 = JMenu("Menu 1")
    val menu_2 = JMenu("Menu 2")
    val menu_3 = JMenu("Menu 3")

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Exemple de Menús")
        setSize(400, 300)
        setJMenuBar(menu_p)

        menu_p.add(menu_1)
        menu_p.add(menu_2)
        menu_p.add(menu_3)

        val menu_11 = JMenuItem("Menu 11")
        val menu_12 = JMenu("Menu 12")
        val menu_13 = JMenuItem("Menu 13")
        val menu_21 = JMenuItem("Menu 21")
        val menu_22 = JMenuItem("Menu 22")
        val menu_e = JMenuItem("Eixir")
        val menu_121 = JMenuItem("Menu 121")
        val menu_122 = JMenuItem("Menu 122 (eixir)")

        menu_1.add(menu_11)
        menu_1.add(menu_12)
        menu_1.add(JSeparator())
        menu_1.add(menu_13)
        menu_12.add(menu_121)
        menu_12.add(menu_122)
        menu_2.add(menu_21)
        menu_2.add(menu_22)
        menu_3.add(menu_e)
        menu_122.addActionListener { eixir() }
        menu_e.addActionListener { eixir() }
    }
}

fun eixir(){
    System.exit(0)
}

fun main () {
    EventQueue.invokeLater {
        FinestraAmbJMenu().isVisible = true
    }
}