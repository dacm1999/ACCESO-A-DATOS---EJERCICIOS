package a_marzo13;

import java.io.*;
import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("MiFichero.txt"));

            String [] cadenaTexto = new String[25];

            for(int i = 0 ; i < cadenaTexto.length; i++){
                cadenaTexto [i] = reader.readLine();
//                System.out.println(cad[i]);
            }

//            System.out.println("Introduce el nombre del fichero");
//            Scanner sc = new Scanner(System.in);
//            String nombre = sc.nextLine();

            File file = new File("copiaMiFichero.txt");
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            System.out.println("Fichero creado");

            char [] ch = null;

            for(int i = 0; i < 10; i++){
                ch = cadenaTexto[i].toCharArray();

                for(int j = 0; j < ch.length; j++){
                    if(ch[j] == 'a'){
                        writer.write('e');
                    }else if(ch[j] == 'e'){
                        writer.write('o');
                    }else if(ch[j] == 'Á'){
                        writer.write("É");
                    }else if(ch[j] == 'É'){
                        writer.write('Ó');
                    }else {
                        writer.write(ch[j]);
                    }
                }
                writer.write("\n");
            }

            System.out.println("10 primeras lineas tratadas");

            for(int i = 10; i < 20; i ++){
                writer.write(cadenaTexto[i]);
                writer.append('&');
                writer.newLine();
            }

            int cont = 0;

            for(int i = 20; i < 25; i++){
                ch = cadenaTexto[i].toCharArray();
                for(int j = 0; j < ch.length; j++){
                    cont++;
                    if(cont == 4){
                        writer.write('$');
                        cont = 0;
                    }
                    writer.write(ch[j]);
                }
                writer.write("\n");
            }

            reader.close();
            writer.close();

            System.out.println("Fichero compleado");

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        }

    }
}
