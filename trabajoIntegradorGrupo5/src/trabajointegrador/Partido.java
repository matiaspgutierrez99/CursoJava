
package trabajointegrador;


public class Partido {
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private resultadoEnum result;
    
    //Constructor vacio
    public Partido() {
        
    }
    
    //Constructor
    public Partido(String equipo1,String equipo2,int golesE1,int golesE2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesE1;
        this.golesEquipo2 = golesE2;
        resultadoEnum result = new resultadoEnum();
    }
    
    //Getters y Setters

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public void setResult(resultadoEnum result) {
        this.result = result;
    }
    
    public resultadoEnum getResultado(){
        return result;
    }
    
}
