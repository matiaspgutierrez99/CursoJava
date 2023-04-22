package com.mycompany.trabajointegrador;


import java.sql.*;

//import static conexion.sql.ConectorSQL.DB_URL;
//import static conexion.sql.ConectorSQL.USER;
//import static conexion.sql.ConectorSQL.PASS;


public class Conexion {


    public class Main {

        public static void main(String[] args) {
            Connection conexion = null;
            Statement consulta = null;

            try {

                // Abrir la conexión
                System.out.println("conectando a la base de datos...");

                //conexion = DriverManager.getConnection(DB_URL, USER, PASS);

                // Ejecutar una consulta
                System.out.println("Creating statement...");
                consulta = conexion.createStatement();
                String sql;
                sql = "SELECT * FROM pronosticos";

                //En la variable resultado obtendremos las distintas filas que nos devolvió la base
                ResultSet resultado = consulta.executeQuery(sql);

                // Obtener las distintas filas de la consulta
                while (resultado.next()) {
                    // Obtener el valor de cada columna
                    String Participante = resultado.getString("Participante");
                    String Equipo_1 = resultado.getString("Equipo 1");
                    boolean Gana_1 = resultado.getBoolean("Gana 1");
                    boolean Empata = resultado.getBoolean("Empata");
                    boolean Gana_2= resultado.getBoolean("Gana 2");
                    String Equipo_2 = resultado.getString("Equipo 2");


                    // Mostrar los valores obtenidos
                    System.out.println("Participante" + Participante);
                    System.out.println(", Equipo 1: " + Equipo_1);
                    System.out.println(", Gana 1: " + Gana_1);
                    System.out.println(", Empata: " + Empata);
                    System.out.println(", Gana 2: " + Gana_2);
                    System.out.println(", Equipo 2: " + Equipo_2);
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
