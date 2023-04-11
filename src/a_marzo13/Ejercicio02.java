package a_marzo13;

import java.io.File;

public class Ejercicio02 {

    public static void main(String[] args) {

        if (args.length ==0) {
            System.out.println("Error: Ingresa el nombre del directorio.");
        }
        String ruta = args[0];

        File directorio = new File(ruta);

        if (!directorio.exists()) {
            System.out.println("Error: El directorio " + ruta + " no existe.");
        } else if (!directorio.isDirectory()) {
            System.out.println("Error: " + ruta + " no es un directorio.");
        } else {
            String archivos[] = directorio.list();
            System.out.println("Archivos en el directorio " + ruta + ":");

            for (int i = 0; i < archivos.length; i++) {
                System.out.println(archivos[i]);
            }
        }


    }
}
