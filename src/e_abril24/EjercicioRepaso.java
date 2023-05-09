package e_abril24;

import java.sql.*;

public class EjercicioRepaso {

    public static void main(String[] args) {


        try{

            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            int numEmpleado = 7878;
            String sql = "{call apellido_emp(?,?)}";
            CallableStatement llamada = conexion.prepareCall(sql);

            llamada.setInt(1,numEmpleado);
            llamada.registerOutParameter(2, Types.VARCHAR);
            llamada.execute();


            String apellido = llamada.getNString(2);

            System.out.println("Apellido: " + apellido);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
