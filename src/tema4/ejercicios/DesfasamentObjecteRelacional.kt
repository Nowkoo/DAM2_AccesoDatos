package tema4.ejercicios

data class Comarca(
    val provincia: String,
    val nom: String
)

data class Poblacio(
    val nom: String,
    val poblacio: Int,
    val extensio: Double,
    val altura: Int,
    val longitud: String,
    val latitud: String,
    val llengua: String,
    val comarca: Comarca //cod_c
)

data class Institut(
    val adreca: String,
    val codpostal: Int,
    val nom: String,
    val numero: String,
    val poblacio: Poblacio //cod_m
)