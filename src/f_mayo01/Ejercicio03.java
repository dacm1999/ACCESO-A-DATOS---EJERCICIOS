package f_mayo01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio03 {

    public static void main(String[] args) {

        File nombreCarpeta = new File("Daniel Contreras Examen");

        if (nombreCarpeta.exists()) {
            nombreCarpeta.delete();
        }
        nombreCarpeta.mkdirs();


        if (args.length != 1) {
            System.out.println("Solo se puede introducir un argumento");
        } else {

            try {
                int num = Integer.parseInt(args[0]);

                if (num < 1 || num > 5) {
                    System.out.println("El numero debe ser comprendido entre 1 y 5");
                } else {

                    BufferedWriter ficheros = null;
                    for (int i = 1; i <= num; i++) {
                        File file = new File("Fichero" + i);
                        file.createNewFile();

                        File destino = new File(nombreCarpeta, "Fichero" + i);
                        ficheros = new BufferedWriter(new FileWriter(destino));

                        ficheros.write("Fichero" + i);
                        ficheros.newLine();
                        ficheros.flush();
                    }
                    ficheros.close();

                    boolean salir = false;
                    int opciones = 0;
                    do {
                        System.out.println("1. Copiar. \n"
                                + "2. Borrar. \n"
                                + "3. Escribir. \n"
                                + "4. Salir. \n"
                        );

                        Scanner sc = new Scanner(System.in);
                        opciones = sc.nextInt();
                        switch (opciones) {

                            case 1: {
                                BufferedWriter ficheroExamen = new BufferedWriter(new FileWriter(new File(nombreCarpeta, "Examen")));
                                for (int i = 1; i <= num; i++) {
                                    BufferedReader reader1 = new BufferedReader(new FileReader(new File(nombreCarpeta, "Fichero" + i)));
                                    String linea = "";

                                    while ((linea = reader1.readLine()) != null) {
                                        System.out.println(linea);
                                        ficheroExamen.write(linea);
                                        ficheroExamen.newLine();
                                    }
                                    reader1.close();
                                }
                                ficheroExamen.close();
                                break;
                            }

                            case 2: {

                                File file = new File(nombreCarpeta, "Examen");
                                if (file.exists()) {
                                    file.delete();
                                    System.out.println("El archivo ha sido eliminado");
                                }

                            }
                            break;


                            case 3: {
                                String linea1;
                                BufferedReader reader1 = new BufferedReader(new FileReader(new File(nombreCarpeta, "Examen")));
                                FileWriter writer1 = new FileWriter(new File(nombreCarpeta, "Examen"), true);

                                if ((linea1 = reader1.readLine()) != null) {
                                    writer1.append("Contreras");
                                }

                                reader1.close();
                                writer1.close();

                                for (int i = 1; i <= num; i++) {
                                    BufferedReader reader2 = new BufferedReader(new FileReader(new File(nombreCarpeta, "Fichero" + i)));
                                    FileWriter writer2 = new FileWriter(new File(nombreCarpeta, "Fichero" + i), true);

                                    String linea2;
                                    if ((linea2 = reader2.readLine()) != null) {
                                        writer2.append("Contreras");
                                    }

                                    System.out.println("Fichero" + i + " examen ha sido firmado");
                                    reader2.close();
                                    writer2.close();

                                }

                                System.out.println("Fichero examen ha sido firmado");
                            }
                            break;

                            case 4: {

                                System.out.println("¿Desea mantener los ficheros? Y/N");

                                String eliminarFicheros = "";

                                eliminarFicheros = sc.next();


                                for (int i = 1; i <= num; i++) {
                                    File files = new File(nombreCarpeta, "Fichero" + i);

                                    if(eliminarFicheros.equals("N")){
                                        files.delete();
                                        System.out.println("Se ha eliminado " + files.getName());
                                    } else if (eliminarFicheros.equals("Y")) {
                                        System.out.println("Se mantendran los ficheros");
                                    }

                                }
                                System.out.println("Adios");
                                salir = true;
                            }
                            break;


                            default: {
                                System.out.println("Introduce un numero correcto");
                            }
                            break;
                        }


                    } while (!salir);

                }


            } catch (NumberFormatException ex) {
                System.out.println("Introduce un numero en vez de un caracter");
                Scanner sc = new Scanner(System.in);
                int num = 0;
                do {
                    System.out.println("Introduce un numero de 1 al 5");
                    num = sc.nextInt();
                } while (num < 1 || num > 5);

                args[0] = String.valueOf(num);
                System.out.println(args[0]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
