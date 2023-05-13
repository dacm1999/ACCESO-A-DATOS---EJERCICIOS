package e_abril17;

import java.sql.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Ejercicio02_Prepared {

    public static void main(String[] args) {


        if (args.length != 8) {
            System.out.println("Introduce los argumentos necesarios");
        } else {

            String apellido = args[1];
            String oficio = args[2];
            String fecha_alt = args[4];
            String salario = args[5];
            String comision = args[6];


            String dir = args[3];
            String dept_no = args[7];
            String emp_no = args[0];
            if (apellido.equals(" ") || apellido.equals(null)) {
                System.out.println("Introduce un apellido correcto");
            } else {
                if (oficio.equals(" ") || oficio.equals(null)) {
                    System.out.println("Introduce un oficio valido");
                } else {

                    LocalDateTime time = now();
                    if (!fecha_alt.equals(time.toLocalDate().toString())) {
                        System.out.println("Introduce la fecha de hoy");
                    } else {
                        if (Integer.parseInt(salario) <= 0) {
                            System.out.println("Introduce un salario mayor a 0");
                        } else {
                            if (Integer.parseInt(comision) <= 0) {
                                System.out.println("Introduce una comision mayor a 0");
                            } else {

                                try {
                                    Class.forName("org.sqlite.JDBC");
                                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

                                    String comprobarEmpleado = "Select count(emp_no) from empleados where emp_no = " + emp_no + " ;";
                                    Statement statement = conexion.createStatement();

                                    ResultSet rs = statement.executeQuery(comprobarEmpleado);
                                    int vd = 0;

                                    while (rs.next()) {
                                        vd = rs.getInt(1);
                                    }

                                    if (vd == 1) {
                                        System.out.println("El numero de empleado ya existe, por favor introduce otro ");
                                    }


                                    String comprobarDir = "Select count(dir) from empleados where dir = " + dir + ";";
                                    rs = statement.executeQuery(comprobarDir);
                                    vd = 0;

                                    while (rs.next()) {
                                        vd = rs.getInt(1);
                                    }

                                    if (vd == 0) {
                                        System.out.println("El numero del dir no existe, introduce uno existente");
                                    }

                                    String comprobarDept_no = "Select count(dept_no) from empleados where dept_no = " + dept_no + ";";
                                    rs = statement.executeQuery(comprobarDept_no);
                                    vd = 0;

                                    while (rs.next()) {
                                        vd = rs.getInt(1);
                                    }

                                    if (vd == 0) {
                                        System.out.println("No existe el departamento indicado, introduce otro");
                                    }


                                    statement.close();

                                    String insert = "INSERT INTO empleados VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

                                    PreparedStatement pst = conexion.prepareStatement(insert);

                                    pst.setString(1, emp_no);
                                    pst.setString(2, apellido);
                                    pst.setString(3, oficio);
                                    pst.setString(4, dir);
                                    pst.setString(5, fecha_alt);
                                    pst.setString(6, salario);
                                    pst.setString(7, comision);
                                    pst.setString(8, dept_no);

                                    int filas = pst.executeUpdate();

                                    System.out.println("Filas afectadas " + filas);

                                    rs.close();
                                    pst.close();
                                    conexion.close();

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
