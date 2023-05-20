package e_abril24_JDBC;

import java.sql.*;

public class Ejercicio07_Stament {

    public static void main(String[] args) {

        try{
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            if(args.length != 1){
                System.out.println("Introduce los argumentos necesarios");
            }else {
                String departamento = args[0];

                String consulta = "Select * from empleados where dept_no = " + departamento;
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery(consulta);

                while (resultSet.next()){
                    System.out.println(resultSet.getString(1) + " " +
                            resultSet.getString(2) + " " +
                            resultSet.getString(3) + " " +
                            resultSet.getString(4) + " " +
                            resultSet.getString(5) + " " +
                            resultSet.getString(6) + " " +
                            resultSet.getString(7) + " " +
                            resultSet.getString(8) + " " );
                }

                System.out.println("\n");
                resultSet.close();
                statement.close();

//                String sql = "{call datos_economic(?, ?, ?)}";
                String sql = "{call cantidad_Empleados(?, ?, ?)}";
                CallableStatement llamada = conexion.prepareCall(sql);


                llamada.setString(1,departamento);
                llamada.registerOutParameter(2, Types.INTEGER);
                llamada.registerOutParameter(3, Types.DECIMAL);

                llamada.execute();
                int numEmpleados = llamada.getInt(2);
                double salarioMedio = llamada.getDouble(3);



                System.out.println("Numero de empleados " + numEmpleados);
                System.out.println("Salario medio " + salarioMedio);

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
