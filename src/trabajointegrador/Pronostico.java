package trabajointegrador;

public class Pronostico {
    private Partido partido;
    private String equipo;
    private resultadoEnum resultado;
    
    
    public Pronostico(Partido partido){
        this.partido = partido;
        this.equipo = "";
    }

    public String getEquipoGanador() {
        return equipo;
    }

    public void setEquipoGanador(String equipo) {
        this.equipo = equipo;
        this.resultado.setGanador(equipo);
        if (equipo.equals(partido.getEquipo1())){
            this.resultado.setPerdedor(partido.getEquipo2());
        }else{
            this.resultado.setPerdedor(partido.getEquipo1());
        }
    }
   
    public void elegirEmpate(){
        this.resultado.setEmpate(true);
    }
}

