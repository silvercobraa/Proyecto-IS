/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

import java.io.File;

public class Documento {
    private int id;
    /** 
     * Esta es una variable de clase que va a contar las solicitudes realizadas.
     * Para asignar el id a cada instancia, simplemente asignar el valor del contador.
     * Esta variable deberia ser atomica.
     */
    private static int contador = 0;

    public Documento() {
        this.id = contador;
        contador++;
    }
    public File descargar() {
        return null;
    }
    
}
