package a_marzo13_Ficheros;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Calendar;

import static java.time.LocalDateTime.now;

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

        LocalDateTime date = now();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();

    }
}