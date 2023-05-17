package g_examenes.Ficheros.Examen02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Examen02 {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        File carpetaExamen = new File("Daniel Contreras Examen");
        BufferedWriter writer = null;
        carpetaExamen.mkdirs();

        if(args.length != 1){
            System.out.println("introduce los argumenntos necesarios");
        }else{

            try{
                int countFicheros = Integer.parseInt(args[0]);

                for(int i = 1; i <= countFicheros; i++){

                    File files = new File(carpetaExamen, "Fichero"+i);
                    files.createNewFile();
                    writer = new BufferedWriter(new FileWriter(files));
                    writer.write("Fichero"+i+".txt");
                    writer.flush();
                }
                writer.close();


                boolean ejecutando = true;
                do{
                    System.out.println("------------MENU-------------");
                    System.out.println("1) - COPIAR");
                    System.out.println("2) - BORRAR");
                    System.out.println("3) - FIRMA");
                    System.out.println("4) - SALIR");
                    String opcion = sc.nextLine();


                    switch (opcion){

                        case "1":{

                            BufferedWriter escribirExamen = new BufferedWriter(new FileWriter(new File(carpetaExamen,"Examen")));
                            BufferedReader leerFicheros = null;
                            String lineas="";

                            for(int i = 1; i <= countFicheros; i++){
                                File files = new File(carpetaExamen, "Fichero"+i);
                                leerFicheros = new BufferedReader(new FileReader(files));

                                while ((lineas = leerFicheros.readLine())!= null){
                                    escribirExamen.write(lineas);
                                    escribirExamen.newLine();
                                    escribirExamen.flush();
                                }

                            }
                            leerFicheros.close();
                            escribirExamen.close();

                            leerFicheros = new BufferedReader(new FileReader(new File(carpetaExamen,"Examen")));

                            do{
                                System.out.println(lineas);
                            }while ((lineas = leerFicheros.readLine())!= null);
                        }
                        break;

                        case "2":{

                            System.out.println("Introduce el número de líneas a eliminar:");
                            int numLineasEliminar = sc.nextInt();
                            sc.nextLine(); // Consumir el salto de línea pendiente
                            List<String> lineas = new ArrayList<>();
                            try (BufferedReader reader2 = new BufferedReader(new FileReader(new File(carpetaExamen,"Examen")))) {
                                String linea;
                                int contador = 0;
                                while ((linea = reader2.readLine()) != null) {
                                    contador++;
                                    if (contador > numLineasEliminar) {
                                        lineas.add(linea);
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(carpetaExamen,"Examen")))) {
                                for (String linea : lineas) {
                                    bw.write(linea);
                                    bw.newLine();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;

                        case "3":{
                            FileWriter writer2 = new FileWriter(new File(carpetaExamen,"Examen"),true);

                            String firma = "Daniel Contreras";
                            for(int i =1; i <= countFicheros; i++){
                                FileWriter writer1 = new FileWriter(new File(carpetaExamen,"Fichero"+i+""),true);
                                writer1.append("\n"+firma);

                                writer1.close();
                            }

                            writer2.close();

                        }
                        break;

                        case "4":{

                            ejecutando = false;
                            System.out.println("Desea conservar los ficheros? Y/N");
                            String conservar = sc.nextLine();

                            if(conservar.equalsIgnoreCase("N")){

                                for(int i =1; i <= countFicheros; i++){

                                    File files = new File(carpetaExamen, "Fichero" + i);
                                    System.out.println("Eliminando fichero: " + files.getAbsolutePath());
                                    boolean deleted = files.delete();
                                    System.out.println("Eliminado: " + deleted);
                                }
                                System.out.println("Los ficheros han sido eliminados exitosamente. Adios");
                            }else{
                                System.out.println("Los ficheros se conservarán. Adios");

                            }
                        }
                        break;

                        default:{
                            System.out.println("Introduce una opcion valida");
                        }
                        break;
                    }



                }while (ejecutando);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
