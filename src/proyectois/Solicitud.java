/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;
import java.io.File;

public class Solicitud {
    private boolean validada = false;
    private int id;
    /** 
     * Esta es una variable de clase que va a contar las solicitudes realizadas.
     * Para asignar el id a cada instancia, simplemente asignar el valor del contador.
     * Esta variable deberia ser atomica.
     */
    private static int contador = 0;
    public Solicitud() {
        this.id = contador;
        contador++;
    }
    public void agregarDocumento(File documento) {
        // usar alguna estructura de datos aca
        // this.documentos.insert(documento);
    }
    // Submit. Sube la solicitud para que el validador la revise. Deberia bloquearse la instancia para que no pueda modificarse luego de enviar.
    public void enviar() {
        
    }
    /**
     * Define quien va a recibir el beneficio (afiliado, carga1, carga2...).
     */
    public void setBeneficiario() {
        
    }
}
