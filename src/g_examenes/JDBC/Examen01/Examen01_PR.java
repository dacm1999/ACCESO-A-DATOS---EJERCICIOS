package g_examenes.JDBC.Examen01;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

import static java.time.LocalDateTime.now;


public class Examen01_PR {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean ejecutando = true;

        do {
            System.out.println("--------------------MENU----------");
            System.out.println("1 insertar");
            System.out.println("2 detalle");
            System.out.println("3 salir");
            System.out.print("Introduce una opcion:");
            int opcion = sc.nextInt();

            switch (opcion){

                case 1:{

                    System.out.println("Introduce el codigo del cliente");
                    int codigo_cliente = sc.nextInt();
                    pagoCliente(codigo_cliente);
                }
                break;

                case 2:{

                }
                break;

                case 3:{

                }
                break;

                default:{
                    System.out.println("Introduce una opcion valida");
                }
                break;
            }

        } while (ejecutando);

    }

    private static void pagoCliente(int codigoCliente) {

        Scanner sc = new Scanner(System.in);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "root", "");

            boolean clienteExiste;

            do{
                clienteExiste = comprobarCliente(codigoCliente);

                if(clienteExiste == true){

                    System.out.println("Introduce el metodo de pago:");
                    String metodo = sc.next();
                    System.out.println("Introduce un identidicar de pago");
                    int num = sc.nextInt();
                    String id = "ak-std-0000" + num;
                    System.out.println("Introduce un total de pago");
                    float pago = sc.nextFloat();

                    String verificarPago = "SELECT COUNT(id_pago) FROM pago WHERE id_pago = '" + id + "';";

                    Statement st = conexion.createStatement();
                    ResultSet rs = st.executeQuery(verificarPago);

                    int existe = 0;

                    while (rs.next()){
                        existe = rs.getInt(1);
                    }

                    if(existe == 1){
                        System.out.println("Introduce un otro numero de cliente");
                    }


                    LocalDateTime fecha = now();

                    String insert = "INSERT INTO pago values(?,?,?,?,?)";
                    PreparedStatement pst = conexion.prepareStatement(insert);
                    pst.setInt(1,codigoCliente);
                    pst.setString(2,metodo);
                    pst.setString(3,id);
                    pst.setString(4,fecha.toString());
                    pst.setFloat(5,pago);

                    int filas = pst.executeUpdate();

                    System.out.println("Filas afectadas " + filas);

                    pst.close();
                    conexion.close();
                    rs.close();

                    break;

                }else{

                    System.out.println("El codigo de cliente no existe");
                    System.out.println("Introduce un codigo de cliente: ");
                    int codigo = sc.nextInt();
                    System.out.println("Introduce un nombre del cliente");
                    String nombre = sc.next();

                    String clienteInsertar = "INSERT INTO  cliente(codigo_cliente,nombre_cliente) values (?,?) ";
                    PreparedStatement pst = conexion.prepareStatement(clienteInsertar);

                    pst.setInt(1, codigo);
                    pst.setString(2, nombre);

                    int filas = pst.executeUpdate();

                    System.out.println("Filas afectadas " + filas);
                    pst.close();
                }
            }while (true);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private static boolean comprobarCliente(int codigoCliente){
        boolean clienteExiste;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "root", "");

            Statement st = conexion.createStatement();
            String comprobarCLiente = "Select count(codigo_cliente) from cliente where codigo_cliente = '" + codigoCliente + "';";;
            ResultSet rs = st.executeQuery(comprobarCLiente);

            int verdadero = 0;

            while ((rs.next())){
                verdadero = rs.getInt(1);
            }

            if(verdadero != 0){
                clienteExiste = true;
            }else{
                clienteExiste = false;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clienteExiste;
    }
}
