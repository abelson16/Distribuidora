/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

/**
 *
 * @author Abelson
 */
public class KardexEntrada {
    private int idKardexEntrada;
    private Producto objProducto;
    private int cantidad;
    private String estado;

    public KardexEntrada() {
    }

    public int getIdKardexEntrada() {
        return idKardexEntrada;
    }

    public void setIdKardexEntrada(int idKardexEntrada) {
        this.idKardexEntrada = idKardexEntrada;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
