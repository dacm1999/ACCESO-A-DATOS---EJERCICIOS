package f_mayo01;

import java.sql.*;

public class Ejercicio02 {

    public static void main(String[] args) {
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/hostal", "root", "");

            String tipoAlojamiento = "PC";

            String sql = "UPDATE HUESPEDES SET Tipo_Alojamiento = '" + tipoAlojamiento + "' WHERE NOMBRE = 'ERIA';";


            PreparedStatement statement = conexion.prepareStatement(sql);

            int modificar = statement.executeUpdate();


            String listar = "Select * from huespedes";
            statement = conexion.prepareStatement(listar);
            ResultSet rs = statement.executeQuery(listar);

            while (rs.next()){
                System.out.println(rs.getString(1)+ " " +
                        rs.getString(2)+ " "+
                        rs.getString(3)+ " " +
                        rs.getString(4)+ " "+
                        rs.getString(5) + " "+
                        rs.getString(6)+ " "+
                        rs.getString(7));
            }

            System.out.println("LINEAS AFECTADAS " + modificar);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
