package a_marzo13_Ficheros;

import java.io.File;

public class Ejercicio03 {

    public static void main(String[] args) {
        String arch = Ejercicio03.class.getName();
        File archivo = new File(arch);

        System.out.println("Nombre del archivo: " + archivo.getName());
        System.out.println("Ruta: " + archivo.getPath());
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());


        //SE PUEDE LEER
        if(archivo.canRead() == true){
            System.out.println(archivo.getName() + " es un archivo de lectura");
        }else{
            System.out.println(archivo.getName() + " no es un archivo de lectura");
        }

        //SE PUEDE ESCRIBIR
        if(archivo.canWrite() == true){
            System.out.println(archivo.getName() + " se puede escribir");
        }else{
            System.out.println(archivo.getName() + " no se puede escribir");
        }

        System.out.println("Tamaño del archivo: " + archivo.length());

        //COMPRUEBO SI ES UN DIRECTORIO
        if(archivo.isDirectory() == true){
            System.out.println(archivo.getName() + " es un directorio");
        }else{
            System.out.println(archivo.getName() + " no es un directorio");
        }

        //COMPRUEBO SI ES UN ARCHIV
        if(archivo.isFile() == true){
            System.out.println(archivo.getName() + " es un fichero");
        }else{
            System.out.println(archivo.getName() + " no es un fichero");
        }

    }
}
