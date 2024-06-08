/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author FJ
 */
public class Paises {
    private int id;
    private String nombre;
    private String descripcion;
    private String continente;

    public Paises() {
    }

    public Paises(int id, String nombre, String descripcion, String continente) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.continente = continente;
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

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
