package e_abril17;

import java.sql.*;
import java.time.LocalDateTime;

public class Ejercicio02 {

    public static void main(String[] args) {


        if (args.length != 8) {
            System.out.printf("Introduce los argumentos necesarios");
        } else {
            String apellido = args[1];

            if (apellido.equals(" ") || apellido.equals(null)) {
                System.out.printf("Introduce un apellido correcto");
            } else {
                String oficio = args[2];
                if (oficio.equals(" ") || oficio.equals(null)) {
                    System.out.printf("Introduce un oficio correcto");
                } else {
                    String fecha_alt = args[4];
                    LocalDateTime fechaActual = LocalDateTime.now();
                    if (!fecha_alt.equals(fechaActual.toLocalDate().toString())) {
                        System.out.println("La fecha introducida no coincide con la fecha actual");
                    } else {
                        String salario = args[5];
                        if (Integer.parseInt(salario) <= 0) {
                            System.out.printf("Introduce un salario mayor a 0");
                        } else {
                            String comision = args[6];
                            if (Integer.parseInt(comision) <= 0) {
                                System.out.printf("Introduce una comision mayor a 0");
                            } else {
                                try {
                                    Class.forName("org.sqlite.JDBC");
                                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

                                    Statement sentencia = conexion.createStatement();


                                    //Compruebo si existe el departamento
                                    String dept_no = args[7];
                                    String comprobarDept = "Select count(dept_no) from departamentos where dept_no =" + dept_no + ";";
                                    ResultSet resultSet = sentencia.executeQuery(comprobarDept);
                                    int existe = 0;
                                    while (resultSet.next()) {
                                        existe = resultSet.getInt(1);
                                    }
                                    if (existe == 0) {
                                        System.out.printf("El departamento no existe");
                                    } else {
                                        System.out.printf("Existe");

                                        //Compruebo si existe el empleado
                                        String emp_no = args[0];
                                        String comprobarEmp = "Select count(emp_no) from empleados where emp_no =" + emp_no + ";";
                                        resultSet = sentencia.executeQuery(comprobarEmp);
                                        existe = 0;
                                        while (resultSet.next()) {
                                            existe = resultSet.getInt(1);
                                        }

                                        if (existe == 1) {
                                            System.out.printf("El numero de empleado ya existe");
                                        } else {

                                            //compruebo si existe el director
                                            String dir = args[3];
                                            String comprobarDir = "Select count(dir) from empleados where dir = " + dir + ";";
                                            resultSet = sentencia.executeQuery(comprobarDir);

                                            while (resultSet.next()) {
                                                existe = resultSet.getInt(1);
                                            }

                                            if (existe == 0) {
                                                System.out.printf("El director no existe");
                                            } else {

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
                                                        + comision
                                                        + "', '"
                                                        + dept_no
                                                        + "');";

                                                int resultado = sentencia.executeUpdate(insert);
                                                System.out.println("Filas afectadas " +  resultado);
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
