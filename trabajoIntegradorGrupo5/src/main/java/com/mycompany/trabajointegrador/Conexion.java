package com.mycompany.trabajointegrador;

import java.sql.*;
public class Conexion {
    //Creo una variable en la cual guardo el estado de la conexion de la base de datos
    private static Connection conexion;
    //Creo una instancia de conexion
    private static Conexion instancia;
    
    //Creo las credenciales
    private static final String URL = "jdbc:mysql://localhost/bd_participantes";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    //Metodo para conectarse a la base de datos
    
    
    //Metodo para cerrar la conexion
    public void cerrarConexion(){
        try{      
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public int devolverNumeroPersonas(int numlineas){
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch(Exception e){
             e.printStackTrace();
        }
        Statement stmt = null;
        ResultSet rs = null;
        int numPersonas = 0;
        try{
            stmt = conexion.createStatement();
            String sql = "SELECT * FROM pronosticos ORDER BY id";
            rs = stmt.executeQuery(sql);
            int id = 0;
            while(rs.next()){
                id = rs.getInt("id"); 
            }
            numPersonas = id/numlineas;
        }catch(SQLException se){
            //Agarra errores de JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Agarra errores de Class.forName
            e.printStackTrace();
        }finally{
            //Cierra recursos
            try{
                if(stmt!=null)
                        stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conexion != null)
                        conexion.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return numPersonas;
    }
    
    
    public Persona[] generarPersonas(int numlineas,int numPersonas){
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch(Exception e){
             e.printStackTrace();
        }
        //Creo un vector de personas
        Persona [] personas;
        personas = new Persona[numPersonas];
        //Creo un indice para moverme por el vector
        int i=0;
        int j=1;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = conexion.createStatement();
            String sql = "SELECT * FROM pronosticos ORDER BY id";
            rs = stmt.executeQuery(sql);
            Persona persona = new Persona(numlineas);
            while(rs.next()){
                Pronostico pronostico = new Pronostico();
                resultadoEnum resultado = new resultadoEnum();
                
                
                int id = rs.getInt("id");
                String nombre = rs.getString("participante");;
                String equipo1 = rs.getString("equipo1");
                boolean gana1 = rs.getBoolean("gana1");
                boolean empata = rs.getBoolean("empata");
                boolean gana2 = rs.getBoolean("gana2");
                String equipo2 = rs.getString("equipo2");
                
                System.out.println("id: " + id);
                System.out.println("equipo1: " + equipo1);
                System.out.println("gana1: " + gana1);
                System.out.println("empata: " + empata);
                System.out.println("gana2: " + gana2);
                System.out.println("equipo2: " + equipo2);
                if(gana1){
                        pronostico.setEquipoGanador(equipo1);
                        resultado.setGanador(equipo1);
                        resultado.setPerdedor(equipo2);
                    }else{
                        if(empata){
                            resultado.setEmpate(true);
                        }else{
                            if(gana2){
                                pronostico.setEquipoGanador(equipo2);
                                resultado.setGanador(equipo2);
                                resultado.setPerdedor(equipo1);
                            }
                        }
                }
                
                if (j == numlineas){
                    persona.setNombre(nombre);
                    pronostico.setResultado(resultado);
                    persona.addPronostico(pronostico);
                    personas[i] = persona;
                    persona = new Persona(numlineas);
                    i++;
                    j=1;
                }else{
                    j++;
                    pronostico.setResultado(resultado);
                    persona.addPronostico(pronostico);
                }
                

            }
        }catch(SQLException se){
            //Agarra errores de JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Agarra errores de Class.forName
            e.printStackTrace();
        }finally{
            //Cierra recursos
            try{
                if(stmt!=null)
                        stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conexion != null)
                        conexion.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        } 
        return personas;
    }
    
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}
