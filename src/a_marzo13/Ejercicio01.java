package a_marzo13;

import java.io.File;

public class Ejercicio01 {

    public static void main(String[] args) {

        File file = new File(".");

        File[] archivos = file.listFiles();

        for(int i = 0 ; i < archivos.length; i++ ){
            System.out.println("Archivos en el directorio" + archivos[i]);
        }


    }
}