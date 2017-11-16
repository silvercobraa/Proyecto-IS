/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;


public class Carga {
    private String rut;
    private String nombre;
    private Afiliado padre;
    
    public Carga() {
        
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Afiliado getPadre() {
        return padre;
    }

    public void setPadre(Afiliado padre) {
        this.padre = padre;
    } 
}
