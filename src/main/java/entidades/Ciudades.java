/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author FJ
 */
public class Ciudades {
     private int id;
    private String nombre;
    private String descripcion;
    private int poblacion;
    private int paisID;
    
    private Paises pais ;

    public Ciudades() {
    }

    public Ciudades(int id, String nombre, String descripcion, int poblacion, int paisID, Paises pais) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poblacion = poblacion;
        this.paisID = paisID;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getPaisID() {
        return paisID;
    }

    public void setPaisID(int paisID) {
        this.paisID = paisID;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    
    
    
}
