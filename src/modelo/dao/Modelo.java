/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.ParseConversionEvent;
import modelo.vo.Cliente;
import modelo.vo.Comprobante;
import modelo.vo.ComprobanteDetalle;
import modelo.vo.Entrada;
import modelo.vo.ItemComboBox;
import modelo.vo.KardexEntrada;
import modelo.vo.Marca;
import modelo.vo.Precio;
import modelo.vo.Producto;
import modelo.vo.Proveedor;
import modelo.vo.Usuario;
import modelo.vo.VariablesGlobales;
/**
 *
 * @author Abelson
 */
public class Modelo{
    //modelo
    public Usuario user;
    public VariablesGlobales variablesGlobales=new VariablesGlobales();
    public Comprobante objComprobante;
    public Cliente objCliente;
    public Marca objMarca;
    public Producto objProducto;
    public Entrada objEntrada;
    public Proveedor objProveedor;
    
    //datos
    public UsuarioDAO DAOUsuario=new UsuarioDAO();
    public ClienteDAO DAOCliente=new ClienteDAO();
    public ProveedorDAO DAOProveedor=new ProveedorDAO();

 /* 
    public boolean ValidarUsuario(String usuario,String password){
        this.user=DAOUsuario.validarUsuario(usuario, password);
        if (user == null){
            return false;
        }
        else{
            return true;
        }
            
    }

    public void llenarVariablesGlobales(){
        Object[][] res =this.select("variablesglobales", " variable , tipodato , valor ", null);
        if(res.length>0){
            variablesGlobales.setEmpresa(res[0][2].toString());
            variablesGlobales.setDireccion(res[1][2].toString());
            variablesGlobales.setCiudad(res[2][2].toString());
            variablesGlobales.setRuc(res[3][2].toString());
            variablesGlobales.setFecha( new Date(res[4][2].toString()));
            variablesGlobales.setIgv(Double.valueOf(res[5][2].toString()));
        }
    }
    */
    //Formulario Cliente

    public DefaultTableModel buscarCliente(String nombre){
        return this.DAOCliente.buscarClientebyNombreCompleto(nombre);       
    }
    

    
    public boolean registrarCliente(Cliente objCliente ){
       if (objCliente!= null){
           return DAOCliente.InsertCliente(objCliente, user);
       }
       else{
           return false;
       }
   }
    
    //Formulario Proveedor
    public  DefaultTableModel llamarProveedores(){
        return DAOProveedor.llamarVistaProveedores();
    }
    
    public  boolean registrarProveedor(Proveedor objProveedor){
        if(objProveedor!=null){
            return DAOProveedor.InsertProveedor(objProveedor, user);
        }
        else
        {
            return false;
        }
    }
    /*
    public Proveedor buscarProveedorId(int id) {
        this.objProveedor=this.DAOProveedor.buscarProveedorbyId(id);
        if(this.objProveedor == null){
            return null;
        }else{
            return this.objProveedor;
        }   
    }
    
    
    
    
    
    
    
    
    
    
    
    public ArrayList<ItemComboBox> itemCombobox(String tabla,String columnas){
         Object[][] data=this.select(tabla, columnas,null);
         ArrayList<ItemComboBox> lista=new ArrayList<ItemComboBox>();
         ItemComboBox item;
        if(data.length>0){
            
            for (int i = 0; i <data.length; i++) {
               item =new ItemComboBox((String) data[i][0],(String) data[i][1]);
                lista.add(item);
            }
           return lista;            
        }
        else {
            return null;
        }
    }
    
    public void NuevoCombronate(){
        objComprobante=new Comprobante();
    }
    
    public Object[][] GetClientes(){
        Object[][] res = this.select("Cliente", "idCliente , TipoDocumento , NumeroDocumento , NombreCompleto, Direccion", null);
        if( res.length > 0) {
            return res;
        }
        else {
            return null;
        }
    }
    
   public int[] DatosComprobante(int tipocomprobante){
     int[] resultado=this.llamarCorrelativoComprobante("correlativoCodigoComprobante("+tipocomprobante+")");
     if(resultado.length>0) {
           return resultado;
       }
     else {
           return null;
       }     
   }
   
   public int IdIngresoSalida(String procedimiento){
     int resultado=this.llamarCorrelativoIngresoSalida(procedimiento);
     if(resultado>0) {
           return resultado;
       }
     else {
           return 0;
       }     
   }
   

   public boolean Registrarcomprobante(){
       DateFormat fecha= new SimpleDateFormat("dd/MM/yy");
       String parametros="("+ objComprobante.getIdtipocomprobante() +","+
       objComprobante.getIdserie()+","+
      objComprobante.getIdcomprobante()+",'"+
       fecha.format(objComprobante.getFechaEmision())+"','"+
       objComprobante.getEstado()+"',"+
       objComprobante.getPrecio()+","+
       objComprobante.getIgv()+","+
       objComprobante.getMontoTotal()+","+
       objComprobante.getObjCliente().getIdcliente()+","+
       objComprobante.getObjVendedor().getIdvendedor()+","+
       user.getId()+");";
       
       System.out.println(parametros);
       
       boolean resulatado=ExecutarSPInsert("InsertComprobante", parametros);
       
       if(resulatado) {
           for ( ComprobanteDetalle objCompDetalle : objComprobante.getListaproductos()) {
               parametros="("+ objComprobante.getIdcomprobante()+","+
               objComprobante.getIdserie()+","+
               objComprobante.getIdtipocomprobante()+",'"+
               objCompDetalle.getObjProducto().getCodigoproducto()+"',"+
               objCompDetalle.getPrecio()+","+
               objCompDetalle.getCantidad()+","+
               objCompDetalle.getSubTotal()+","+
               user.getId()+");";
               resulatado=ExecutarSPInsert("InsertComprobanteDetalle", parametros);
           }
       return true;            
       }
       
       else {
           return false;
       }
   } 
   
   
   
   public  boolean  registrarMarca(){
       String parametros="('"+objMarca.getNombre()+"','"+
               objMarca.getTipoProducto()+"');";
       if(objMarca!=null){
           return ExecutarSPInsert("InsertMarca", parametros);
       }
       else{
           return false;
       }
   }
   public boolean registrarProducto(){
       String parametros="('"+objProducto.getCodigoproducto()+"','"
               + objProducto.getNombre()+"','"
               + objProducto.getPresentacion()+"','"
               + objProducto.getDescripcion()+"','"
               + objProducto.getEnvase()+"','"
               + objProducto.getUnidadmedida()+"',"
               + objProducto.getMedida()+","
               + objProducto.getObjMarca().getIdMarca()+"," 
               + objProducto.getObjCategoria().getIdCategoria()+","
               + objProducto.getObjNivel().getIdNivel()+","
               + objProducto.getObjProveedor().getIdProveedor()+ ","
               + user.getId()+");";
       if(objProducto!=null){
           if( ExecutarSPInsert("InsertProducto", parametros)){
               //ingresar el precio del producto
               for(Precio objPrecio : objProducto.getListaPrecios()){
                   parametros="('"+objProducto.getCodigoproducto()+"','"
                           + objPrecio.getTipoCompra()+"',"
                           + objPrecio.getCantidad()+",'"
                           + objPrecio.getMoneda()+"',"
                           + objPrecio.getPrecio()+","
                           + user.getId()+");";
                   ExecutarSPInsert("InsertProductoPrecio", parametros); 
               }
               return true;
           }
           else{
              return false; 
           }
           
       }
       else{
           return false;
       }
   }
   
   public boolean registrarEntrada(){
       String parametros="("+objEntrada.getIdEntrada()+",'"
               + objEntrada.getTipoEntrada()+"',"
               + objEntrada.getTipoComprobante()+","
               + objEntrada.getSerieComprobante()+","
               + objEntrada.getCodigoComprobante()+",'"
               + objEntrada.getEstado()+"',"
               + objEntrada.getObjProveedor().getIdProveedor()+","
               +user.getId()+");";
       if(objEntrada!=null){
           if( ExecutarSPInsert("InsertEntrada", parametros)){
               //ingresar el kardex entrada
               //traer el codigo de la entrada
               for(KardexEntrada objKardexEntrada : objEntrada.getListaKardex()){
                   parametros="("+objEntrada.getIdEntrada()+",'"
                           + objKardexEntrada.getObjProducto().getCodigoproducto()+"',"
                           + objKardexEntrada.getCantidad()+",'"
                           + objKardexEntrada.getEstado()+"',"
                           + user.getId()+");";
                   ExecutarSPInsert("InsertKardexEntrada", parametros); 
               }
               return true;
           }
           else{
              return false; 
           }
           
       }
       else{
           return false;
       }
   }
   
   
   
   
   public void Rep_ImprimirFactura(int comprobante,int serie,int tipo){
       this.IR_ImprimirFactura(comprobante, serie, tipo);
   }
 */   
}
