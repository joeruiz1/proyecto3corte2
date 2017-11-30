/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Juan Manuel
 */
public class Factura {

    private String nombreCliente;
    private String nombreLi;
    private int idLi;
    private int numFac;
    private int precio;
    private int idEmple;
    private int idPago;
    private String formaPago;

    public Factura(String nombreCliente, String nombreLi, int idLi, int numFac, int precio, int idEmple, int idPago, String formaPago) {
        this.nombreCliente = nombreCliente;
        this.nombreLi = nombreLi;
        this.idLi = idLi;
        this.numFac = numFac;
        this.precio = precio;
        this.idEmple = idEmple;
        this.idPago = idPago;
        this.formaPago = formaPago;
    }

    public Factura() {
    }

    public int getIdEmple() {
        return idEmple;
    }

    public void setIdEmple(int idEmple) {
        this.idEmple = idEmple;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreLi() {
        return nombreLi;
    }

    public void setNombreLi(String nombreLi) {
        this.nombreLi = nombreLi;
    }

    public int getIdLi() {
        return idLi;
    }

    public void setIdLi(int idLi) {
        this.idLi = idLi;
    }

    public int getNumFac() {
        return numFac;
    }

    public void setNumFac(int numFac) {
        this.numFac = numFac;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

}
