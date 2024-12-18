package tema3.ejemplos.JSONMoshi

class Empleat (
    var num: Int,
    var nom: String,
    var departament: Int,
    var edat: Int,
    var sou: Double
)
class Empleats(val empleats: List<Empleat> = listOf<Empleat>())

class Empresa(val empresa: Empleats)

class Estacio(
    val id: Long,
    val punto: String,
    val puestos: Int,
    val ocupados: Int,
    val latitud: Double,
    val longitud: Double,
    val porcentajeAltaOcupacion: Int,
    val porcentajeBajaOcupacion: Int
)

class Estacions(
    val ocupacion: List<Estacio> = listOf<Estacio>()
)

class EstDesti (
    val num: Int,
    val nom: String,
    val llocs: Int,
    val ocupats: Int,
    val lliures: Int
)

class Bicicas2 (val bicicas: List<EstDesti>)