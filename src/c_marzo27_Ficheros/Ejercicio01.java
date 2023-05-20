package c_marzo27_Ficheros;

import java.io.File;
import java.io.IOException;

public class Ejercicio01 {
    public static void main(String[] args) throws IOException {

        File nombreA = new File("Daniel Alejandro Contreras Mejia");
        nombreA.mkdirs();

        File teoria = new File(nombreA,"Teoria");
        File practica = new File(nombreA, "Practica");

        teoria.mkdirs();
        practica.mkdirs();

        File tema1 = new File(teoria,"tema1.txt");
        tema1.createNewFile();
        for(int i = 1; i <= 3; i++){
            File practicas = new File(practica,"prac"+i+".txt");
            practicas.createNewFile();
        }

        System.out.printf("Archivos creados ");
    }
}
