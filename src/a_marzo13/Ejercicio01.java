package a_marzo13;

import java.io.File;

public class Ejercicio01 {

    public static void main(String[] args) {
        File f = new File(".");

        System.out.println("--------------RUTA ACTUAL--------------");
        System.out.println(f.getAbsolutePath());

        System.out.println("");

        String archivos[] = f.list();
        System.out.println("--------------ARCHIVOS--------------");
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);
        }


    }
}