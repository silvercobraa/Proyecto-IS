/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

public class ItemSolicitud {

    private int id;
    private int monto;
    private boolean validado;

    public ItemSolicitud() {

    }

    protected void agregarDocumento() {
    }

    protected void obtenerDocumento() {
    }

    protected void agregarBeneficiario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
}
