package tema3.ejemplos

import java.io.RandomAccessFile
import java.util.Scanner

fun main(args: Array<String>) {
    val f = RandomAccessFile("Recursos/Empleats2.dat", "r")  // Solo lectura
    val sc = Scanner(System.`in`)
    println("Quin registre? (-1 per a eixir): ")
    var num = readLine()?.toIntOrNull() ?: -1

    while (num != -1) {
        // Establecemos un desplazamiento en bytes
        var posicion = 0L  // Inicia desde el principio

        // Bucle para recorrer los registros
        while (posicion < f.length()) {
            f.seek(posicion)  // Nos movemos a la posición actual

            // Leemos el entero que representa el número de registro
            val numero = f.readInt()

            // Leemos el nombre, incluyendo su longitud
            val nombre = f.readUTF()  // Esto maneja automáticamente el desplazamiento de la cadena

            // Leemos los otros datos
            val departament = f.readInt()
            val edat = f.readInt()
            val sou = f.readDouble()

            // Verificamos si el número leído coincide con el solicitado
            if (numero == num) {
                // Solo imprimimos el registro que corresponde al número solicitado
                println("Núm.: $numero")
                println("Nom: $nombre")
                println("Depart: $departament")
                println("Edat: $edat")
                println("Sou: $sou")
                println()
                break
            }

            // Calculamos el tamaño del registro actual
            // 4 bytes para el número,
            // 2 bytes para la longitud de la cadena,
            // longitud de la cadena en bytes,
            // 4 bytes para el departamento,
            // 4 bytes para la edad y
            // 8 bytes para el sueldo.
            posicion += 4 + 2 + (nombre.toByteArray(Charsets.UTF_8).size) + 4 + 4 + 8
        }

        println("Quin registre? (-1 per a eixir): ")
        num = sc.nextInt()
    }
    f.close()

//    Uso de nombre.toByteArray(Charsets.UTF_8).size:
//    Este cambio permite calcular el tamaño exacto de la cadena que se está leyendo
//    del archivo. writeUTF() guarda una cadena con su longitud al inicio, lo que
//    significa que la longitud de la cadena no es fija. Al leer, necesitamos tener en
//    cuenta tanto la longitud de la cadena como los bytes adicionales que writeUTF() añade
//    (2 bytes para la longitud).
}
