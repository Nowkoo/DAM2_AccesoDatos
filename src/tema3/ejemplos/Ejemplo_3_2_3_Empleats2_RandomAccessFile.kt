package tema3.ejemplos

import java.io.RandomAccessFile
import java.util.Scanner

//PROBLEMA: La longitud total del registro no es constante debido a
// las cadenas que se almacenan con writeUTF(). El tamaño de la cadena
// puede variar, y si no calculas correctamente el desplazamiento (usando seek()),
// puedes terminar intentando leer más datos de los que realmente hay.
// El tamaño del UTF es variable (depende del tamaño de la cadena que se introduzca)!!!!
fun main(args: Array<String>) {
    val f = RandomAccessFile("Recursos/Empleats2.dat", "rw")
    val sc = Scanner(System.`in`)
    println("Quin registre? (-1 per a eixir): ")
    var num = sc.nextInt ()

    while (num != -1) {
        f.seek(32 * (num - 1).toLong())
        println("Núm.: " + f.readInt())
        println("Nom: " + f.readUTF())
        println("Depart: " + f.readInt())
        println("Edat: " + f.readInt())
        println("Sou: " + f.readDouble())
        println()
        println("Quin registre? (-1 per a eixir): ")
        num = sc.nextInt()
    }
    f.close()

    //  Al utilizar writeUTF() para almacenar cadenas (nombres), el tamaño total del registro
//  ya no es constante. Esto se debe a que writeUTF() almacena una cadena de forma que
//  incluye un prefijo que indica la longitud de la cadena en bytes. Por lo tanto,
//  cuando intentas calcular la posición del registro con seek(), la suposición de que
//  cada registro ocupa un tamaño fijo (32 bytes en tu caso) es incorrecta.
//
//  Escritura con writeUTF():
//  writeUTF() escribe una cadena precedida por un entero que indica su longitud. Por lo tanto,
//  la cantidad de bytes ocupados por el nombre depende de la longitud del nombre mismo.
//  Por ejemplo, si el nombre "Andreu" tiene 6 caracteres, se almacenarán 8 bytes
//  (2 bytes para el tamaño + 6 bytes para los caracteres), mientras que "Clàudia" puede
//  ocupar 8 bytes (2 bytes para el tamaño + 6 bytes para los caracteres), pero esto cambiará
//  si usas caracteres de diferentes longitudes o codificaciones.

//  Lectura con seek():
//Estás utilizando f.seek(32 * (num - 1).toLong()), lo que supone que cada registro ocupa
// exactamente 32 bytes. Esto es incorrecto si usas writeUTF(), ya que la longitud del nombre
// no es fija.
}