package b_marzo20_Ficheros;

import java.io.*;
import java.time.DayOfWeek;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio01_Mejorado {


    public static void main(String[] args) {


        boolean ejecutando = true;
        Scanner sc = new Scanner(System.in);
        int opciones;
        try{
            do{

                System.out.println("-------------MENU-------------");
                System.out.println("1) - Crear Fichero Menores.dat y Mayores.dat");
                System.out.println("2) - Leer Menores.dat");
                System.out.println("3) - Leer Mayores.dat");
                System.out.println("4) - Salir");
                System.out.print("Introduce una opcion: ");
                opciones = sc.nextInt();
                switch (opciones){

                    case 1: {
                        System.out.println("Vamos a crear los ficheros");
                        menoresMayores();
                    }
                    break;

                    case 2:{
                        leerMenores();
                    }
                    break;

                    case 3:{
                        leerMayores();
                    }
                    break;

                    case 4:{
                        System.out.println("Adios");
                        ejecutando = false;
                    }

                    default:{
                        System.out.println("Introduce una opcion valida");
                    }
                    break;
                }


            }while (ejecutando);

        }catch (InputMismatchException ex){

            System.out.println("Introduce un numero");
        }



    }

    public static void menoresMayores (){

        String nombres[] = {"Ana", "Luis Miguel", "Alicia", "Bea", "Manuel", "Alfonso", "Julio", "Ana", "Marta"};
        int edades[] = {17, 15, 13, 19, 16, 12, 16, 14, 18};

        try {
            DataOutputStream mayores = new DataOutputStream(new FileOutputStream("menores.dat"));
            DataOutputStream menores = new DataOutputStream(new FileOutputStream("menores.dat"));

            for(int i = 0; i < edades.length; i++) {
                for(int j = 0; j < edades.length; j++){


                    if (edades[i] > edades[j]) {

                        int edadTemp = edades[i];
                        String nombreTemp = nombres[i];

                        edades[i] = edades[j];
                        edades[j] = edadTemp;
                        nombres[i] = nombres[j];
                        nombres[j] = nombreTemp;

                    }
                }
            }


            for (int i = 0; i < nombres.length; i++) {
                if (edades[i] >= 18) {
                    mayores.writeUTF(nombres[i]);
                    mayores.writeInt(edades[i]);
                } else {
                    menores.writeUTF(nombres[i]);
                    menores.writeInt(edades[i]);
                }
            }

            mayores.close();
            menores.close();
            System.out.println("Fichero Escrito correctamente ");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void leerMayores() {

        File file = new File("mayores.dat");
        if(file.exists()){
            try {
                DataInputStream leerMayores = new DataInputStream(new FileInputStream(file));

                String leerNombre;
                int leerEdad;

                while (true){
                    leerNombre = leerMayores.readUTF();
                    leerEdad = leerMayores.readInt();

                    System.out.println("Nombre " + leerNombre + " Edad " + leerEdad);
                }

            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado");
            } catch (IOException e) {
                System.out.println("");
            }
        }else{
            System.out.println("El fichero no existe, vamos a crearlo");
            menoresMayores();
        }

    }

    public static void leerMenores() {

        File file = new File("menores.dat");
        if(file.exists()){
            try {
                DataInputStream leerMenores = new DataInputStream(new FileInputStream(file));

                String leerNombre;
                int leerEdad;

                while (true){
                    leerNombre = leerMenores.readUTF();
                    leerEdad = leerMenores.readInt();

                    System.out.println("Nombre " + leerNombre + " Edad " + leerEdad);
                }

            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado");
            } catch (IOException e) {
                System.out.println("");
            }
        }else{
            System.out.println("El fichero no existe, vamos a crearlo");
            menoresMayores();
        }
    }
}
