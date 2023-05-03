package e_abril17;

import java.sql.*;

public class Ejercicio01_A {
    public static void main(String[] args) {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");


            Statement sentencia = conexion.createStatement();

//            String insert =" insert into empleados values('0002','DEXTER','JEFE','0001','1998-04-24','3500','1000','30');";
            String insert2 = "INSERT INTO empleados VALUES ('7213', 'DURAN', 'VENDEDOR', '0002', '1990-01-01', '2300', '500', '30'),('0002','DEXTER','JEFE','0001','1998-04-24','3500','1000','30');";

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