/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;
import modelo.vo.Usuario;
import modelo.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import modelo.vo.Proveedor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Abelson
 */
public class ProveedorDAO{
    
    public ProveedorDAO(){
        
    }
    
    public DefaultTableModel llamarVistaProveedores(){
        Connection con=new Conexion().conectar();
        String sql="Select * from listaproveedores; ";
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            Statement stm= con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            
            ResultSetMetaData md=rs.getMetaData();
            int columnas=md.getColumnCount();
            //llenar las columnas de la tabla
            for(int i =1;i<=columnas;i++){
                modelo.addColumn(md.getColumnName(i));
            }
            
            while(rs.next()){
                Object[] fila=new Object[columnas];
                for(int i =0;i<columnas;i++){
                    fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            
            return modelo;       
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean InsertProveedor(Proveedor objProveedor,Usuario objUser){
        String parametros="('"+objProveedor.getRuc()+"','"+
               objProveedor.getRazonSocial()+"','"+
               objProveedor.getDireccion()+"','"+
               objProveedor.getTelefono()+"','"+
               objProveedor.getCelular1()+"','"+
               objProveedor.getCelular2()+"',"+
               objUser.getId()+");";
        try {
            Connection con=new Conexion().conectar();
            System.out.println("SPInsert:  call InsertCliente"+parametros);
            CallableStatement cs = con.prepareCall("call InsertProveedor"+parametros);
            cs.executeQuery();
            
            return true;           
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        } 
    }
    /*
    public Proveedor buscarProveedorbyId(int id){
        Connection con=new Conexion().conectar();
        String sql="select * from proveedore where idproveedor="+id;
        try{
        Statement stm= con.createStatement();
        ResultSet rs=stm.executeQuery(sql);
        rs.next();
        Proveedor auxProveedor=new Proveedor();
        auxProveedor.setIdProveedor(Integer.parseInt(rs.getObject("idProveedor").toString()));
        auxProveedor.set(rs.getObject("TipoDocumento").toString());
        auxProveedor.setNumeroDocumento(rs.getObject("NumeroDocumento").toString());
        auxProveedor.setNombreCompleto(rs.getObject("NombreCompleto").toString());
        auxProveedor.setNombres(rs.getObject("Nombres").toString());
        auxCliente.setApellidoPaterno(rs.getObject("ApellidoPaterno").toString());
        auxCliente.setApellidoMaterno(rs.getObject("ApellidoMaterno").toString());
        auxCliente.setDireccion(rs.getObject("Direccion").toString());
        auxCliente.setTelefono(rs.getObject("Telefono").toString());
        return auxCliente;       
        } catch (Exception e) {
        return null;
        }
    }
    */
    
}
