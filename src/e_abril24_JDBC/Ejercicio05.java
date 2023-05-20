package e_abril24_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio05 {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");


            if(args.length != 2){
                System.out.println("INTRODUCE LOS ARGUMENTOS REQUERIDOS");
            }else{
                String departamento1 = args[0];
                String departamento2 = args[1];

                String sql = "{call aumentar_Comision(?,?)}";
                CallableStatement llamada = conexion.prepareCall(sql);

                llamada.setInt(1,Integer.parseInt(departamento1));
                llamada.setInt(2,Integer.parseInt(departamento2));

                llamada.executeUpdate();
                System.out.println("Subida salario realizada");

                llamada.close();
                conexion.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
