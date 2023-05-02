package d_abril10;

import java.sql.*;

public class Ejercicio04 {

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            DatabaseMetaData db = conexion.getMetaData();
            ResultSet rs = null;

            String nombre = db.getDatabaseProductName();
            String driver = db.getDriverName();
            String url = db.getURL();
            String usuario = db.getUserName();


            System.out.println("Informacion sobre la base de datos ");

            System.out.println("------------------------------------");
            System.out.println("Nombre: " + nombre);
            System.out.println("DRIVER: " + driver);
            System.out.println("URL " + url);
            System.out.println("USUARIO: "+ usuario + "\n");

            rs = db.getTables(null,"empleados",null, null);
            while (rs.next()){
                String catalogo = rs.getString(1);
                String esquema = rs.getString(2);
                String tabla = rs.getString(3);
                String tipo = rs.getString(4);
                System.out.println(catalogo + " " +
                        esquema + " " +
                        tabla + " " +
                        tipo + " ");
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND");
        } catch (NullPointerException ex){

        }
    }
}
