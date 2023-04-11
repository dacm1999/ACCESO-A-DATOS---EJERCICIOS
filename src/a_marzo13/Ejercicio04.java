package a_marzo13;

import java.io.File;
import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce ruta: ");
        String ruta = sc.nextLine();
        //C:\Users\danie\Documents\ACCESO A DATOS\WORKSPACE - ACCESO DATOS\ACCESO A DATOS - RECUPERACION\src\a_marzo13

        File directorio = new File(ruta);

        if(directorio.exists()){

            if (directorio.list().length < 1){
                System.out.println("El directorio " + directorio.getName() + " ha sido eliminado");
                directorio.delete();
            }else{
                File[] archivos = directorio.listFiles();
                System.out.println("Lista de archivos: ");
                for(File file : archivos){
                    System.out.println(file.getName());
                    file.delete();
                }
                directorio.delete();
                System.out.println("Se ha eliminado el directorio");
            }
        }else{
            System.out.println("El directorio no existe");
        }
    }
}
