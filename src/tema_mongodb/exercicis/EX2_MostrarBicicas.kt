package tema_mongodb.exercicis

import com.mongodb.MongoClient

fun main() {
    val con = MongoClient("localhost", 27017)
    val bd = con.getDatabase("test")
    val estacions = bd.getCollection("bicicas").find()

    for (estacio in estacions) {
        println("${estacio.get("_id")}.- ${estacio.get("punto")} (${estacio.get("ocupados")}/${estacio.get("puestos")})")
    }

    con.close()
}