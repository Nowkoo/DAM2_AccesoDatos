package Tema2.Ejemplos

import java.io.FileWriter

fun main() {
    val text = "Contingut per al fitxer. Ara ja sense por a caràcters especials: ç, à, ú, ..."
    val f_out = FileWriter("Recursos/f5.txt")
    for (c in text) {
        f_out.write(c.toInt())
    }
    f_out.close()
}