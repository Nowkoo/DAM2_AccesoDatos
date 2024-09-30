package Tema2.Ejemplos

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.FileReader
import java.io.FileWriter

fun main() {
//    val text = "Contingut per al fitxer"
//    val f_out = FileOutputStream("Recursos/f3.txt")
//    for (c in text) {
//        f_out.write(c.toInt())
//    }
//    f_out.close()

    //Cuando no quedan bytes que leer se queda el contenido de los últimos que se habían leído.
//    val f_in = FileInputStream("Recursos/f1.txt")
//    var buffer = ByteArray(2)
//    for (i in 1..4) {
//        try {
//            var num = f_in.read(buffer)
//            println("$num: ${buffer[0].toChar()}, ${buffer[1].toChar()}} ")
//        } catch (e: Exception) {
//            println(e.message)
//        }
//    }


    //Con  f_out.write(buffer, 0, bytesRead)  solo escribimos del buffer la cantidad de bytes leída en la iteración.
//    val f_in = FileInputStream("Recursos/ex_2_12.txt")
//    val f_out = FileOutputStream("Recursos/ex_2_12_copia.txt")
//    var buffer = ByteArray(30)
//    var bytesRead = f_in.read(buffer)
//    while (bytesRead != -1) {
//        f_out.write(buffer, 0, bytesRead)
//        bytesRead = f_in.read(buffer)
//    }
//    f_out.close()
//    f_in.close()


    //Las líneas escritas las introduce el usuario
    while(true) {
        var input = readLine()!!
        if (input.isEmpty()) input = ""
        else if (input.equals("-1")) break

        val f_out = FileWriter("Recursos/f5.txt", true)
        for (c in input) {
            f_out.write(c.toInt())

        }
        f_out.write("\n")
        f_out.close()
    }
}