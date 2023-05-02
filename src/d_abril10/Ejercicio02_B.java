package d_abril10;

import java.sql.*;

public class Ejercicio02_B {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:/SQLITE/empleados.db");

            Statement sentencia = conexion.createStatement();
//            String sql = "INSERT INTO DEPARTAMENTOS VALUES (90,RHHH, SALAMANCA), (100, MECANICA, PALENCIA), (110, PUBLICIDAD, ZAMORA);";
            String sql = "select * from departamentos";
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("dept_no") + " " +
                                rs.getString("dnombre") + " " +
                                rs.getString("loc")
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
