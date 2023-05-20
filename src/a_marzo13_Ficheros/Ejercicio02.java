package a_marzo13_Ficheros;

import java.io.File;

public class Ejercicio02 {

    public static void main(String[] args) {


        if(args.length < 1){
            System.out.println("Introduce una ruta, por favor");
        }

        String nombreRuta = "C:\\Users\\danie\\Documents\\ACCESO A DATOS\\WORKSPACE - ACCESO DATOS\\ACCESO A DATOS - RECUPERACION\\src\\a_marzo13";

        File directorio = new File(nombreRuta);

        if(!directorio.exists()){
            System.out.println("El directorio no existe");
        }

        System.out.println("---------------------");
        System.out.println("Ruta del directorio:");
        System.out.println(args[0] + "\n");

        String [] ficheros = directorio.list();

        System.out.println("---------------------");
        System.out.println("Ficheros en el directorio");
        for (int i = 0 ; i < ficheros.length; i ++){
            System.out.println(ficheros[i]);
        }

    }
}
