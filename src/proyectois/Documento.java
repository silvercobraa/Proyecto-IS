/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

import java.io.File;

public class Documento {
    private int ID;
    private static int contador = 0;

    public Documento() {
        this.ID = contador;
        contador++;
    }
    public File descargarDocumento() {
        return null;     
    }
}
