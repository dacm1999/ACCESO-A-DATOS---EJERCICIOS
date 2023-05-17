package e_abril17;

import java.sql.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static java.time.LocalDateTime.of;

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
                System.out.println("Introduce un apellido correcto ");
            } else {
                if (oficio.equals(" ") || oficio.equals(null)) {
                    System.out.println("Introduce un oficio correcto ");
                } else {

                    LocalDateTime fecha = now();

                    if (!fecha_alt.equals(fecha.toLocalDate().toString())) {
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

                                    String comprobarEmpleado = "SELECT COUNT(EMP_NO) FROM EMPLEADOS WHERE EMP_NO = " + emp_no + ";";


                                    Statement st = conexion.createStatement();
                                    ResultSet rs = st.executeQuery(comprobarEmpleado);

                                    int existe = 0;
                                    while (rs.next()) {
                                        existe = rs.getInt(1);
                                    }

                                    if (existe == 1) {
                                        System.out.println("El empleado introducido ya existe");
                                    }

                                    String comprobarDir = "SELECT COUNT(EMP_NO) FROM EMPLEADOS WHERE DIR = " + dir + ";";
                                    rs = st.executeQuery(comprobarDir);

                                    existe = 0;

                                    while (rs.next()) {
                                        existe = rs.getInt(1);
                                    }
                                    if (existe == 0) {
                                        System.out.println("El numero de que jefe no existe, introduce otro");
                                    }

                                    String comprobarDept = "SELECT COUNT(EMP_NO) FROM EMPLEADOS WHERE dept_no = " + dept_no + ";";
                                    rs = st.executeQuery(comprobarDept);

                                    existe = 0;
                                    while (rs.next()) {
                                        existe = rs.getInt(1);
                                    }

                                    if (existe == 0) {
                                        System.out.println("Introduce un departamento que exista");
                                    }

                                    st.close();

                                    String insertEmpleado = "INSERT INTO EMPLEADOS VALUES (?,?,?,?,?,?,?,?)";
                                    PreparedStatement pst = conexion.prepareStatement(insertEmpleado);

                                    pst.setInt(1, Integer.parseInt(emp_no));
                                    pst.setString(2, apellido);
                                    pst.setString(3, oficio);
                                    pst.setInt(4, Integer.parseInt(dir));
                                    pst.setString(5, fecha_alt);
                                    pst.setInt(6, Integer.parseInt(salario));
                                    pst.setInt(7, Integer.parseInt(comision));
                                    pst.setInt(8, Integer.parseInt(dept_no));

                                    pst.executeUpdate();

                                    System.out.println("Datos introducidos");

                                    pst.close();
                                    rs.close();

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
