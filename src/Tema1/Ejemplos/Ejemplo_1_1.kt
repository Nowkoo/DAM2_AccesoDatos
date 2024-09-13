package Ejemplos

import java.io.File
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val f = File(".")
    println("Lista de ficheros y directorios del directorio actual")
    println("---------------------------------------------------")
    for (e in f.list().sorted())
        println(e)

    var l = Libro("a", "b", "c", 1);
    println(l.getCodigo())

    //En linux 0 es la raiz, en Windows 0 es el disco principal y 1, 2, 3 el resto de discos
    println(File.listRoots()[0])
}

class Libro(
    private var codigo: String,
    private var titulo: String,
    private val autor: String,
    private val numPaginas: Int
) {
    init{
        //lógica adicional
    }

    fun getCodigo(): String {
        return codigo
    }

    fun setCodigo(codigo: String) {
        if (codigo.isNotEmpty())
            this.codigo = codigo
    }
}