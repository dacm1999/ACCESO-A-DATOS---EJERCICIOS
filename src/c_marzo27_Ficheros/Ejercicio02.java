package c_marzo27_Ficheros;

import java.io.File;

public class Ejercicio02 {

    public static void main(String[] args) {


        File carpeta = new File("Daniel Alejandro Contreras Mejia");

        String [] archivos = carpeta.list();

        System.out.println("Carpeta " + carpeta.getName());
        for(String archivo : archivos){
            System.out.println(archivo);
        }

        System.out.println("\n"+"Carpetas hijas");

        File carpeta2 = new File(carpeta,"Practica");
        String [] archivosChild2 = carpeta2.list();

        for(String archivo : archivosChild2){
            System.out.println(archivo);
        }


        File carpeta3 = new File(carpeta,"Teoria");
        String [] archivosChild3 = carpeta3.list();

        for(String archivo : archivosChild3){
            System.out.println(archivo);
        }
    }
}
