package com.mycompany.trabajointegrador;

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
    
    public int getVectorLength(){
        return partidos.length;
    }
    
    public Partido getPartido(int i){
        return partidos[i];
    }
    
    public void imprimirPartidos(){
        for(Partido partido : partidos){
            System.out.println("Equipo 1: " + partido.getEquipo1() + " Equipo 2: " + partido.getEquipo2() + " Goles 1: " + partido.getGolesEquipo1() + " Goles 2: " + partido.getGolesEquipo2() );
        }
    }
    
    //metodos
    //Agrega objeto Partido al vector.
    public void addPartido(Partido part) {
        if (numPartidos < partidos.length) {
            partidos[numPartidos] = part;
            numPartidos++;
        } else {
            System.out.println("No hay espacio para mas partidos");
        }
    }
    
    
}