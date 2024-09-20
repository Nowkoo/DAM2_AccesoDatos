package Tema2.Ejemplos

import java.io.ByteArrayInputStream

fun main(args: Array<String>) {
    val ent_1 = "Esto es un byte array"
    val f_in = ByteArrayInputStream(ent_1.toByteArray())
    var c = f_in.read()
    while (c != -1) {
        println(c.toChar())
        c = f_in.read()
    }
    f_in.close()
}