
package trabajointegrador;

public class resultadoEnum {
    private String ganador;
    private String perdedor;
    private boolean empate;
    
    //Constructor
    public resultadoEnum() {
        this.empate = false;
    }
    
    //Getter y Setters

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getPerdedor() {
        return perdedor;
    }

    public void setPerdedor(String perdedor) {
        this.perdedor = perdedor;
    }

    public boolean isEmpate() {
        return empate;
    }

    public void setEmpate(boolean empate) {
        this.empate = empate;
    }
    
    
}
