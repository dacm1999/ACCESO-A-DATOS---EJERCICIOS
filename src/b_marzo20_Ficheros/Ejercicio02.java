package b_marzo20_Ficheros;

import java.io.*;

public class Ejercicio02 {

    public static void main(String[] args) {


        try {
            BufferedReader reader = new BufferedReader(new FileReader("articulo.txt"));
            int lince = 0;
            int tigre = 0;

            String lineas = "";
            char [] caracteres = null;


            while ((lineas = reader.readLine())!= null){
                caracteres = lineas.toCharArray();

                for(int i = 0; i < caracteres.length; i++){

                    if(caracteres[i] == ' ' && caracteres[i+1] == 'l' &&  caracteres[i+2] == 'i' &&
                            caracteres[i+3] == 'n' && caracteres[i+4] == 'c' &&  caracteres[i+5] == 'e'){
                        lince++;

                    }

                    if(caracteres[i] == ' ' && caracteres[i+1] == 't' &&  caracteres[i+2] == 'i' &&
                            caracteres[i+3] == 'g' && caracteres[i+4] == 'r' &&  caracteres[i+5] == 'e'){
                        tigre++;

                    }
                }
            }

            System.out.println("Tigre " + tigre);
            System.out.println("Lince " + lince);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
