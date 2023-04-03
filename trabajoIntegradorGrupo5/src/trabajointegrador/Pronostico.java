package trabajointegrador;

public class Pronostico {
    private Partido partido;
    private String equipo;
    private resultadoEnum resultado;
    
    
    public Pronostico(){
        this.equipo="";
    }
    
    
    public void setPartido(Partido partido){
        this.partido = partido;
    }

    public void setResultado(resultadoEnum resultado) {
        this.resultado = resultado;
    }
    
    public void imprimirPronostico(){
        if(this.equipo.equals("")){
            System.out.println("Elegio Empate");
        }else{
            System.out.println("Equipo ganador"+this.equipo);
        }
           
    }
    
    public String getEquipoGanador() {
        return equipo;
    }

    public void setEquipoGanador(String equipo) {
        this.equipo = equipo;
    }
   
}

