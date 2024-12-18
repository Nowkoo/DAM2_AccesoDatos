package tema3.ejemplos

import java.io.RandomAccessFile
import java.util.Scanner
fun main(args: Array<String>) {
    val f = RandomAccessFile("Recursos/Empleats3.dat", "r") // Solo lectura
    val sc = Scanner(System.`in`)
    println("Quin registre? (-1 per a eixir): ")
    var num = sc.nextInt()

    while (num != -1) {
        f.seek(40 * (num - 1).toLong()) // Desplazamiento correcto
        println("Núm.: " + f.readInt())

        var nom = StringBuilder()
        for (i in 1..10) {
            nom.append(f.readChar()) // Lee 10 caracteres (20 bytes)
        }
        println("Nom: $nom")
        println("Depart: " + f.readInt())
        println("Edat: " + f.readInt())
        println("Sou: " + f.readDouble())
        println()
        println("Quin registre? (-1 per a eixir): ")
        num = sc.nextInt()
    }
    f.close()
}