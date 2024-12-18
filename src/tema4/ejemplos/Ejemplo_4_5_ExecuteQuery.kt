package tema4.ejemplos

import java.sql.DriverManager

//fun main() {
//    val url = "jdbc:postgresql://89.36.214.106:5432/geo_ad"
//    val usuari = "geo_ad"
//    val password = "geo_ad"
//
//    val con = DriverManager.getConnection(url, usuari, password)
//
//    val st = con.createStatement()
//    val rs = st.executeQuery("select * from institut")
//    while (rs.next()) {
//        println("" + rs.getInt(1) + "\t")
//        println(rs.getString(2))
//    }
//
//    st.close()
//    con.close()
//}

fun main() {
    val url = "jdbc:mysql://89.36.214.106:3306/factura"
    val usuari = "factura"
    val password = "factura"

    val con = DriverManager.getConnection(url, usuari, password)

    val st = con.createStatement()
    val rs = st.executeQuery("select * from article")
    while (rs.next()) {
        println("" + rs.getString(1) + "\t")
        println(rs.getString(2))
    }

    st.close()
    con.close()
}