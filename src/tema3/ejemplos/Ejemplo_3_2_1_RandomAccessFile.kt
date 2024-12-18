package tema3.ejemplos

import java.io.RandomAccessFile
fun main(args: Array<String>) {
//    El segon paràmetre indica el mode: r -> només lectura, w -> lectura i escriptura
    val f = RandomAccessFile("Recursos/Empleats.dat", "r")
    f.seek(56)
    println("Núm.: " + f.readInt())
    println("Nom: " + f.readUTF())
    println("Depart: " + f.readInt())
    println("Edat: " + f.readInt())
    println("Sou: " + f.readDouble())
    f.close()
}