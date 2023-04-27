package c_marzo27;

import java.io.File;

public class Ejercicio03 {

    public static void main(String[] args) {

        File principal = new File("C:\\Users\\danie\\Documents\\ACCESO A DATOS\\WORKSPACE - ACCESO DATOS\\ACCESO A DATOS - RECUPERACION\\Daniel Alejandro Contreras Mejia");

        File teoria = new File(principal, "Teoria");

        if (teoria.isDirectory()) {
            teoria.delete();
            System.out.println("El directorio hijo ha sido eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el directorio hijo.");
        }

        File file = new File(principal, "Practica");
        String[] archivos = file.list();
        for (String c : archivos) {
            System.out.println(c);
        }
        File pract = new File(file, "prac2.txt");
        if (pract.exists()) {
            pract.delete();
            System.out.println("Archivo elimiando correctamente");
        } else {
            System.out.println("No existe el fichero");
        }


//        File elim = new File(carpeta,"Teoria");
//        File elim2 = new File(carpeta, "pract2");
//        if(elim.exists() &&  elim2.exists()){
//            elim.delete();
//            elim2.delete();
//            System.out.println("Se ha eliminado " + elim.getName());
//            System.out.println("Se ha eliminado " + elim2.getName());
//        }
    }
}
