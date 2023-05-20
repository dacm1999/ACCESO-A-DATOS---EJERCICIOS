package d_abril10_JDBC;

import java.sql.*;

public class Ejercicio05_A {

    public static void main(String[] args) {


        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:/SQLITE/empleados.db");

            DatabaseMetaData db = conexion.getMetaData();

            String nombre = db.getDatabaseProductName();
            String driver = db.getDriverName();
            String url = db.getURL();
            String user = db.getUserName();

            System.out.println("NOMBRE: " + nombre);
            System.out.println("DRIVER: " + driver);
            System.out.println("URL: " + url);
            System.out.println("USER: " + user + " \n");

            //INFORMACION RELATIVA DE LAS TABLAS
            // NOMBRE, CLAVE AJENA Y PK
            ResultSet rs = db.getTables(null, "empleados", null, null);
            while (rs.next()) {
                String catalogo = rs.getString(1);
                String esquema = rs.getString(2);
                String tabla = rs.getString(3);
                String tipo = rs.getString(4);

                System.out.println(catalogo + " " +
                        esquema + " " +
                        tabla + " " +
                        tipo + " ");
//
//                System.out.println(tabla + " " +
//                        tipo + " ");
            }

            rs.close();

        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND");
        }
    }
}
