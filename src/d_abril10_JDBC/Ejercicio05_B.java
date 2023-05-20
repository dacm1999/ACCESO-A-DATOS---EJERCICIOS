package d_abril10_JDBC;

import java.sql.*;

public class Ejercicio05_B {

    public static void main(String[] args) {


        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:/SQLITE/empleados.db");

            DatabaseMetaData db = conexion.getMetaData();

            ResultSet pk = null;
            ResultSet fk = null;

            pk = db.getPrimaryKeys(null,"empleados","departamentos");
            fk = db.getExportedKeys(null,"empleados", "departamentos");

            String pkDep ="", separador ="";
            while (pk.next()){
                pkDep = pkDep + separador + pk.getString("COLUMN_NAME");
                separador = "+";
            }
            System.out.println("Clave primaria " + pkDep);


            while(fk.next()){
                String fk_name = fk.getString("FKCOLUMN_NAME");
                String pk_name = fk.getString("PKCOLUMN_NAME");
                String pk_tableName = fk.getString("PKTABLE_NAME");
                String fk_tableName = fk.getString("FKTABLE_NAME");

                System.out.println("Tabla PK: " + pk_tableName + " " +
                        "Clave primaria: " + pk_name);

                System.out.println("Tabla FK: " + fk_tableName + " " +
                        "Clave primaria: " + fk_name);
            }

        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND");
        }
    }
}
