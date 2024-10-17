package Tema1.Ejemplos

import java.io.File

fun main() {
//    En linux 0 es la raiz, en Windows 0 es el disco principal y 1, 2, 3 el resto de discos
    println(File.listRoots()[0])
}