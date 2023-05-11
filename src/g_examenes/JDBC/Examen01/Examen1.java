package g_examenes.JDBC.Examen01;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.locks.StampedLock;

public class Examen1 {

    /**
     * Si el usuario pulsa 1 se pondra in pago. Utilizando la interfaz PReparedStament
     * se insertara los datos de pago. para ello se pedira el codigo de cliente
     * pago, el identificador de pago (solo introducira el numero, por ejemplo 19 y el programama,
     * creara el resto de la clava "ak-std-000019), como fecha se introducira la del dia actual y el total.
     * <p>
     * <p>
     * Si el cliente no existe, entonces se debe crear primero el cliente en la base de datos y para ello solo se pediran los datos necesarios,los que se puedan dejar vacios no es necesario
     * solicitarlos al usuario. Una vez creador el client, se procedera a insertar el pago de la misma forma que en el anterior apartado.
     * <p>
     * Si el usuario inserta 2, se creara los procedimientos y/o funciones necesarias en MySQL para que funcione el siguiente programa
     * Se solicita al usuario el nombre, apellido y forma de pago de un cliente. Si el lciente no existe se muestra mensaje de la tabla de pago con el que el usuario
     * ha introducido.
     * <p>
     * Solo se podra usar el CallableStamente en este ejercicio, cualquier otra solucion no tendra puntuacion.
     * <p>
     * Si el usuario pulsa 3, se cerrará el programa, se pueda pulsar las opciones 1, 2 y 3 tanras veces como se quiera. Cualquier otra opcion marcada
     * se mostrara error en la opcion, pero no termianra el programa
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean ejecutando = true;

        do {
            try {


                System.out.println("Introduce una opcion:");
                System.out.println("1 insertar");
                System.out.println("2 detalle");
                System.out.println("3 salir");

                int opcion = sc.nextInt();

                switch (opcion) {

                    case 1: {
                        System.out.println("Introduce tu codigo de cliente");
                        int codigoCliente = sc.nextInt();
                        pago(codigoCliente);
                        sc.nextLine();


                    }
                    break;

                    case 2: {
                        System.out.println("Introduce un nombre de cliente: ");
                        String nombre = sc.next();
                        System.out.println("Introduce un apellido de cliente: ");
                        String apellido = sc.next();
                        System.out.println("Introduce un nuevo m�todo de pago: ");
                        String metodo = sc.next();
                        detalle(nombre, apellido, metodo);
                        sc.nextLine();
                    }
                    break;

                    case 3: {
                        ejecutando = false;
                    }
                    break;

                    default:
                        System.out.println("Introduce una opcion valida");
                        break;
                }


            } catch (NumberFormatException ex) {
                System.out.println("Introduce un numero");
            } catch (InputMismatchException ex) {
                System.out.println("Introduce un numero");
            }
        } while (ejecutando);
    }


    /**
     * Opcion1
     *
     * @param codigoCliente
     */
    public static void pago(int codigoCliente) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "root", "");

            boolean clieExist;

            while (true) {

                clieExist = clienteExiste(codigoCliente);
                if (clieExist) {

                    System.out.println("Introduce el metodo de pago:");
                    String metodo = sc.next();
                    System.out.println("Introduce un identidicar de pago");
                    int num = sc.nextInt();
                    String id = "ak-std-0000" + num;
                    System.out.println("Introduce un total de pago");
                    float pago = sc.nextFloat();


                    String verificarPago = "SELECT COUNT(id_pago) FROM pago WHERE id_pago = '" + id + "';";
                    Statement sente = conexion.createStatement();

                    ResultSet rs = sente.executeQuery(verificarPago);
                    int idPagoExist = 0;
                    while (rs.next()) {
                        idPagoExist = rs.getInt(1);
                    }
                    sente.close();

                    if (idPagoExist == 0) {

                        String insertarPago = "INSERT INTO  PAGO VALUES(?,?,?,CURDATE(),?)";
                        PreparedStatement pst = conexion.prepareStatement(insertarPago);

                        pst.setInt(1, codigoCliente);
                        pst.setString(2, metodo);
                        pst.setString(3, id);
                        pst.setFloat(4, pago);

                        int filas = pst.executeUpdate();

                        System.out.println("Filas insertadas " + filas);

                        pst.close();

                    } else {
                        System.out.println("Codigo de pago duplicado");
                    }

                } else {
                    System.out.println("El cliente no existe, vamos a crearlo");

                    System.out.println("Introduce el codigo de cliente ");

                    int codigo = sc.nextInt();

                    System.out.println("Introduce tu nombre");
                    String nombre = sc.next();

                    String clienteInsertar = "INSERT INTO  cliente(codigo_cliente,nombre_cliente) values (?,?) ";
                    PreparedStatement pst = conexion.prepareStatement(clienteInsertar);

                    pst.setInt(1, codigo);
                    pst.setString(2, nombre);

                    int filas = pst.executeUpdate();

                    System.out.println("Filas afectadas " + filas);
                    pst.close();
                }

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InputMismatchException ex) {
            System.out.println("Introduce un valor correcto");
        }
    }


    public static boolean clienteExiste(int codCliente) {
        boolean exist = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "root", "");

            Statement sent1 = conexion.createStatement();
            String clieExist = String.format("SELECT COUNT(*) FROM cliente WHERE codigo_cliente=%d", codCliente);
            ResultSet rs1 = sent1.executeQuery(clieExist);
            int codClieExist = 0;
            while (rs1.next()) {
                codClieExist = rs1.getInt(1);
            }
            sent1.close();

            if (codClieExist != 0) {
                exist = true;
            } else {
                exist = false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Introduce un dato v�lido");
        }
        return exist;
    }



    public static void detalle(String nombre, String apellido, String metodo){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "root", "");

            String proc = "{call pago(?,?,?,?)}";

            CallableStatement llamada = conexion.prepareCall(proc);

            llamada.registerOutParameter(3,Types.VARCHAR);
            llamada.setString(1,nombre);
            llamada.setString(1, nombre);
            llamada.setString(2, apellido);
            llamada.setString(3, metodo);
            llamada.executeUpdate();

            System.out.println(llamada.getString(4));

            llamada.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
