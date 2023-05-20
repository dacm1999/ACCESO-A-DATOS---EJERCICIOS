package a_marzo13_Ficheros;

import java.io.*;
import java.util.Calendar;

public class Ejercicio07 {


    public static void main(String[] args) {

        try {
            File fichero = new File("info.txt");
            BufferedReader reader1 = new BufferedReader(new FileReader("alumnos.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("anyos.txt"));
            BufferedWriter escribir2 = new BufferedWriter(new FileWriter(fichero));
            BufferedReader reader3 = new BufferedReader(new FileReader(fichero));


            String linea1;
            String linea2;
            String linea3;

            while (((linea1 = reader1.readLine()) != null) && ((linea2 = reader2.readLine()) != null)) {
                String[] anoNacimiento = linea2.split(" ");
                String[] nombres = linea1.split(" ");

                int[] ano = new int[anoNacimiento.length];

                for (int i = 0; i < anoNacimiento.length; i++) {
                    ano[i] = Integer.parseInt(anoNacimiento[i]);
                }

                for (int i = 0; i < nombres.length; i++) {

                    // Calcula la edad a partir del año de nacimiento
                    Calendar cal = Calendar.getInstance();
                    int edad = cal.get(Calendar.YEAR) - ano[i];
                    String mayorEdad;
                    // Comprueba si la persona es mayor de edad
                    if(edad >= 18){
                        mayorEdad = "S";
                    }else{
                        mayorEdad = " N";
                    }
                    // Escribe los datos en el fichero
                    escribir2.write(nombres[i] + " " + ano[i] + " " + edad + " " + mayorEdad);
                    escribir2.newLine();
                    escribir2.flush();
                }

            }
            reader1.close();
            reader2.close();
            escribir2.close();


            System.out.println("--------------------FICHERO ALUMNOS.TXT--------------------");
            reader1 = new BufferedReader(new FileReader("alumnos.txt"));
            if(((linea1 = reader1.readLine()) == null)){
                System.out.println("----------FICHERO ALUMNOS.TXT VACIO");
            }else{
                do{
                    System.out.println(linea1);
                }while((linea1 = reader1.readLine()) != null);
            }

            reader1.close();

            System.out.println("--------------------FICHERO ANYOS.TXT--------------------");
            reader2 = new BufferedReader(new FileReader("anyos.txt"));

            if((linea2 = reader2.readLine()) == null){
                System.out.println("----------FICHERO ANYOS.TXT VACIO");
            }else{
                do{
                    System.out.println(linea2);
                }while ((linea2 = reader2.readLine()) != null);
            }
            reader2.close();


            System.out.println("--------------------FICHERO INFO.TXT--------------------");
            if((linea3 = reader3.readLine()) == null){
                System.out.println("----------FICHERO ANYOS.TXT VACIO");
            }else{
                do{
                    System.out.println(linea3);
                }while ((linea3 = reader3.readLine()) != null);
            }
            reader3.close();



        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

}
