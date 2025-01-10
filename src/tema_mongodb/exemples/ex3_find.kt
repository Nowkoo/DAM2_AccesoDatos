package tema_mongodb.exemples

import com.mongodb.MongoClient
import org.bson.Document

fun main() {
    val con = MongoClient("localhost", 27017)
    val bd = con.getDatabase("test")
    val llibres = bd.getCollection("libro").find()

    for (llibre in llibres) {
        println(llibre.get("titulo"))
    }

    con.close()
}