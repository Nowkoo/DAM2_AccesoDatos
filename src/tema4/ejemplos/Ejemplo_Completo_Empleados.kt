package tema4.ejemplos

import java.sql.DriverManager


fun main() {
    crearTaulaEmpleats()
//    insertarEmpleats()
    actualitzarEmpleats()
    mostrarEmpleats()
}

private fun crearTaulaEmpleats() {
    val url = "jdbc:sqlite:./proveta.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    val sentSQL = "CREATE TABLE IF NOT EXISTS EMPLEATS (" +
            "num INTEGER CONSTRAINT cp_emp PRIMARY KEY," +
            "nom TEXT," +
            "depart INTEGER," +
            "edat INTEGER," +
            "sou REAL);"

    st.execute(sentSQL)
    con.close()
}

private fun insertarEmpleats() {
    val url = "jdbc:sqlite:./proveta.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("INSERT INTO EMPLEATS VALUES (1, 'Andreu', 10, 32, 1000.0)")
    st.executeUpdate("INSERT INTO EMPLEATS VALUES (2, 'Bernat', 20, 28, 1200.0)")
    st.executeUpdate("INSERT INTO EMPLEATS VALUES (3, 'Clàudia', 10, 26, 1100.0)")
    st.executeUpdate("INSERT INTO EMPLEATS VALUES (4, 'Damià', 10, 40, 1500.0)")

    st.close()
    con.close()
}

private fun actualitzarEmpleats() {
    val url = "jdbc:sqlite:./proveta.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("UPDATE EMPLEATS SET sou = sou * 1.05;")
    st.executeUpdate("UPDATE EMPLEATS SET depart = 20 WHERE num = 3;")

    st.close()
    con.close()
}

private fun mostrarEmpleats() {
    val url = "jdbc:sqlite:./proveta.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    val sentenciaSQL = "SELECT * FROM EMPLEATS WHERE sou > 1100"
    val rs = st.executeQuery(sentenciaSQL)

    println("Núm. \tNom \tDep \tEdat \tSou")
    println("--------------------------------------")

    while (rs.next()) {
        print("${rs.getInt(1)}\t")
        print("${rs.getString(2)}\t")
        print("${rs.getInt(3)}\t")
        print("${rs.getInt(4)}\t")
        println("${rs.getInt(5)}\t")
    }
}