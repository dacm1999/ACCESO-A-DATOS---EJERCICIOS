package e_abril17_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio01_B {
    public static void main(String[] args) {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");


            Statement sentencia = conexion.createStatement();


            String insert2 = "UPDATE empleados SET comision = CASE WHEN dir = 7698 THEN 200 ELSE 100 END WHERE dept_no = 30 AND dir <> emp_no AND dir = 7698;";
            int resultado = sentencia.executeUpdate(insert2);

            System.out.println("Files afectadas: " + resultado);

            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
           throw  new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND");
        }
    }
}