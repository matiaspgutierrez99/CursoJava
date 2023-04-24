package com.mycompany.trabajointegrador;
import org.junit.Test;
import static org.junit.Assert.*;

public class PronosticosTest {

    @Test
    public void TestPersona() {
        //HAY QUE MODIFICAR EL MAIN ACORDE A LAS NUEVOS MODULOS Y OBJETOS, FALTA TERMINAR ALGUNOS MODULOS QUE AFECTAN AL OBJETO RONDA

        String rutaResultados = "C:/Users/User/OneDrive/Documentos/GitHub/Fork/CursoJava/resultadosPrueba.csv";

        String rutaPronosticos = "C:/Users/User/OneDrive/Documentos/GitHub/Fork/CursoJava/pronosticoPrueba.csv";
        TrabajoIntegrador.leerArchivo(rutaResultados);
        //CALCULAR CANTIDAD DE PARTIDOS DENTRO DEL CSV POR RONDA
        int cantidadPartidos = TrabajoIntegrador.cantPartidos(rutaResultados);
        //CALCULAR CANTIDAD DE PERSONAS DENTRO DEL CSV
        int cantidadPersonas = TrabajoIntegrador.calcularPersonas(rutaPronosticos, cantidadPartidos);
        //CREACION DE LAS RONDAS
        Ronda [] rondas = TrabajoIntegrador.generarRondas(rutaResultados);
        TrabajoIntegrador.iniciarRondas(rondas,cantidadPartidos);
        //SI DENTRO DEL ARCHIVO HABIA RONDAS
        if (rondas != null){
            //Se completan los objetos Ronda con la informacion del csv
            TrabajoIntegrador.llenarRondas(rutaResultados, rondas);
            //Imprimo el contenido del vector de rondas
            TrabajoIntegrador.imprimirPartidos(rondas);

            Persona[] personas = TrabajoIntegrador.generarPersonas(rutaPronosticos, cantidadPartidos, cantidadPersonas);

            //Pronostico[] persona = TrabajoIntegrador.generarPersona(rutaPronosticos, ronda.getVectorLength());
            //IMPRIMO LOS PRONOSTICOS DE LAS PERSONAS
            TrabajoIntegrador.imprimirPersonas(personas);
            //ACTUALIZO LOS PUNTOS
            TrabajoIntegrador.actualizarPuntos(personas, rondas);
            //IMPRIMO PUNTOS
            TrabajoIntegrador.imprimirPuntos(personas);

            int expResult = 0;

            assertEquals(expResult,TrabajoIntegrador.imprimirPuntoss(personas));

        }
    }
}