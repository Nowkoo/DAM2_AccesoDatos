package tema2.ejercicios

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FitxerImatge(fEnt: File) {
    var file: File = File("")

    init {
        if (fEnt.exists() && fEnt.extension.equals("bmp")){
            file = fEnt
        } else if (!fEnt.exists()) {
            println("ERROR: archivo no encontrado!!")
        } else if (!fEnt.extension.equals("bmp")) {
            println("ERROR: no es un .bmp!!")
        }
    }

    fun transformaNegatiu() {
        val f_in = FileInputStream(file)
        val f_out = FileOutputStream(File("./Recursos/${file.nameWithoutExtension}_n.bmp"))

        f_out.write(f_in.readNBytes(54))
        while (f_in.available() > 0) {
            f_out.write(255 - f_in.read())
        }

        f_in.close()
        f_out.close()
    }

    fun transformaObscur() {
        val f_in = FileInputStream(file)
        val f_out = FileOutputStream(File("./Recursos/${file.nameWithoutExtension}_o.bmp"))

        f_out.write(f_in.readNBytes(54))
        while (f_in.available() > 0) {
            f_out.write(f_in.read()/2)
        }

        f_in.close()
        f_out.close()
    }

    fun transformaBlancNegre() {
        val f_in = FileInputStream(file)
        val f_out = FileOutputStream(File("./Recursos/${file.nameWithoutExtension}_bn.bmp"))

        f_out.write(f_in.readNBytes(54))
        while (f_in.available() > 0) {
            var r = f_in.read()
            var g = f_in.read()
            var b = f_in.read()
            var media = (r + g + b) / 3

            f_out.write(media)
            f_out.write(media)
            f_out.write(media)
        }

        f_in.close()
        f_out.close()
    }
}

fun main() {
    val f = File("./Recursos/pluginfile.bmp")

    try {
        val fi = FitxerImatge(f)

        fi.transformaNegatiu()
        fi.transformaObscur()
        fi.transformaBlancNegre()

    } catch (e: Exception) {}
}