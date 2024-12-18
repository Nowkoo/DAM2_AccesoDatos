package tema7_jedis.exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()

    con.lpush("lista1", "valor1", "valor2")
    val ll = con.lrange("lista1", 0, -1)
    for (e in ll) {
        println(e)
    }

    con.close()
}