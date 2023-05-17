package f_mayo01;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.*;

public class Ejercicio01 {


    public static void main(String[] args) {


        String nombre = args[1];
        String apellido = args[2];
        String num_Noches = args[3];
        String num_Huespedes = args[4];
        String tipo_Alojamiento = args[5];
        String importe = args[6];

        String dni = args[0];


        if (args.length != 7) {
            System.out.println("Introduce los argumentos necesarios");
        } else {
            if (nombre.equals(" ") || nombre.equals(null)) {
                System.out.println("Introduce un nombre correcto ");
            } else {
                if (apellido.equals(" ") || apellido.equals(null)) {
                    System.out.println("Introduce un apellido correcto");
                } else {
                    if (Integer.parseInt(num_Noches) <= 0) {
                        System.out.println("Introduce un valor mayor a 0 para las noches");
                    } else {
                        if (Integer.parseInt(num_Huespedes) <= 0) {
                            System.out.println("Introduce un numero de huespedes mayor a 0");
                        }else{
                            if (!tipo_Alojamiento.equals("SA") && !tipo_Alojamiento.equals("AD") && !tipo_Alojamiento.equals("MP") && !tipo_Alojamiento.equals("PC")) {
                                System.out.println("DEBES INTRODUCE TIPO DE ALOJAMIENTO CORRECTO");
                            } else {
                                if (Float.parseFloat(importe) <= 0) {
                                    System.out.println("Debes introducir un importe mayor a 0");
                                }else{

                                    try{
                                        Class.forName("org.sqlite.JDBC");
                                        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/hostal", "root", "");

                                        Statement st = conexion.createStatement();

                                        String comprobarDNI = "SELECT COUNT(DNI) FROM huespedes WHERE DNI = '" + dni + "';";
                                        ResultSet rs = st.executeQuery(comprobarDNI);

                                        int existe = 0;

                                        while (rs.next()){
                                            existe = rs.getInt(1);
                                        }

                                        if(existe == 1){
                                            System.out.println("EL DNI INTRODUCIDO YA EXISTE, POR FAVOR INTRODUCE OTRO");
                                        }


                                        st.close();
                                        rs.close();


                                        String insert = "INSERT into huespedes values (?,?,?,?,?,?,?)";
                                        PreparedStatement statement = conexion.prepareStatement(insert);

                                        statement.setString(1,dni);
                                        statement.setString(2,nombre);
                                        statement.setString(3,apellido);
                                        statement.setInt(4,Integer.parseInt(num_Noches));
                                        statement.setInt(5,Integer.parseInt(num_Huespedes));
                                        statement.setString(6,tipo_Alojamiento);
                                        statement.setFloat(7,Float.parseFloat(importe));


                                        statement.executeUpdate();
                                        System.out.println("Datos introducidos");



                                    } catch (SQLException e) {
                                        System.out.println("ERROR SQL");
                                    } catch (ClassNotFoundException e) {
                                        System.out.println("Clase no encontrada");
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