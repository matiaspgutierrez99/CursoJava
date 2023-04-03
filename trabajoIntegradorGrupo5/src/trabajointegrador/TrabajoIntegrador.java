package trabajointegrador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                imprimirLinea(); //LLama a la funcion de abajo
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
    
    public static void main(String[] args) {
        //HAY QUE IMPLEMENTAR LO DE LAS RUTAS GLOBALES YA QUE ESTA ES DE PRUEBA PARA VER SI FUNCIONABA
        TrabajoIntegrador.leerArchivo("C:\\Users\\User\\OneDrive\\Documentos\\GitHub\\Fork\\CursoJava\\pronostico.csv");


        
    }
    

}
