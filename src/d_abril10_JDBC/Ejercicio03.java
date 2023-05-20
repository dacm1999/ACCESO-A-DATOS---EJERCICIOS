package d_abril10_JDBC;

import java.sql.*;

public class Ejercicio03 {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:/SQLITE/empleados.db");

            Statement sentencia = conexion.createStatement();
            String sql = "select * from empleados where dir = 7698;";

            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt("emp_no") + " " +
                        rs.getString("apellido") + " "+
                        rs.getInt("dir"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }
    }
}
