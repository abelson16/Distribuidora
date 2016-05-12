/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.util.ArrayList;

/**
 *
 * @author Abelson
 */
public class Producto {
    private String codigoproducto;
    private String nombre;
    private String presentacion;
    private String descripcion;
    private String envase;
    private String unidadmedida;
    private double medida;
    private Marca objMarca;
    private Categoria objCategoria;
    private Nivel objNivel;
    private Proveedor objProveedor;
    private ArrayList<Precio> listaPrecios;
      
    public  Producto(){
        this.listaPrecios=new ArrayList<Precio>();
    }   

    public ArrayList<Precio> getListaPrecios() {
        return listaPrecios;
    }

    public void setListaPrecios(Precio objPrecio) {
        this.listaPrecios.add(objPrecio);
    }

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnvase() {
        return envase;
    }

    public void setEnvase(String envase) {
        this.envase = envase;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public Marca getObjMarca() {
        return objMarca;
    }

    public void setObjMarca(Marca objMarca) {
        this.objMarca = objMarca;
    }

    public Categoria getObjCategoria() {
        return objCategoria;
    }

    public void setObjCategoria(Categoria objCategoria) {
        this.objCategoria = objCategoria;
    }

    public Nivel getObjNivel() {
        return objNivel;
    }

    public void setObjNivel(Nivel objNivel) {
        this.objNivel = objNivel;
    }

    public Proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(Proveedor objProveedor) {
        this.objProveedor = objProveedor;
    }

    
    /**
     *
     * @return
     */
    public String ToString(){
        return codigoproducto+' '+nombre+' '+presentacion+' '+envase+' '+medida+' '+unidadmedida;
    }
    
            
    
    
    
}
