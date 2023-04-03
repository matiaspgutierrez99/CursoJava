package trabajointegrador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TrabajoIntegrador {
    private static String linea; //recibe la linea de cada fila
    private static String[] partes = null; //almacena cada linea leída

    //LOS METODOS SON ESTÁTICOS PARA QUE SE PUEDA ACCEDER A ELLOS SIN INSTANCIAR LA CLASE.
    public static void leerArchivo(String ruta){
        try{
            //lee el archivo
            BufferedReader lector = new BufferedReader(new FileReader(ruta)); //Le pasamos una ruta a BufferReader para que lea el archivo.
            while((linea = lector.readLine()) != null){ //Esto hace que se lea la linea siempre que no este vacia.
                partes = linea.split(";"); //Separa los String desde el ;
                imprimirLinea(); //Llama a la funcion de abajo
                System.out.println(" ");
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e){ //Atrapa la exception por si ocurre un error con el csv.
            e.printStackTrace();
        }
    }

    public static void imprimirLinea(){
        for (String parte : partes) { //Recorre el arreglo partes(donde estan guardadas las lineas)
            System.out.print(parte + " | "); //Los separa con un |

        }
    }
    
    public static void leerPartidosDeCSV(String ruta,Ronda ronda){
        String csvFile = ruta;
        String csvDelimiter = ";";
        String [] expectativaHeader = {"Equipo1","Goles1","Goles2","Equipo2"};
        
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            //Leo y valido el HEADER del CSV
            String[]header = br.readLine().split(csvDelimiter);
            if (header.equals(expectativaHeader)){
                throw new IllegalArgumentException("El archivo CSV no contiene las columnas que se esperaban");
            }
    
            //Loop por cada una de las filas del archivo
            String linea;
            while((linea  = br.readLine()) != null){
                String[]fields = linea.split(csvDelimiter);
                
                //Crear y llenar el objeto partido
                Partido partido = new Partido();
                partido.setEquipo1(fields[0]);
                partido.setGolesEquipo1(Integer.parseInt(fields[1]));
                partido.setGolesEquipo2(Integer.parseInt(fields[2]));
                partido.setEquipo2(fields[3]);
                
                ronda.addPartido(partido);
            }
        }catch(IOException e){ //Atrapa la exception por si ocurre un error con el csv.
            e.printStackTrace();
        }
    }
    
    
    public static Ronda generarRonda(String ruta){
        String csvFile = ruta;
        String csvDelimiter = ";";
        String [] expectativaHeader = {"Equipo1","Goles1","Goles2","Equipo2"};
        Ronda ronda = null;
        
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            //Leo y valido el HEADER del CSV
            String[]header = br.readLine().split(csvDelimiter);
            if (header.equals(expectativaHeader)){
                throw new IllegalArgumentException("El archivo CSV no contiene las columnas que se esperaban");
            }
            
            //Creo la ronda
            int contadorLineas = 0;
            
            while(br.readLine() != null){
                contadorLineas++;
            }
            
            ronda = new Ronda(contadorLineas);
            
            
            
        }catch(IOException e){ //Atrapa la exception por si ocurre un error con el csv.
            e.printStackTrace();
        }
        
        return ronda;
    }
    
    public static Pronostico[] generarPersona(String ruta,int numLineas){
   
        String csvFile = ruta;
        String csvDelimiter = ";";
        String [] expectativaHeader = {"Equipo1","Gana1","Empata","Gana2","Equipo2"};
        //Creo persona
        Pronostico [] persona;
        
        persona = new Pronostico[numLineas];
        int i=0;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            //Leo y valido el HEADER del CSV
            String[]header = br.readLine().split(csvDelimiter);
            if (header.equals(expectativaHeader)){
                throw new IllegalArgumentException("El archivo CSV no contiene las columnas que se esperaban");
            }
            while((linea  = br.readLine()) != null){
                String[]fields = linea.split(csvDelimiter);
                
                //Crear y llenar el objeto pronostico
                
                Pronostico pronostico = new Pronostico();
                resultadoEnum resultado = new resultadoEnum();
                
                //
                if(fields[1].equals("TRUE")){
                    pronostico.setEquipoGanador(fields[0]);
                    resultado.setGanador(fields[0]);
                    resultado.setPerdedor(fields[4]);
                }else{
                    if(fields[2].equals("TRUE")){
                        resultado.setEmpate(true);
                    }else{
                        if(fields[3].equals("TRUE")){
                            pronostico.setEquipoGanador(fields[4]);
                            resultado.setGanador(fields[4]);
                            resultado.setPerdedor(fields[0]);
                        }   
                    
                    }
                
                }
                
                pronostico.setResultado(resultado);
                
                persona[i] = pronostico;
                i++;
            }
           
            
            
        }catch(IOException e){ //Atrapa la exception por si ocurre un error con el csv.
            e.printStackTrace();
        }
        
        return persona;
    }
    
    public static void imprimirPersona(Pronostico[]persona){
        for(int i=0;i<persona.length;i++){
            persona[i].imprimirPronostico();
        }
    
    }
    
    public static void main(String[] args) {
        //HAY QUE IMPLEMENTAR LO DE LAS RUTAS GLOBALES YA QUE ESTA ES DE PRUEBA PARA VER SI FUNCIONABA
        String rutaResultados = "../resultados.csv";
        String rutaPronosticos = "../pronostico.csv";
        TrabajoIntegrador.leerArchivo(rutaResultados);
        
        Ronda ronda = TrabajoIntegrador.generarRonda(rutaResultados);
        if (ronda != null){     
            TrabajoIntegrador.leerPartidosDeCSV(rutaResultados, ronda);
        
            ronda.imprimirPartidos();
            
            Pronostico[] persona = TrabajoIntegrador.generarPersona(rutaPronosticos, ronda.getVectorLength());
            
            imprimirPersona(persona);
        }
        //Crear persona , despues hay q pasarlo a un objeto para la segunda entrega
        
        
        
        

        
    }
    

}
