package Tema2.Ejemplos

import java.io.FileReader

fun main() {
    val f_in = FileReader("Recursos/f2.txt")
    var buffer = CharArray(30)
    var n = f_in.read(buffer)
    while (n != -1) {
        for (i in 0..n - 1) {

        }
    }
}