package tema7_jedis.exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()

    con.sadd("colors", "amarillo", "verde")
    val s = con.smembers("colors")
    for (e in s) {
        println(e)
    }

    con.close()
}