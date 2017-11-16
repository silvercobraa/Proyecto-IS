/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

import java.io.File;
import java.util.ArrayList;

public class Solicitud {

    private int ID;
    private ArrayList items;
    private static int contador = 0;

    public Solicitud() {
        this.ID = contador;
        contador++;
    }

    public void enviar() {

    }

    public void añadirItem() {
    }

    public int totalDevolucion() {

        return 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList getItems() {
        return items;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Solicitud.contador = contador;
    }

}
