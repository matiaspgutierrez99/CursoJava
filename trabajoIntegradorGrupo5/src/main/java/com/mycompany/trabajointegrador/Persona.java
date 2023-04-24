package com.mycompany.trabajointegrador;

public class Persona {
    private String nombre;
    private int puntos;
    private Pronostico [] pronosticos;
    private int acertados;
    private int apariciones;
    private String equipoSeleccionado;
    private int numPronosticos;
    private int iterador;
    
    public Persona(int maxPronosticos){
        this.pronosticos = new Pronostico[maxPronosticos];
        this.nombre = "";
        this.numPronosticos = 0;
        this.puntos = 0;
        this.acertados = 0;
        this.apariciones = 0; 
        this.iterador = 0;
    }
    
    //Getters y setters

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
    
    public Pronostico getPronostico(int i){
        return pronosticos[i];
    }
    //Imprimir pronosticos
    public void imprimirPronosticos(){
        for(int i=0;i<this.pronosticos.length;i++){
            System.out.println(pronosticos[i].devolverPronostico());
        }
    }
    
    
    //Agregar un pronostico
    public void addPronostico(Pronostico pron){
        if(numPronosticos < pronosticos.length){
            pronosticos[numPronosticos] = pron;
            numPronosticos++;
        }else{
            System.out.println("No hay espacio para mas pronosticos");
        }
    }
    
    //Calcular puntos
    public void contarPuntos(Ronda ronda,int puntosConfig,int cantPartidos,String equipoSeleccionado){
        resultadoEnum resultLocal;
        this.equipoSeleccionado = equipoSeleccionado;
        int verificarPuntosExtra = 0;
        for(int i=0;i<cantPartidos;i++){
            //Genera un resultado para poder comparar con el pronostico
            resultLocal = ronda.getPartido(i).getResultado();
            if((ronda.getPartido(i).getEquipo1().equals(this.equipoSeleccionado)) || (ronda.getPartido(i).getEquipo2().equals(this.equipoSeleccionado))){
                this.apariciones++;
            }
            //Agarro el vector de pronosticos y comparo empate
            if(pronosticos[this.iterador].getResultado().isEmpate() == false){
                //Si no hubo empate comparo el ganador
                if(pronosticos[this.iterador].getEquipoGanador().equals(resultLocal.getGanador())){
                    //Si la prediccion es igual al resultado real se suma 1 punto
                    this.puntos = this.puntos + puntosConfig;
                    verificarPuntosExtra++;
                    if(pronosticos[this.iterador].getEquipoGanador().equals(this.equipoSeleccionado)){
                        this.acertados++;
                    }
                }
            }else{
                if(pronosticos[this.iterador].getResultado().isEmpate() == resultLocal.isEmpate()){
                    this.puntos = this.puntos + puntosConfig;
                    verificarPuntosExtra++;
                    if((ronda.getPartido(i).getEquipo1().equals(this.equipoSeleccionado)) || (ronda.getPartido(i).getEquipo2().equals(this.equipoSeleccionado))){
                        this.acertados++;
                    }
                    
                }
            }
            this.iterador++;
        }
        //Si el verificador de puntos extra tiene la misma cantidad de puntos que partidos en la ronda se suman puntos extra
        if (verificarPuntosExtra == ronda.getVectorLength()){
            this.puntos = this.puntos + puntosConfig;
        }
        if((this.acertados == this.apariciones) && (this.acertados!= 0)){
            this.puntos = this.puntos + puntosConfig;
        }
    }
}
