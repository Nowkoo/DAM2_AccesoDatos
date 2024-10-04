package Tema2.Ejercicios

import java.io.File

fun main() {
    val f = File("./Recursos/pluginfiddddle.bmp")

    try {
        val fi = FitxerImatge(f)

        fi.transformaNegatiu()
        fi.transformaObscur()
        fi.transformaBlancNegre()

    } catch (e: Exception) {}
}