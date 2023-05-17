package b_marzo20;

import javax.xml.crypto.Data;
import java.io.*;

public class Ejercicio01 {

    public static void main(String[] args) {

        String nombres[] = {"Ana", "Luis Miguel", "Alicia", "Bea", "Manuel", "Alfonso", "Julio", "Ana", "Marta"};
        int edades[] = {17, 15, 13, 19, 16, 12, 16, 14, 18};

        try {


            DataOutputStream mayores = new DataOutputStream(new FileOutputStream("mayores.dat", true));
            DataOutputStream menores = new DataOutputStream(new FileOutputStream("menores.dat", true));


            for (int i = 0; i < edades.length; i++) {
                for (int j = 0; j < edades.length; j++) {

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
        } catch (IOException e) {
//            System.out.println("ERROr I/O");
        }

        System.out.println();
        System.out.println("LEYENDO MAYORES ");

        try{
            DataInputStream leerMayores = new DataInputStream(new FileInputStream("mayores.dat"));

            String leerNombre;
            int leerEdad;

            while(true){
                leerNombre = leerMayores.readUTF();
                leerEdad = leerMayores.readInt();

                System.out.println("Nombre: " + leerNombre + " " + " edad: " + leerEdad);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("ERROR I/O");
        }

        System.out.println();
        System.out.println("LEYENDO MENORES ");
        try{
            DataInputStream leerMenores = new DataInputStream(new FileInputStream("menores.dat"));

            String leerNombre;
            int leerEdad;

            do {

                leerNombre = leerMenores.readUTF();
                leerEdad = leerMenores.readInt();
                System.out.println("Nombre: " + leerNombre + " " + " edad: " + leerEdad);

            }while ((leerNombre = leerMenores.readUTF()) != null);
//
//            while(true){
//                leerNombre = leerMenores.readUTF();
//                leerEdad = leerMenores.readInt();
//
//                System.out.println("Nombre: " + leerNombre + " " + " edad: " + leerEdad);
//            }
            leerMenores.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
//            System.out.println("ERROR I/O");
        }



    }
}
