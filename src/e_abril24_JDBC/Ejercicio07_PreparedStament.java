package e_abril24_JDBC;

import java.sql.*;

public class Ejercicio07_PreparedStament {

    public static void main(String[] args) {

        try{
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");


            int departamento = Integer.parseInt(args[0]);
            String sql = "SELECT * from empleados where dept_no = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setInt(1,departamento);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4) + " " +
                        rs.getString(5) + " " +
                        rs.getString(6) + " " +
                        rs.getString(7) + " " +
                        rs.getString(8) + " " );
            }

            rs.close();
            preparedStatement.close();


            String sql2 = "{call cantidad_Empleados(?, ?, ?)}";
            CallableStatement llamada = conexion.prepareCall(sql2);

            llamada.setInt(1,departamento);
            llamada.registerOutParameter(2,Types.INTEGER);
            llamada.registerOutParameter(3, Types.DECIMAL);

            llamada.execute();

            int cantidadEmpleados = llamada.getInt(2);
            double salarioMedio = llamada.getDouble(3);

            System.out.println("");
            System.out.println("Cantidad de empleados " + cantidadEmpleados);
            System.out.println("Salario medio: " + salarioMedio);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
