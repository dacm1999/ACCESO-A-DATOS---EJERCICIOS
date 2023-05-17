package g_examenes.Ficheros.Examen01;

import java.io.*;
import java.util.Scanner;

public class Examen01 {


    public static void main(String[] args) {

        File carpetaEXamen = new File("Daniel Examen01");
        carpetaEXamen.mkdirs();


        Scanner sc = new Scanner(System.in);
        int opciones = 0;
        boolean ejecutando = true;


        do {
            System.out.println("--------------MENU--------------");
            System.out.println("1- PARES");
            System.out.println("2- COPIA");
            System.out.println("3- FIRMA");
            System.out.println("4- SALIR");
            System.out.print("Introduce una opcion: ");
            opciones = sc.nextInt();
            sc.nextLine();

            switch (opciones) {
                case 1: {
                    try {
                        File examen = new File(carpetaEXamen, "Examen.txt");
                        System.out.print("Introduce la cantidad de numeros: ");
                        int cantidadNum = sc.nextInt();
                        if (cantidadNum > 100) {
                            System.out.println("Introduce un numero menor a 100");
                        } else {
                            System.out.print("Introduce el numero base: ");
                            int numBase = sc.nextInt();

                            String aEscribir = "";
                            int paresIntroducidos = 0;
                            int ultimoNumero = numBase;

                            if (numBase % 2 == 0) {
                                aEscribir = numBase + " , ";
                                paresIntroducidos++;
                            } else {
                                aEscribir = numBase + 1 + ", ";
                                ultimoNumero++;
                            }

                            while (paresIntroducidos < cantidadNum - 1) {
                                aEscribir += ultimoNumero + 2 + ", ";
                                ultimoNumero += 2;
                                paresIntroducidos++;
                            }

                            aEscribir = aEscribir.substring(0, aEscribir.length() - 2);


                            if (!examen.exists()) {
                                examen.createNewFile();
                            }


                            BufferedWriter writer = new BufferedWriter(new FileWriter(examen));
                            writer.write(aEscribir + "\n");
                            writer.flush();

                            writer.close();


                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                break;

                case 2: {

                    try {
                        File examen = new File(carpetaEXamen, "Examen.txt");
                        if (examen.exists()) {

                            BufferedReader reader = new BufferedReader(new FileReader(new File(carpetaEXamen, "Examen.txt")));

                            File copiaExamen = new File(carpetaEXamen, "Copia.txt");
                            FileWriter writer = new FileWriter(copiaExamen, true);

                            String lineas = "";

                            if (copiaExamen.exists()){
                                copiaExamen.delete();
                            }

                            while ((lineas = reader.readLine()) != null) {
                                System.out.println(lineas);
                                writer.write(lineas);
                            }

                            writer.close();


                        } else {
                            for (int i = 1; i <= 2; i++) {
                                File files = new File(carpetaEXamen, "Fichero" + i);
                                files.createNewFile();
                            }
                        }


                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Copia realizada.");

                }
                break;

                case 3: {

                    try {
                        String firma = "Daniel Contreras";
                        File file = new File(carpetaEXamen, "Examen.txt");
                        FileWriter writer = new FileWriter(file, true);

                        writer.append(firma + "\n");

                        writer.close();

                        System.out.println("Fichero firmado.");

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;

                case 4: {


                    System.out.println("Desea mantener Examen.txt?" );
                    System.out.print("Puse S/N: ");
                    String borrar = sc.nextLine();
                    if(borrar.equalsIgnoreCase("N")){
                        File examen = new File(carpetaEXamen,"Examen.txt");
                        examen.delete();
                        System.out.println(examen.getName() + " ha sido eliminado");
                    }else{
                        System.out.println("El fichero Examen.txt se ha conservado");
                    }
                    System.out.println("Desea mantener Copia.txt?" );
                    System.out.print("Puse S/N:  ");
                    borrar = sc.nextLine();
                    if(borrar.equalsIgnoreCase("N")){
                        File copia = new File(carpetaEXamen,"Copia.txt");
                        copia.delete();
                        System.out.println(copia.getName() + " ha sido eliminado");
                    }else{
                        System.out.println("El fichero Copia.txt se ha conservado");

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
