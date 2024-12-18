package tema2.ejemplos

import java.io.ByteArrayInputStream
import java.io.FileInputStream
import java.io.SequenceInputStream

fun main() {
    val f1 = FileInputStream("Recursos/f1.txt")
    val ent_1 = "Aquest és un byte array"
    val f2 = ByteArrayInputStream(ent_1.toByteArray())
    val f_in = SequenceInputStream(f1, f2)
    var c = f_in.read()
    while (c != -1) {
        println(c.toChar())
        c = f_in.read()
    }
    f1.close()
}