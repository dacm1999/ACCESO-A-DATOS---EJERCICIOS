package g_examenes.JDBC.Examen02;

import java.sql.*;

public class Examen02 {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");

            if(args.length != 4){
                System.out.println("Introduce los argumentos necesarios");
            }else{
                int numPaciente = Integer.parseInt(args[0]);
                String nombre = args[1];
                String apellido = args[2];
                int numColegiado = Integer.parseInt(args[3]);

                if(numPaciente <= 0){
                    System.out.println("Introduce un numero mayor a 0");
                }else {
                    if(nombre.equals(" ") || nombre.equals(null)){
                        System.out.println("Introduce un nombre valido");
                    }else{
                        if(apellido.equals(" ") || apellido.equals(null)){
                            System.out.println("Introduce un apellido valido");
                        }else{
                            if(numColegiado <= 0){
                                System.out.println("introduce un numero de colegiado mayor a 0");
                            }else{

                                String comprobarNumPaciente ="SELECT COUNT(numpaciente) FROM pacientes WHERE numpaciente = '" + numPaciente + "';";
                                Statement st = conexion.createStatement();
                                ResultSet rs = st.executeQuery(comprobarNumPaciente);

                                int existe = 0;
                                while (rs.next()){
                                    existe = rs.getInt(1);
                                }

                                if(existe != 0){
                                    System.out.println("Paciente duplicado");
                                }else{

                                    String comprobarNumColegiado = "SELECT COUNT(numcolegiado) FROM pacientes WHERE numColegiado = '" + numColegiado + "';";
                                    rs = st.executeQuery(comprobarNumColegiado);
                                    existe = 0;

                                    while (rs.next()){
                                        existe = rs.getInt(1);
                                    }
                                    rs.close();
                                    st.close();

                                    if(existe ==0){
                                        System.out.println("El numero de colegiado no existe");
                                    }else{

                                        String insert = "INSERT INTO pacientes values (?,?,?,?)";
                                        PreparedStatement pst = conexion.prepareStatement(insert);

                                        pst.setInt(1,numPaciente);
                                        pst.setString(2,nombre);
                                        pst.setString(3,apellido);
                                        pst.setInt(4,numColegiado);

                                        int filas = pst.executeUpdate();

                                        System.out.println("Filas afectadas: " + filas);

                                        pst.close();
                                        conexion.close();
                                    }

                                }
                            }
                        }
                    }
                }

            }

        } catch (ClassNotFoundException e) {
            System.out.println("clase no encontrada");
        } catch (SQLException e) {
            System.out.println("ERROR AL EJECUTARSE " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
    }
}
