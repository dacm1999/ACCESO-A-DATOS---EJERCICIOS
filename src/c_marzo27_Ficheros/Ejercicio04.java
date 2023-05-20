package c_marzo27_Ficheros;

import java.io.File;

public class Ejercicio04 {

    public static void main(String[] args) {

        try{
            if(args.length < 2 || args.length > 2){
                System.out.println("Introduce los argumentos necesarios");
            }else{

                String ruta = args[0];
                String nombre = args[1];

                File file = new File(ruta+"",nombre+"");

                System.out.println(args[0]);
                System.out.println(file.getAbsolutePath());
                System.out.println(file.getName()+"\n");

                if (file.exists()){
                    file.delete();
                    System.out.println("Fichero eliminado");
                }else{
                    System.out.println("El fichero no existe");
                }

            }

        }catch (IndexOutOfBoundsException ex){
            System.out.println();
        }
    }
}
