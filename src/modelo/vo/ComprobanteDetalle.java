/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

/**
 *
 * @author Abelson
 */
public class ComprobanteDetalle implements MostrarEnTabla{
 private Producto objProducto;
 private double precio;
 private int cantidad;
 private double subTotal;
 
 public ComprobanteDetalle(){
     
 }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    

    public Object[] listarVector(){
        Object[] vectorObjetos=new Object[4];
        vectorObjetos[0]=objProducto.ToString();
        vectorObjetos[1]=precio;
        vectorObjetos[2]=cantidad;
        vectorObjetos[3]=subTotal;        
        return vectorObjetos;
    }

    public void calcularSubTotal() {
        subTotal=FUNCIONES.REDONDEAR(this.precio*this.cantidad,2);
    }
 
    
}
