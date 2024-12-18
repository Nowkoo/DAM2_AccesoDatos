package tema7_jedis.exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()

    con.hset("hash1", "camp1", "valor1")
    con.hset("hash1", "camp2", "valor2")

    con.hset("hash1", mapOf(
        Pair("camp3", "valor3"),
        Pair("camp4", "valor4")
    ))

    val subcamps = con.hkeys("hash1")
    for (subcamp in subcamps) {
        println("$subcamp: ${con.hget("hash1", subcamp)}")
    }
    con.close()
}