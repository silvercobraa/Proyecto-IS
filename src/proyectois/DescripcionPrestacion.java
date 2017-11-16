/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

/**
 *
 * @author Paulo
 */
public class DescripcionPrestacion {

    private int ID;
    private float porcentajeBonificacion;
    private int tope;

    public DescripcionPrestacion() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getPorcentajeBonificacion() {
        return porcentajeBonificacion;
    }

    public void setPorcentajeBonificacion(float porcentajeBonificacion) {
        this.porcentajeBonificacion = porcentajeBonificacion;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }
}
