package a_marzo13;

import java.io.File;

public class Ejercicio04 {
    public static void main(String[] args) {

        String nombreDirectorio = "C:\\Users\\danie\\Documents\\ACCESO A DATOS\\WORKSPACE - ACCESO DATOS\\ACCESO A DATOS - RECUPERACION\\lleno";
        File directorio = new File(nombreDirectorio);

        if(directorio.exists()){
            if(directorio.list().length ==0){
                directorio.delete();
                System.out.println("El directorio " + directorio.getName() + " ha sido eliminado");
            }else{
                File [] archivos = directorio.listFiles();

                for (File archivo : archivos){
                    archivo.delete();
                    System.out.println("Se ha eliminado" + archivo.getName());
                }

                directorio.delete();
                System.out.println("Se ha eliminado el directorio " + directorio.getName());


            }
        }else{
            System.out.println("No existe");
        }

    }
}
