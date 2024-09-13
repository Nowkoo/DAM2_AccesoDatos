package Ejemplos;

import java.io.File;
import java.util.Arrays;

public class Ejemplo_1_1 {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println("Lista de ficheros y directorios del directorio actual");
        System.out.println("---------------------------------------------------");

        for (String currentFile : Arrays.stream(file.list()).sorted().toList()) {
            System.out.println(currentFile);
        }
    }
}
