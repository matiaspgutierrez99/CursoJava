package conexion;

import java.sql.*;

import static conexion.sql.ConectorSQL.DB_URL;
import static conexion.sql.ConectorSQL.USER;
import static conexion.sql.ConectorSQL.PASS;


public class Conexion {


    public class Main {

        public static void main(String[] args) {
            Connection conexion = null;
            Statement consulta = null;

            try {

                // Abrir la conexión
                System.out.println("conectando a la base de datos...");

                conexion = DriverManager.getConnection(DB_URL, USER, PASS);

                // Ejecutar una consulta
                System.out.println("Creating statement...");
                consulta = conexion.createStatement();
                String sql;
                sql = "SELECT id, nombre, puntos FROM prode.personas";

                //En la variable resultado obtendremos las distintas filas que nos devolvió la base
                ResultSet resultado = consulta.executeQuery(sql);

                // Obtener las distintas filas de la consulta
                while (resultado.next()) {
                    // Pbtener el valor de cada columna
                    int id = resultado.getInt("id");
                    String Nombre = resultado.getString("Nombre");
                    int Puntos = resultado.getInt("Puntos");

                    // Mostrar los valores obtenidos
                    System.out.print("ID: " + id);
                    System.out.print(", Nombre: " + Nombre);
                    System.out.println(", Puntos: " + Puntos);
                }
                resultado.close();
                consulta.close();
                conexion.close();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {

                try {
                    if (consulta != null)
                        consulta.close();
                } catch (SQLException se2) {
                }
                try {
                    if (conexion != null)
                        conexion.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("Fin de la ejecucción");
        }
    }
}
