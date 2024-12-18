package tema2.ejercicios
import javax.swing.*
import java.awt.*
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class E2_EditorText : JFrame() {
    val et_f = JLabel("Fitxer:")
    val fitxer = JTextField(25)
    val obrir = JButton("Obrir")
    val guardar = JButton("Guardar")
    val et_a = JLabel("Contingut:")
    val area = JTextArea(10, 50)
    val scrollPane = JScrollPane(area)
    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setLayout(GridLayout(2, 1))
        setTitle("Editor de text")
        val panell1 = JPanel(GridLayout(0, 1))
        val panell1_1 = JPanel(FlowLayout())
        panell1.add(panell1_1)
        panell1_1.add(et_f)
        panell1_1.add(fitxer)
        val panell1_2 = JPanel(FlowLayout())
        panell1.add(panell1_2)
        panell1_2.add(obrir)
        panell1_2.add(guardar)
        val panell2 = JPanel(GridLayout(0, 1))
        panell2.add(scrollPane)
        area.setEditable(true)
        add(panell1)
        add(panell2)
        pack()

        obrir.addActionListener {
            obrir()
        }
        guardar.addActionListener {
            guardar()
        }
    }

    private fun guardar() {
        val f_out: FileWriter
        var rutaFitxer = fitxer.getText()
        var file = File(rutaFitxer)

        if (file.exists()) {
            f_out = FileWriter(file)
            f_out.write(area.text)
            f_out.close()
        } else {
            println("No he trobat el fitxer")
        }
    }

    private fun obrir() {
        area.text = ""
        val f_in: FileReader
        var rutaFitxer = fitxer.getText()
        var file = File(rutaFitxer)

        if (file.exists()) {
            f_in = FileReader(file)
            var c = f_in.read()
            while (c != -1) {
                area.text += c.toChar()
                c = f_in.read()
            }
            f_in.close()
        } else {
            println("No he trobat el fitxer")
        }
    }
}
private fun crearMostrarFinestra() {
    val frame = E2_EditorText()
    frame.isVisible = true
}
fun main(args: Array<String>) {
    EventQueue.invokeLater(::crearMostrarFinestra)
}

