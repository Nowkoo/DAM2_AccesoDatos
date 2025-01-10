package tema_mongodb.exemples

import com.mongodb.MongoClient
import jdk.jfr.internal.LogLevel
import org.bson.Document
import java.util.logging.Level
import java.util.logging.LogManager

fun main() {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val con = MongoClient("localhost", 27017)
    val bd = con.getDatabase("test")

    val stock = Document()
    stock.put("enstock", true)

    val llibres = bd.getCollection("libro").find(stock)

    for (llibre in llibres) {
        println("El libro: < ${llibre.get("titulo")}> está en stock.")
    }

    con.close()
}