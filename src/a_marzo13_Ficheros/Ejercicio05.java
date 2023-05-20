package a_marzo13_Ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio05 {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Introduce argumentos");
        } else {

            try {
                String nombreFichero = args[0];

                FileReader reader = new FileReader(nombreFichero);
                int leer = reader.read();

                while (leer != -1) {
                    System.out.print((char)leer);
                    leer = reader.read();
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
