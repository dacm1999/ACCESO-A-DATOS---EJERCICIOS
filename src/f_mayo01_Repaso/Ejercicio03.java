package f_mayo01_Repaso;

import java.io.*;
import java.util.Scanner;

public class Ejercicio03 {

    public static void main(String[] args) {


        try {

            Scanner sc = new Scanner(System.in);
            File carpetaExamen = new File("DanielExamen");

            if (carpetaExamen.isDirectory()) {
                carpetaExamen.delete();
            }
            carpetaExamen.mkdirs();

            if (args.length != 1) {
                System.out.println("No se puede introducir mas de un argumento");
            } else {
                int numFicheros = Integer.parseInt(args[0]);


                if (numFicheros < 1 || numFicheros > 5) {
                    System.out.println("El numero debe ser comprendido entre 1 y 5");
                } else {

                    BufferedWriter writer = null;
                    for (int i = 1; i <= numFicheros; i++) {
                        File files = new File(carpetaExamen, "Fichero" + i);
                        files.createNewFile();
                        writer = new BufferedWriter(new FileWriter(files));
                        writer.write("Fichero" + i);
                        writer.newLine();
                        writer.flush();
                    }


                    int opciones = 0;
                    boolean ejecutando = true;

                    do {
                        System.out.println("---------MENU---------");
                        System.out.println("1-Copiar");
                        System.out.println("2-Borrar");
                        System.out.println("3-Escribir");
                        System.out.println("4-Salir");
                        System.out.print("Introduce una opcion: ");

                        opciones = sc.nextInt();



                        switch (opciones) {

                            //copiar
                            case 1: {

                                BufferedWriter escribirExamen = new BufferedWriter(new FileWriter(new File(carpetaExamen,"Examen")));
                                BufferedReader leerFicheros = null;
                                String lineas;

                                for(int i = 1; i <= numFicheros; i++){
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
                                System.out.println("----------- Contenido del fichero EXAMEN: -----------" );
                                while ((lineas = leerFicheros.readLine())!= null){
                                    System.out.println(lineas);
                                }
                            }
                            break;

                            //borrar
                            case 2: {

                                String op = String.valueOf(numFicheros);
                                String valores [] = op.split(" ");

                                int op1 = Integer.parseInt(valores[0]);
                                int op2 = Integer.parseInt(valores[1]);

                                System.out.println(op1);
                                System.out.println(op2);


                            }
                            break;

                            //Escribir
                            case 3: {

                                FileWriter writer2 = new FileWriter(new File(carpetaExamen,"Examen"),true);
                                writer2.append("Daniel Contreras");

                                String firma = "Daniel Contreras";
                                for(int i =1; i <= numFicheros; i++){
                                    FileWriter writer1 = new FileWriter(new File(carpetaExamen,"Fichero"+i),true);
                                    writer1.append(firma);

                                    writer1.close();
                                }

                                writer2.close();
                            }
                            break;


                            //salir
                            case 4: {

                                System.out.println("Desea eliminar los archivos? Y/N");
                                String confirmar = sc.next();
                                File files = null;
                                if (confirmar.equalsIgnoreCase("Y")) {
                                    for (int i = 1; i <= numFicheros; i++) {
                                        files = new File(carpetaExamen, "Fichero" + i);
                                        files.delete();
                                    }
                                }
                                ejecutando = false;
                            }
                            break;

                            default: {
                                System.out.println("Introduce una opcion valida");
                            }
                            break;
                        }


                    } while (ejecutando);

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException ex) {
            System.out.println("Introduce un numero en vez de un caracter");
        }

    }
}
