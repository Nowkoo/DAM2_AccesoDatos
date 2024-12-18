package tema2.ejemplos

import java.io.File
import java.io.FileInputStream

fun main() {
    val f_in = FileInputStream(File("Recursos/f1.txt"))
    var buffer = ByteArray(2)
    var n = f_in.read(buffer)
    while (n != -1) {
        for (i in 0..n - 1) {
            print(buffer[i].toChar())
        }
        n = f_in.read(buffer)
        println()
    }
    f_in.close()
}