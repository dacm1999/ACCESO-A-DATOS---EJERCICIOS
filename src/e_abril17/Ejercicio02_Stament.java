package e_abril17;

import java.sql.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Ejercicio02_Stament {

    public static void main(String[] args) {

        if(args.length != 8){
            System.out.printf("Introduce los argumentos necesarios");
        }else{
            String apellido = args[1];
            if(apellido.equals(" ") || apellido.equals(null)){

                System.out.println("Introduce un apellido correcto");
            }else{
                String oficio = args[2];
                if(oficio.equals(" ") || oficio.equals(null)){

                    System.out.println("Introduce un ofcio correcto");
                }else {
                    String fecha_alt = args[4];
                    LocalDateTime fechaActual = LocalDateTime.now();


                    if(!fecha_alt.equals(fechaActual.toLocalDate().toString())){
                        System.out.println("Introduce la fecha actual");
                    }else{
                        String salario = args[5];

                        if(Integer.parseInt(salario) <= 0){
                            System.out.println("Introduce un salario mayor a 0");

                        }else{
                            String comison = args[6];
                            if (Integer.parseInt(comison) <=0){
                                System.out.println("Introduce una comision mayor a 0");
                            }else{

                                try{
                                    String dir = args[3];
                                    String dept_no = args[7];
                                    String emp_no = args[0];
                                    Class.forName("org.sqlite.JDBC");
                                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");


                                    Statement sentencia = conexion.createStatement();

                                    String comprobarEmpleado = "SELECT count(emp_no) from empleados where emp_no = " + emp_no +";";

                                    ResultSet resultSet = sentencia.executeQuery(comprobarEmpleado);
                                    int falso = 0;
                                    while (resultSet.next()){
                                        falso = resultSet.getInt(1);
                                    }

                                    if(falso == 1){
                                        System.out.println("El numero de empleado ya existe, por favor introduce otro numero");
                                    }else{
                                        falso = 0;

                                        String comprobarDept = "SELECT count(dept_no) from departamentos where dept_no = " + dept_no + ";";
                                        resultSet = sentencia.executeQuery(comprobarDept);

                                        while (resultSet.next()){
                                            falso = resultSet.getInt(1);
                                        }

                                        if(falso == 0){
                                            System.out.println("Introduce un departamento existente");
                                        }else{

                                            falso = 0;
                                            String comprobarDir = "Select count(dir) from empleados where dir =" + dir + ";";
                                            resultSet = sentencia.executeQuery(comprobarDir);

                                            while (resultSet.next()){
                                                falso = resultSet.getInt(1);
                                            }

                                            if(falso == 0){
                                                System.out.println("El numero de DIR no existe, por favor introduce uno correcto");
                                            }else {



                                                String insert = "INSERT INTO empleados VALUES('"  + emp_no + "', '"
                                                        + apellido
                                                        + "', '"
                                                        + oficio
                                                        + "', '"
                                                        + dir
                                                        + "', '"
                                                        + fecha_alt
                                                        + "', '"
                                                        + salario
                                                        + "', '"
                                                        + comison
                                                        + "', '"
                                                        + dept_no
                                                        + "');";

                                                int filas = sentencia.executeUpdate(insert);

                                                System.out.println("Filas introducidas " + filas);

                                            }
                                        }
                                    }


                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                } catch (ClassNotFoundException e) {
                                    throw new RuntimeException(e);
                                }


                            }


                        }
                    }
                }
            }


        }


    }
}
