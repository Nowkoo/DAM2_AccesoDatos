package tema8_jedis.exercicis

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()

    do {
        val keys = con.keys("*").toList()

        keys.forEachIndexed { index, key ->
            println("${index + 1}.- $key (${con.type(key)})")
        }

        println("Introdueix un número (0 per a eixir)")
        val opcio = readln().toInt()

        when {
            opcio == 0 -> System.exit(0)
            opcio in 1..keys.size -> {
                val clauEscollida = keys[opcio - 1]
                mostrarValorClau(clauEscollida, con)
            }
            else -> println("Opción inválida, prueba otra vez:")
        }

    } while (true)

    con.close()
}

fun mostrarValorClau(clau: String, con: Jedis) {
    val tipus = con.type(clau)

    when (tipus) {
        "string" -> println("$clau: ${con.get(clau)}")
        "list" -> println("$clau: ${con.lrange(clau, 0, -1)}")
        "set" -> println("$clau: ${con.smembers(clau)}")
        "zset" -> println("$clau: ${con.zrangeWithScores(clau, 0, -1)}")
        "hash" -> println("$clau: ${con.hgetAll(clau)}")
    }
}