package g_examenes.Ficheros.Examen03;

import java.io.*;
import java.time.Year;
import java.util.Calendar;

public class Prueba {

    public static void main(String[] args) {

        try {
            BufferedReader leerAnyos = new BufferedReader(new FileReader(new File("anyos.txt")));
            BufferedReader leerAlumnos = new BufferedReader(new FileReader(new File("alumnos.txt")));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("info.txt")));
            BufferedReader leerInfo = new BufferedReader(new FileReader(new File("info.txt")));

            String linea1, linea2, linea3 = "";

            while ((linea1 = leerAnyos.readLine()) != null && (linea2 = leerAlumnos.readLine())!= null){

//                System.out.println(linea1);

                String [] fechaNacimiento = linea1.split(" ");
                String [] nombre = linea2.split(" ");
                int ano [] = new int[fechaNacimiento.length];

                for(int i = 0; i < ano.length; i++){
                    ano[i] = Integer.parseInt(fechaNacimiento[i]);

                    Calendar date = Calendar.getInstance();
                    int edad = date.get(Calendar.YEAR) - ano[i];

                    String mayorEdad = "";
                    if(edad < 18){
                        mayorEdad = "N";
                    }else{
                        mayorEdad = "S";
                    }


                    writer.write(nombre[i] + " " + fechaNacimiento[i] + " " + edad + " " + mayorEdad);
                    writer.newLine();
                    writer.flush();

                }

            }

            System.out.println("Fichero INFO.TXT ESCRITO" );

            leerAnyos = new BufferedReader(new FileReader(new File("anyos.txt")));
            leerAlumnos = new BufferedReader(new FileReader(new File("alumnos.txt")));

            if((linea1 = leerAnyos.readLine()) == null){
                System.out.println("Fichero vacio");
            }else{
                System.out.println("------------FICHERO ANYOS.TXT------------");
                do{
                    System.out.println(linea1);
                }while((linea1 = leerAnyos.readLine()) != null);
            }


            if((linea2 = leerAlumnos.readLine()) == null){
                System.out.println("Fichero vacio");
            }else{
                System.out.println("------------FICHERO ALUMNOS.TXT------------");
                do{
                    System.out.println(linea2);
                }while((linea2 = leerAlumnos.readLine()) != null);
            }

            if((linea3 = leerInfo.readLine()) == null){
                System.out.println("Fichero vacio");
            }else{
                System.out.println("------------FICHERO INFO.TXT------------");
                do{
                    System.out.println(linea3);
                }while((linea3 = leerInfo.readLine()) != null);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
