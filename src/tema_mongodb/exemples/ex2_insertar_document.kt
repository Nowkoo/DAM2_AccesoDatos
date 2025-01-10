package tema_mongodb.exemples

import com.mongodb.MongoClient
import org.bson.Document

fun main() {
    val con = MongoClient("localhost", 27017)
    val bd = con.getDatabase("test")
    val doc = Document()
    doc.put("msg4", "Missatge inserit des de Kotlin")
    bd.getCollection("exemple").insertOne(doc)
    con.close()
}