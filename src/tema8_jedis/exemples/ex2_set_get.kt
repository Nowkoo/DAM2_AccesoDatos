package tema8_jedis.exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()

    con.set("clau_1", "hola")
    println(con.get("clau_1"))
    con.close()
}