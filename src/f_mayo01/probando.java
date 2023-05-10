package f_mayo01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class probando {

    public static void main(String[] args) {


        try {
            BufferedReader reader = new BufferedReader(new FileReader("Fichero1"));

            String lineas = "";

            if((lineas = reader.readLine()) == null){
                System.out.println("Fichero vacio");
            }else {
                do {
//                    System.out.println(linea2);

                    System.out.println(lineas);

                } while ((lineas = reader.readLine()) != null);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
