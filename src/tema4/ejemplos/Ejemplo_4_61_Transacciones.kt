package tema4.ejemplos

import java.sql.Connection
import java.sql.DriverManager

fun main() {
    val con = DriverManager.getConnection("jdbc:sqlite:proveta.sqlite")

    resumEmpleats(con)

    val autocommit = con.getAutoCommit()
    con.setAutoCommit(false)
    val st = con.createStatement()
    st.executeUpdate("UPDATE Empleats SET sou = sou * 1.05")
    st.executeUpdate("DELETE FROM Empleats WHERE depart=10")

    resumEmpleats(con)

    con.rollback()

    resumEmpleats(con)

    con.setAutoCommit(autocommit)

    con.close()
}

fun resumEmpleats(c: Connection) {
    val st = c.createStatement()
    val rs = st.executeQuery("select count(*), sum(sou) from Empleats")
    rs.next()
    println("Actualment hi ha ${rs.getInt(1)} empleats que cobren un total de ${rs.getDouble(2)} euros")
    rs.close()
    st.close()
}