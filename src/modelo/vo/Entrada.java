/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.util.ArrayList;

/**
 *
 * @author Abelson
 */
public class Entrada {
    private int idEntrada;
    private String TipoEntrada;
    private int TipoComprobante;
    private int SerieComprobante;
    private int CodigoComprobante;
    private String Estado;
    private Proveedor objProveedor;
    private ArrayList<KardexEntrada> listaKardex;

    public Entrada() {
        this.listaKardex=new ArrayList<KardexEntrada>();
    }

    public ArrayList<KardexEntrada> getListaKardex() {
        return listaKardex;
    }

    public void setListaKardex(KardexEntrada objKardexEntrada) {
        this.listaKardex.add(objKardexEntrada);
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getTipoEntrada() {
        return TipoEntrada;
    }

    public void setTipoEntrada(String TipoEntrada) {
        this.TipoEntrada = TipoEntrada;
    }

    public int getTipoComprobante() {
        return TipoComprobante;
    }

    public void setTipoComprobante(int TipoComprobante) {
        this.TipoComprobante = TipoComprobante;
    }

    public int getSerieComprobante() {
        return SerieComprobante;
    }

    public void setSerieComprobante(int SerieComprobante) {
        this.SerieComprobante = SerieComprobante;
    }

    public int getCodigoComprobante() {
        return CodigoComprobante;
    }

    public void setCodigoComprobante(int CodigoComprobante) {
        this.CodigoComprobante = CodigoComprobante;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(Proveedor objProveedor) {
        this.objProveedor = objProveedor;
    }
    
    public Object[][] listarKardexEntrada(){
        
        Object[][] listKardexEntrada=new Object[listaKardex.size()][2];
        int index=0;
        for (KardexEntrada entradaKardex : listaKardex) {
            listKardexEntrada[index][0]=entradaKardex.getObjProducto().getNombre();
            listKardexEntrada[index][1]=entradaKardex.getCantidad();
            index++;
        }
        return listKardexEntrada;
    }
    
}
