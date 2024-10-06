package Swing

import java.awt.Color
import java.awt.EventQueue
import javax.swing.JFrame
import javax.swing.JOptionPane

//Per crear el GUIForm -> New -> Swing UI Designer -> GUI Form

class FinestraAmbGUIForm : JFrame() {

    init {
        //Declarar objecte de la classe del formulari
        val f = GUIForm()
        //Al JFrame li posem de contingut el formulari creat
        setContentPane(f.PanelPrincipal)
        //Podem fer referència als elements públics del formulari
        f.button1.background = Color.red
        f.button2.addActionListener {
            JOptionPane.showMessageDialog(null, "Hola")
        }


        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Designer GUI")
        setSize(400, 300)
    }
}

fun main() {
    EventQueue.invokeLater {
        FinestraAmbGUIForm().isVisible = true
    }
}