package d_abril10;

import java.sql.*;

public class Ejercicio02_A {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:/SQLITE/empleados.db");

            Statement sentencia = conexion.createStatement();
            String sql = "SELECT APELLIDO, OFICIO, SALARIO FROM EMPLEADOS WHERE DEPT_NO = 10";
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getString("apellido") + " " +
                                rs.getString("oficio") + " " +
                                rs.getInt("salario")

                );
            }

            conexion.close();
            sentencia.close();
            rs.close();
            System.out.println("Fin del programa");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (SQLException e) {
            System.out.println("ERROR SQL");
        }


    }
}
