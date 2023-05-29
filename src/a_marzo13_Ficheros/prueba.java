package a_marzo13_Ficheros;

import java.io.*;

public class prueba {


    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("MiFichero.txt"));

            String[] lineas = new String[25];

            for (int i = 0; i < lineas.length; i++) {
                lineas[i] = reader.readLine();
                System.out.println(lineas[i]);
            }


            char[] caracteres = null;
            File file = new File("Copia10.txt");
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            System.out.println("Fichero creado ");


            for (int i = 0; i < 10; i++) {
                caracteres = lineas[i].toCharArray();

                for (int j = 0; j < caracteres.length; j++) {
                    if (caracteres[j] == 'a') {
                        writer.write('e');
                    } else if (caracteres[j] == 'e') {
                        writer.write('o');
                    } else if (caracteres[j] == 'Á') {
                        writer.write("É");
                    } else if (caracteres[j] == 'É') {
                        writer.write('Ó');
                    } else {
                        writer.write(caracteres[j]);
                    }

                }
                writer.write("\n");
            }


            System.out.println("Linea 0 - 10 tratadas");

            for(int i = 10; i < 20; i++){
                writer.write(lineas[i]);
                writer.append("&");
                writer.newLine();
            }
            System.out.println("Linea 10 - 20 tratadas ");

            int contador = 0;
            for(int i = 20; i < 25; i++){

                for(int j = 0; i < caracteres.length; j++){
                    caracteres = lineas[i].toCharArray();
                    contador ++;
                    if(contador == 4){
                        writer.write('$');
                        contador = 0;
                    }
                    writer.write(caracteres[j]);
                }
                writer.write("\n");

            }

            System.out.println("Linea 20 - 25 tratada");

            writer.close();
            reader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
