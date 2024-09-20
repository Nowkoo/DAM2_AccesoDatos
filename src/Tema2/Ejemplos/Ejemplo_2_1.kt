package Tema2.Ejemplos

import java.io.File
import java.io.FileInputStream

fun main(args: Array<String>) {
    val f_in = FileInputStream("Recursos/f1.txt")
    var c = f_in.read()
    while (c != -1) {
        println(c.toChar())
        c = f_in.read()
    }
    f_in.close()

    otroConstructor()
}

fun otroConstructor() {
    val f = File("Recursos/f1.txt")
    val f_in = FileInputStream(f)
    var c = f_in.read()
    while (c != -1) {
        println(c.toChar())
        c = f_in.read()
    }
    f_in.close()
}