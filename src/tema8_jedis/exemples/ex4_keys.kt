package tema8_jedis.exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()

    val c = con.keys("*")
    for (key in c) {
        println(key)
    }

    con.close()
}