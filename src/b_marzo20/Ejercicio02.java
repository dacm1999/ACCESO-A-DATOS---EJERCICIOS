package b_marzo20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class Ejercicio02 {

    public static void main(String[] args) {


        try {
            File file = new File("articulo.txt");
            RandomAccessFile fichero = new RandomAccessFile(file,"r");


            int posicion = 0;
            char tigre [] = new char[5], aux;
            char lince [] = new char[5], aux2;

            for(;;){
                fichero.seek(posicion);


                for(int i =0; i < tigre.length; i++){
                    aux = fichero.readChar();
                    tigre[i] =aux;
                }

                for(int k =0; k < lince.length; k++){
                    aux2 = fichero.readChar();
                    lince[k] = aux2;
                }

                String animal1 = new String(tigre);
                String animal2 = new String(lince);

                if (animal1.equals("tigre") && animal2.equals("lince")){
                    System.out.printf("");
                    System.out.println("Lista animales: " + lince);
                    System.out.println("Lista animales2: " + tigre);
                    posicion = posicion + 696;
                }

                if(fichero.getFilePointer() == fichero.length()){
                    break;
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("ERROR E/O");
        }
    }
}
