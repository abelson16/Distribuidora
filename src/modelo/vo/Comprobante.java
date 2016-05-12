/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Abelson
 */
public class Comprobante {
    private int idcomprobante;
    private int idserie;
    private int idtipocomprobante;
    private Date fechaEmision;
    private String estado;
    private Double precio;
    private Double igv;
    private Double montoTotal;
    private Cliente objCliente=null;
    private Vendedor objVendedor=null;
    
    private ArrayList<ComprobanteDetalle> listaproductos;

    
    public Comprobante() {
        this.listaproductos=new ArrayList<ComprobanteDetalle>();
        
    }

    public int getIdcomprobante() {
        return idcomprobante;
    }

    public void setIdcomprobante(int idcomprobante) {
        this.idcomprobante = idcomprobante;
    }

    public int getIdserie() {
        return idserie;
    }

    public void setIdserie(int idserie) {
        this.idserie = idserie;
    }

    public int getIdtipocomprobante() {
        return idtipocomprobante;
    }

    public void setIdtipocomprobante(int idtipocomprobante) {
        this.idtipocomprobante = idtipocomprobante;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public Vendedor getObjVendedor() {
        return objVendedor;
    }

    public void setObjVendedor(Vendedor objVendedor) {
        this.objVendedor = objVendedor;
    }

    public ArrayList<ComprobanteDetalle> getListaproductos() {
        return listaproductos;
    }

    public void setListaproductos(ComprobanteDetalle listaproductos) {
        this.listaproductos.add(listaproductos);
    }

    public Object[][] listarDetalleComprobante(){
        
        Object[][] listDetalleCompro=new Object[listaproductos.size()][4];
        int index=0;
        for (ComprobanteDetalle comprobanteDetalle : listaproductos) {
            listDetalleCompro[index][0]=comprobanteDetalle.getObjProducto().ToString();
            listDetalleCompro[index][1]=comprobanteDetalle.getPrecio();
            listDetalleCompro[index][2]=comprobanteDetalle.getCantidad();
            listDetalleCompro[index][3]=comprobanteDetalle.getSubTotal();
            index++;
        }
        return listDetalleCompro;
    }
    
    public void calcularMontoTotal(){
        double auxmonto=0;
        if (listaproductos.size()>0){
        for (ComprobanteDetalle objDetalle : listaproductos) {
            auxmonto=auxmonto+objDetalle.getSubTotal();
        }
        
        this.montoTotal=FUNCIONES.REDONDEAR(auxmonto, 2);
        this.precio=FUNCIONES.REDONDEAR((montoTotal/1.18),2);
        this.igv=FUNCIONES.REDONDEAR(montoTotal-precio,2);
        
        
        }
    }
    
    
}
