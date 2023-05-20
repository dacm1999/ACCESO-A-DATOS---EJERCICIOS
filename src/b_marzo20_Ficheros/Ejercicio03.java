package b_marzo20_Ficheros;

import java.io.*;

public class Ejercicio03 {

    public static void main(String[] args) {


        try {

            File ficheroOriginal = new File("articulo2.txt");
            BufferedReader reader = new BufferedReader(new FileReader(ficheroOriginal));

            File ficheroNuevo = new File("texto.txt");

            if(ficheroNuevo.exists()){
                ficheroNuevo.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroNuevo, true));

            String linea;

            while ((linea = reader.readLine()) != null){
                String numeros = linea.replaceAll("[0-9]+","");

//                String operadores = numeros.replaceAll("[A-Z]", "");
//                String cosas = operadores.replaceAll("[¿?é¿ñ,í,ú';.á]", "").strip();
                String operadores = numeros.replaceAll("[+\\-*/]", "");

                writer.write(operadores);
                writer.newLine();

            }

            reader.close();
            writer.close();

            System.out.println("fICHERO ESCRITO " + ficheroNuevo.getName());

            BufferedReader reader2 = new BufferedReader(new FileReader("texto.txt"));
            String linea2;

            if((linea2 = reader2.readLine()) == null){
                System.out.println("Fichero vacio");
            }else{
                do{
//                    System.out.println(linea2);

                    System.out.println(linea2);

                }while ((linea2 = reader2.readLine()) != null);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
