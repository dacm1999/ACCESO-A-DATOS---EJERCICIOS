package e_abril17;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedMap;

public class Ejercicio03 {

    public static void main(String[] args) {

        File scripFile = new File("VIDEOCLUB.sql");
        System.out.println("Fichero de consulta: " + scripFile.getName());

        System.out.println("Convirtiendo fichero ");


        try{
            BufferedReader reader = new BufferedReader(new FileReader(scripFile));

            String linea = null;
            StringBuilder stringBuilder = new StringBuilder();
            String salto = System.getProperty("line.separator");

            while ((linea = reader.readLine()) != null){
                stringBuilder.append(linea);
                stringBuilder.append(salto);
            }

            String consulta = stringBuilder.toString();
            System.out.println(consulta);

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            Statement statement = conexion.createStatement();
            int resul = statement.executeUpdate(consulta);
            System.out.println("El script creado con existe, res "+ resul);


            conexion.close();
            statement.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("ERROR AL EJECUTAR EL SCRIP");
            throw  new RuntimeException(e);
        }

    }
}
