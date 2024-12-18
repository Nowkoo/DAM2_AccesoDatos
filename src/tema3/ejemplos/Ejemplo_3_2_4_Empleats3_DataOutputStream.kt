package tema3.ejemplos

import java.io.DataOutputStream
import java.io.FileOutputStream

// SOLUCION: Rellenamos los nombres con espacios en blanco para que ocupen exactamente 10 caracteres.
// Usamos writeChars en lugar de writeUTF de manera que cada caracter ocupa 2 bytes.
// El nombre siempre ocupará 20 bytes (10 caracteres + 2 bytes).
// El tamaño del registro será siempre de 40 bytes
fun main(args: Array<String>) {
    val f = DataOutputStream(FileOutputStream("Recursos/Empleats3.dat"))
    val noms = arrayOf("Andreu    ", "Bernat    ", "Clàudia   ", "Damià     ")
    val departaments = arrayOf(10, 20, 10, 10)
    val edats = arrayOf(32, 28, 26, 40)
    val sous = arrayOf(1000.0, 1200.0, 1100.0, 1500.0)

    for (i in 0..3) {
        f.writeInt(i + 1)
        f.writeChars(noms[i])  // Escribe el nombre (10 caracteres = 20 bytes)
        f.writeInt(departaments[i])
        f.writeInt(edats[i])
        f.writeDouble(sous[i])
    }
    f.close()
    println("Fitxer creat")
}