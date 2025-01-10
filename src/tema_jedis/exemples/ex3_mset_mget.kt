package tema_jedis.exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()

    con.mset("mes1", "enero", "mes2", "febrero", "mes3", "marzo")
    val c = con.mget("mes1", "mes2", "mes3")
    println(c)

    con.close()
}