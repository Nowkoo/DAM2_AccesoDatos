package Tema2.Ejercicios

import jdk.incubator.vector.VectorOperators.Binary
import java.io.*
import java.nio.charset.Charset

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


//    Copia de un fichero a otro utilizando un buffer de bytes. Con  f_out.write(buffer, 0, bytesRead)  solo escribimos del buffer la cantidad de bytes leída en la iteración.
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


//    Las líneas escritas las introduce el usuario
//    while(true) {
//        var input = readLine()!!
//        if (input.isEmpty()) input = ""
//        else if (input.equals("-1")) break
//
//        val f_out = FileWriter("Recursos/f5.txt", true)
//        for (c in input) {
//            f_out.write(c.toInt())
//
//        }
//        f_out.write("\n")
//        f_out.close()
//    }


//    Listado de sistemas de codificación soportados por Java
//    val availableCharset = Charset.availableCharsets().values
//
//    for (charset in availableCharset) {
//        val charsetName = charset.name()
//        println(charsetName)
//    }


//    Si no imprimimos c.toChar() vemos el valor decimal asociado a ese caracter en ASCII
//    val f_in = FileReader("Recursos/f1.txt")
//    var c = f_in.read()
//    while (c != -1) {
//        println(c)
//        c = f_in.read()
//    }
//    f_in.close()


//    En este caso da igual poner toChar() que no ponerlo, porque se almacenan como caracteres y no como enteros.
//    val f_in = FileReader("Recursos/f2.txt")
//    var buffer = CharArray(30)
//    var n = f_in.read(buffer)
//    while (n != -1) {
//        for (i in 0..n - 1) {
//            println(buffer[i].toChar())
//            n = f_in.read(buffer)
//        }
//        f_in.close()
//    }


//    Copia de un fichero a otro utilizando un buffer de caracteres
//    val f_in = FileReader("Recursos/ex_2_12.txt")
//    val f_out = FileWriter("Recursos/ex_2_12_copia.txt")
//    var buffer = CharArray(30)
//    var charsRead = f_in.read(buffer)
//    while (charsRead != -1) {
//        f_out.write(buffer, 0, charsRead)
//        charsRead = f_in.read(buffer)
//    }
//    f_out.close()
//    f_in.close()


//    Más fácil todavía
//    val f_in = FileReader("Recursos/ex_2_12.txt")
//    val f_out = FileWriter("Recursos/ex_2_12_copia.txt")
//
//    var texto = f_in.readText()
//    f_out.write(texto)
//
//    f_out.close()
//    f_in.close()


//    O en una línea
//    val f_in = FileReader("Recursos/ex_2_12.txt")
//    val f_out = FileWriter("Recursos/ex_2_12_copia.txt")
//
//    f_in.copyTo(f_out)
//
//    f_out.close()
//    f_in.close()

}