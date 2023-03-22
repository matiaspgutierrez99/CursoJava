/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajointegrador;

/**
 *
 * @author matia
 */
public class Equipo {
    private String nombre;
    private String descripcion;
    
    //Constructor
    public Equipo(String nombre,String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //Getter y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
