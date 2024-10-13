package Tema2.Ejercicios

import javax.swing.*
import java.awt.*
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class Exercici_2_3 : JFrame() {
    var selectedFile: File? = null;

    val area = JTextArea()
    val scrollPane = JScrollPane(area)
    val menu_p = JMenuBar()

    val menu_arxiu = JMenu("Arxiu")
    val menu_ajuda = JMenu("Ajuda")

    val obrir = JMenuItem("Obrir")

    val guardar = JMenuItem("Guardar")
    val guardarCom = JMenuItem("Guardar com ...")
    val eixir = JMenuItem("Eixir")
    val quantA = JMenuItem("Quant a Editor")

    val fChooser = JFileChooser()

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setLayout(BorderLayout())
        setTitle("Editor de text més avançat")
        add(scrollPane)
        area.setEditable(true)
        setSize(750, 400)
        setJMenuBar(menu_p)
        menu_p.add(menu_arxiu)
        menu_p.add(menu_ajuda)

        menu_arxiu.add(obrir)
        menu_arxiu.add(guardar)
        menu_arxiu.add(guardarCom)
        menu_arxiu.add(JSeparator())
        menu_arxiu.add(eixir)

        menu_ajuda.add(quantA);
        obrir.addActionListener { obrir() }
        guardar.addActionListener { guardar() }
        guardarCom.addActionListener { guardarCom() }
        eixir.addActionListener { eixir() }
        quantA.addActionListener { quantA() }
    }
    fun obrir() {
        val fc = JFileChooser()
        val response = fc.showOpenDialog(this)
        if (response == JFileChooser.APPROVE_OPTION) {
            area.text = ""
            selectedFile = fc.selectedFile
            val f_in = FileReader(selectedFile)
            var c = f_in.read()
            while (c != -1) {
                area.text += c.toChar()
                c = f_in.read()
            }
            f_in.close()
        }
    }
    fun guardar() {
        if (selectedFile != null) {
           val  f_out = FileWriter(selectedFile)
            f_out.write(area.text)
            f_out.close()
        }
    }
    fun guardarCom() {
        val fc = JFileChooser()
        val response = fc.showSaveDialog(this)
        if (response == JFileChooser.APPROVE_OPTION) {
            val  f_out = FileWriter(fc.selectedFile)
            f_out.write(area.text)
            f_out.close()
        }
    }
    fun eixir() {
// Instruccions per a eixir
        System.exit(0)
    }
    fun quantA() {
// Instruccions per a mostrar un diàleg amb la versió (Acerca de...)
    }
}
fun main(args: Array<String>) {
    EventQueue.invokeLater( { Exercici_2_3().isVisible = true })
}