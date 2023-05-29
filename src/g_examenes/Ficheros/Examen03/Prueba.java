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


            while ((linea1 = leerAnyos.readLine()) != null && (linea2 = leerAlumnos.readLine()) != null){

                String [] anoNacimiento = linea1.split(" ");
                String [] nombreAlumno = linea2.split(" ");

                int [] edadAlumnos = new int[anoNacimiento.length];

                for(int i =0; i < edadAlumnos.length; i++){
                    edadAlumnos [i]= Integer.parseInt(anoNacimiento[i]);
                    System.out.println(edadAlumnos[i]);

                    Calendar calendar = Calendar.getInstance();

                    int edad = calendar.get(Calendar.YEAR) - edadAlumnos[i];

                    String mayorEdad;

                    if(edad >= 18){
                        mayorEdad = "S";
                    }else{
                        mayorEdad = "N";
                    }


                    writer.write("Nombre " + nombreAlumno[i] + " Año nacimiento " + anoNacimiento[i] + " Edad: " + edad + " MayorEdad: " + mayorEdad + "\n");
                }

            }

            writer.close();
            leerAnyos.close();
            leerAlumnos.close();

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
                System.out.println("------------FICHERO INFO.TXT------------");
                System.out.println("Fichero vacio");
            }else{
                System.out.println("------------FICHERO ALUMNOS.TXT------------");
                do{
                    System.out.println(linea2);
                }while((linea2 = leerAlumnos.readLine()) != null);
            }

            if((linea3 = leerInfo.readLine()) == null){
                System.out.println("------------FICHERO INFO.TXT------------");
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
