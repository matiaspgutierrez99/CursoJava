package com.mycompany.trabajointegrador;

public class Persona {
    private String nombre;
    private int puntos;
    private Pronostico[] pronosticos;

    private int acertados;

    public Persona(){
    }

    public void addPronostico(Pronostico pron){
       pronosticos = new Pronostico[]{pron};
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getAcertados() {
        return acertados;
    }

    public void setAcertados(int acertados) {
        this.acertados = acertados;
    }

}
