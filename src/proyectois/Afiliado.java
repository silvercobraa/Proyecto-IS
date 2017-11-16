/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

import java.util.ArrayList;

public class Afiliado {

    private String nombre;
    private String correo;
    private String cuentaBancaria;
    private String rut;
    private String direccion;
    private String contraseña;
    private int cantidadHorasTrabajadas;
    private int aporteRenta;
    private ArrayList montoHistorico;

    public Afiliado() {

    }

    public void calcularAporteRenta() {

    }

    public void consultarMontoHistorico() {

    }

    public void descargarDocumento() {

    }

    public void solicitarBeneficio() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getCantidadHorasTrabajadas() {
        return cantidadHorasTrabajadas;
    }

    public void setCantidadHorasTrabajadas(int cantidadHorasTrabajadas) {
        this.cantidadHorasTrabajadas = cantidadHorasTrabajadas;
    }

    public int getAporteRenta() {
        return aporteRenta;
    }

    public void setAporteRenta(int aporteRenta) {
        this.aporteRenta = aporteRenta;
    }

    public ArrayList getMontoHistorico() {
        return montoHistorico;
    }

    public void setMontoHistorico(ArrayList montoHistorico) {
        this.montoHistorico = montoHistorico;
    }
}
