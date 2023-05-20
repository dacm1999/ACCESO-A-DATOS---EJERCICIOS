package e_abril24_JDBC;

import java.sql.*;
import java.util.Scanner;

public class EjercicioRepaso {

    public static void main(String[] args) {

        boolean ejecutando = true;
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("Bienvenido, escoja el metodo que quiera utilizar");
            System.out.println("1- apellido_emp");
            System.out.println("2- datos_economic");
            System.out.println("3- aumentar_Comision");
            System.out.println("4- Total empleados");
            System.out.println("5- Datos_departamento");
            System.out.println("6- Salir");
            System.out.print("Opcion: ");
            int opcion = sc.nextInt();


            switch (opcion) {

                case 1: {

                    System.out.print("Introduce el numero del empleado: ");
                    int numEmpleado = sc.nextInt();

                    apellidoEmp(numEmpleado);
                }
                break;

                case 2: {
                    System.out.print("Introduce el apellido del empleado: ");
                    String apellido = sc.next();

                    datos_economic(apellido);
                }
                break;

                case 3: {

                    System.out.print("Introduce el numero del deparmento1: ");
                    int dept_no = sc.nextInt();
                    System.out.print("Introduce el numero del deparmento2: ");
                    int dept_no2 = sc.nextInt();

                    aumentar_Comision(dept_no, dept_no2);
                }
                break;

                case 4: {
                    System.out.print("Escribe el numero del departamento: ");
                    int dept_no = sc.nextInt();

                    cantidad_Empleados(dept_no);
                }
                break;

                case 5: {

                }
                break;

                case 6: {
                    System.out.println("Adios");
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


    public static void apellidoEmp(int emp_no) {
        String nombre = "";
        try {

            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            String sql = "{call apellido_emp(?,?)}";
            CallableStatement llamada = conexion.prepareCall(sql);


            llamada.setInt(1, emp_no);
            llamada.registerOutParameter(2, Types.VARCHAR);
            llamada.execute();


            nombre = llamada.getNString(2);

            llamada.close();
            conexion.close();

            System.out.println("\n" + "Apellido del empleado " + nombre + "\n");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void datos_economic(String apellidoEmp) {

        try {

            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            int salario = 0;
            float comision = 0;

            String sql = "{call datos_economic(?,?,?)}";
            CallableStatement llamada = conexion.prepareCall(sql);

            llamada.setString(1, apellidoEmp);
            llamada.registerOutParameter(2, Types.INTEGER);
            llamada.registerOutParameter(3, Types.FLOAT);
            llamada.execute();

            salario = llamada.getInt(2);
            comision = llamada.getFloat(3);

            System.out.println("\n" + "NOMBRE: " + apellidoEmp + " SALARIO " + salario + " COMISION " + comision + "\n");

            llamada.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void aumentar_Comision(int dept_no1, int dept_no2) {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            String sql = "{call aumentar_Comision(?,?)}";
            CallableStatement llamada = conexion.prepareCall(sql);

            llamada.setInt(1, dept_no1);
            llamada.setInt(2, dept_no2);
            llamada.execute();

            llamada.close();
            conexion.close();

            System.out.println("Datos modificados");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void cantidad_Empleados(int deptNo) {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            String sql = "{call cantidad_Empleados(?,?,?)} ";
            CallableStatement llamada = conexion.prepareCall(sql);

            llamada.setInt(1,deptNo);
            llamada.registerOutParameter(2,Types.INTEGER);
            llamada.registerOutParameter(3,Types.FLOAT);
            llamada.execute();

            int count = llamada.getInt(2);
            float salarioMedio = llamada.getFloat(3);

            System.out.println("\n"+"DEPARTAMENTO " + deptNo + " CANTIDAD DE EMPLEADOS " + count + " SALARIO MEDIO " + salarioMedio + "\n");


            llamada.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
