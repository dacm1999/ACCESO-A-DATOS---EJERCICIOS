package d_abril10;

import java.sql.*;

public class Ejercicio06 {

    public static void main(String[] args) {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:/SQLITE/empleados.db");

            DatabaseMetaData db = conexion.getMetaData();

            ResultSet columnas = db.getColumns(null,"empleados","departamentos",null);

            while (columnas.next()){
                String nombreCo = columnas.getString("Column_NAME");
                String type = columnas.getString("TYPE_NAME");
                String tam = columnas.getString("COLUMN_SIZE");
                String nula = columnas.getString("IS_NULLABLE");

                System.out.println("Nombre columna: "+ nombreCo + " " +
                        "Tipo " +  type + " " +
                        "Tamaño: " + tam + " " +
                        "Es nula?  " + nula );

            }
            columnas.close();


        } catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND");
        }
    }
}
