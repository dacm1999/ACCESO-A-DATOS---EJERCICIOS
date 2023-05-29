package a_marzo13_Ficheros;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p2 {

    public static void main(String[] args) {

        try {
            File file = new File("texto.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            char [] caracteres = null;

            int contador = 0;
            int flores = 0;
            String l = "";
            while ((l = reader.readLine())!= null){
//                System.out.println(l);
                caracteres = l.toCharArray();
                for(int i = 0; i < caracteres.length; i++){
                    contador++;

                    if(caracteres[i] == 'f' && caracteres[i+1] == 'l' &&  caracteres[i+2] == 'o' &&
                            caracteres[i+3] == 'r' && caracteres[i+4] == 'e' &&  caracteres[i+5] == 's'){
                        flores++;

                    }
                }
            }

            System.out.println(flores);
            System.out.println(contador);


            String lineas2 = "";
            char [] caracteres2 = null;
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            while ((lineas2 = reader.readLine()) != null) {
                caracteres2 = lineas2.toCharArray();

                for (int i = 0; i < caracteres2.length; i++) {
                    if (caracteres2[i] == 'f') {
                        writer.write('p');
                    } else if (caracteres2[i + 1] == 'l') {
                        writer.write('e');
                    } else if (caracteres2[i + 2] == 'o') {
                        writer.write('r');
                    } else if (caracteres2[i + 3] == 'r') {
                        writer.write('r');
                    } else if (caracteres2[i + 4] == 'e') {
                        writer.write('a');
                    } else if (caracteres2[i + 5] == 's') {
                        writer.write('s');
                    } else {
                        writer.write(caracteres2[i]);
                    }
                }

                writer.write("\n");
            }
            writer.close();


            reader.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
