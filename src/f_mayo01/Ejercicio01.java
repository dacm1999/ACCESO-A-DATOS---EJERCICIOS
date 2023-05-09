package f_mayo01;

import java.sql.*;

public class Ejercicio01 {


    public static void main(String[] args) {


        if (args.length != 7) {
            System.out.println("Introduce los argumentos necesarios");
        } else {
            String dni = args[0];

            if (dni.equals("") || dni.equals(null)) {
                System.out.println("Introduce un dni valido");
            } else {
                String nombre = args[1];

                if (nombre.equals("") || nombre.equals(null)) {
                    System.out.println("Introduce un nombre correcto");
                } else {
                    String apellido = args[2];
                    if (apellido.equals("") || apellido.equals(null)) {
                        System.out.println("Introduce un apellido correcto");
                    } else {
                        String pernoctas = args[3];
                        if (Integer.parseInt(pernoctas) <= 0) {
                            System.out.println("Introduce un numero mayor de noches a 0");
                        } else {
                            String numHuespedes = args[4];
                            if (Integer.parseInt(numHuespedes) <= 0) {
                                System.out.println("Introduce un numero de huespedes mayor a 0");
                            } else {
                                String tipoAlojamiento = args[5];
                                if (!tipoAlojamiento.equalsIgnoreCase("MP") && !tipoAlojamiento.equalsIgnoreCase("PC") && !tipoAlojamiento.equalsIgnoreCase("AD") &&
                                        !tipoAlojamiento.equalsIgnoreCase("SA")) {

                                    System.out.println("Introduce un tipo de alojamiento valido");
                                } else {
                                    String importe = args[6];
                                    if (Integer.parseInt(importe) <= 0) {
                                        System.out.println("Introduce un importe mayor a 0");
                                    } else {
                                        try {
                                            Class.forName("org.sqlite.JDBC");
                                            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/hostal", "root", "");


                                            String comprobarCliente = "SELECT COUNT(DNI) FROM huespedes WHERE DNI = '" + dni + "';";

                                            int verificarDNI = 0;
                                            PreparedStatement preparedStatement = conexion.prepareStatement(comprobarCliente);
                                            ResultSet resultSet = preparedStatement.executeQuery(comprobarCliente);

                                            while (resultSet.next()){
                                                verificarDNI = resultSet.getInt(1);
                                            }

                                            if(verificarDNI == 1){
                                                System.out.println("El numero del DNI YA EXISTE");
                                            }

                                            String sql = "INSERT INTO huespedes VALUES('" + dni + "', '"
                                                    + nombre
                                                    + "', '"
                                                    + apellido
                                                    + "', '"
                                                    + pernoctas
                                                    + "', '"
                                                    + numHuespedes
                                                    + "', '"
                                                    + tipoAlojamiento
                                                    + "', '"
                                                    + importe
                                                    + "');";

                                            preparedStatement = conexion.prepareStatement(sql);
                                            int insertar = preparedStatement.executeUpdate(sql);


                                            String sql2 = "Select * from Huespedes";
                                            preparedStatement = conexion.prepareStatement(sql2);
                                            resultSet = preparedStatement.executeQuery();

                                            while (resultSet.next()) {
                                                System.out.println("DNI: " + resultSet.getString(1) +
                                                        " NOMBRE: " + resultSet.getString(2) +
                                                        " APELLIDO: " + resultSet.getString(3) +
                                                        " NOCHES: " + resultSet.getString(4) +
                                                        " HUESPEDES: " + resultSet.getString(5) +
                                                        " TIPO ALOJAMIENTO: " + resultSet.getString(6) +
                                                        " IMPORTE: " + resultSet.getString(7));
                                            }


                                            System.out.println("Numero de filas afectadas " + insertar);

                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        } catch (ClassNotFoundException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
