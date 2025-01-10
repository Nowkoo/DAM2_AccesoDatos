package tema_mongodb.exemples

import com.mongodb.MongoClient

fun main() {
    val con = MongoClient("localhost", 27017)
    val bd = con.getDatabase("test")
    con.close()
}