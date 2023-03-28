
package trabajointegrador;

public class Ronda {
    private String nro;
    private Partido [] partidos;
    private int numPartidos;
    private int puntos;
    
    //Constructor
    public Ronda(int maxPartido) {
        this.partidos = new Partido[maxPartido];
    }

    //Getters y Setters

    public String getNro() {
        return this.nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }
    
      
    public int getPuntos() {
        return this.puntos;
    }
    
    
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    //metodos
    public void addPartido(Partido part) {
        if (numPartidos < partidos.length) {
            partidos[numPartidos] = part;
            numPartidos++;
        } else {
            System.out.println("No hay espacio para mas partidos");
        }
    }
    
    
}
