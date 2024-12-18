package tema3.ejercicios

import java.io.FileInputStream

fun main() {

// Este exemple no està ben fet (no va), pero l'objectiu era veure que no és
    // pràctic llegir distints tipus de dades bàsiques amb streams de bytes
    // perquè segons el tipus de dada es llegiràn quantitats distintes de bytes
    // que després s'hauràn de col.locar en la seua posició correcta, etc.
    // En aquest tema veurem alternatives per a llegir fitxers que continguen
    // dades de distint tipus (DataInputStream o RandomAccessFile, per exemple).

// Para leer un archivo con números, si cada int son 32 bytes, necesitaremos leer 4 veces por número.
    val f_in = FileInputStream("Recursos/f6.txt")

    var byte1 = f_in.read()
    var byte2 = f_in.read()
    var byte3 = f_in.read()
    var byte4 = f_in.read()

    while (byte1 != -1 || byte2 != -1 || byte3 != -1 || byte4 != -1) {
        var mi_entero = (byte1 shl 24) or (byte2 shl 16) or (byte1 shl 8) or byte4
        println(mi_entero)

        byte1 = f_in.read()
        byte2 = f_in.read()
        byte3 = f_in.read()
        byte4 = f_in.read()
    }

    f_in.close()
}