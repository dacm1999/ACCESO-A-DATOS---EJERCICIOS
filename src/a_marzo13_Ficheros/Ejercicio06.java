package a_marzo13_Ficheros;

import java.io.*;

public class Ejercicio06 {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("MiFichero.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("CopiaFichero12.txt"));
            String[] lineas = new String[25];

            for (int i = 0; i < lineas.length; i++) {
                lineas[i] = reader.readLine();
            }

            char[] caracteres = null;

            for (int i = 0; i < 10; i++) {
                caracteres = lineas[i].toCharArray();

                for (int k = 0; k < caracteres.length; k++) {
                    if (caracteres[k] == 'a') {
                        writer.write('e');
                    } else if (caracteres[k] == 'e') {
                        writer.write('o');
                    } else if (caracteres[k] == 'Á') {
                        writer.write("É");
                    } else if (caracteres[k] == 'É') {
                        writer.write('Ó');
                    } else {
                        writer.write(caracteres[k]);
                    }
                }
                writer.newLine();
            }
            System.out.println("Linea 1 - 10 tratadas");


            for(int i = 10; i < 20; i++){
                writer.write(lineas[i]);
                writer.append('&');
                writer.newLine();
            }
            System.out.println("Linea 10 - 20 tratadas");

            int contador = 0;
            for(int i = 20; i < 25; i++){
                caracteres = lineas[i].toCharArray();
                for(int j = 0; j < caracteres.length; j++){
                    contador++;
                    if(contador == 4){
                        writer.write('$');
                        contador = 0;
                    }
                    writer.write(caracteres[j]);
                }
                writer.write("\n");
            }

            System.out.println("Linea 20 - 25 tratadas");
            reader.close();
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("ERROR I/O");
        }

    }
}
