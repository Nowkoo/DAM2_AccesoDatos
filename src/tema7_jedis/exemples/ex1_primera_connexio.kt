package tema7_jedis.exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()
    con.close()
}