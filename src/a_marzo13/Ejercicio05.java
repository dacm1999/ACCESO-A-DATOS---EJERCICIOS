package a_marzo13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio05 {
    public static void main(String[] args) {

        if(args.length !=1){
            System.out.println("Introduce un nombre");
        }else{
            try{
                String fichero = args[0];
                FileReader reader = new FileReader(fichero);

                int leer = reader.read();

                while (leer != -1){
                    System.out.print((char)leer);
                    leer = reader.read();
                }

            } catch (FileNotFoundException e) {
                System.out.println("ERROR" + e.getMessage());
            } catch (IOException e) {
                System.out.println("ERROR" + e.getMessage());
            }


        }

    }
}
