/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.vo.Usuario;
import modelo.conexion.Conexion;
import modelo.vo.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abelson
 */
public class ClienteDAO{
    Conexion objConexion=new Conexion();
    
    public DefaultTableModel listarClientes(){
        Connection con=objConexion.conectar();
        String sql="Select * from listaClientes";
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
    
    public boolean InsertCliente(Cliente objCliente,Usuario objUser){
        String parametros="('"+objCliente.getTipodocumento()+"','"+
               objCliente.getNumeroDocumento()+"','"+
               objCliente.getNombreCompleto()+"','"+
               objCliente.getNombres()+"','"+
               objCliente.getApellidoPaterno()+"','"+
               objCliente.getApellidoMaterno()+"','"+
               objCliente.getDireccion()+"','"+
               objCliente.getTelefono()+"',"+
               objUser.getId()+");";
        try {
            Connection con=new Conexion().getConnection();
            System.out.println("SPInsert:  call InsertCliente"+parametros);
            CallableStatement cs = con.prepareCall("call InsertCliente"+parametros);
            cs.executeQuery();
            
            return true;           
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
    public DefaultTableModel buscarClientebyNombreCompleto(String nombrecompleto){
        Connection con=new Conexion().getConnection();
        String sql="Select * from listaClientes where Nombre like '"+nombrecompleto+"%'";
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
    
    public Cliente buscarClientebyId(int id) throws SQLException{
        Connection con=new Conexion().getConnection();
        String sql="select * from cliente where idcliente="+id;
        try{
        Statement stm= con.createStatement();
        ResultSet rs=stm.executeQuery(sql);
        rs.next();
        Cliente auxCliente=new Cliente();
        auxCliente.setIdcliente(Integer.parseInt(rs.getObject("idcliente").toString()));
        auxCliente.setTipodocumento(rs.getObject("TipoDocumento").toString());
        auxCliente.setNumeroDocumento(rs.getObject("NumeroDocumento").toString());
        auxCliente.setNombreCompleto(rs.getObject("NombreCompleto").toString());
        auxCliente.setNombres(rs.getObject("Nombres").toString());
        auxCliente.setApellidoPaterno(rs.getObject("ApellidoPaterno").toString());
        auxCliente.setApellidoMaterno(rs.getObject("ApellidoMaterno").toString());
        auxCliente.setDireccion(rs.getObject("Direccion").toString());
        auxCliente.setTelefono(rs.getObject("Telefono").toString());
        return auxCliente;       
        } catch (SQLException | NumberFormatException e) {
        return null;
        }
    }
    
    public boolean UpdateCliente(Cliente objCliente,Usuario objUser){
        String parametros="('"+objCliente.getTipodocumento()+"','"+
               objCliente.getNumeroDocumento()+"','"+
               objCliente.getNombreCompleto()+"','"+
               objCliente.getNombres()+"','"+
               objCliente.getApellidoPaterno()+"','"+
               objCliente.getApellidoMaterno()+"','"+
               objCliente.getDireccion()+"','"+
               objCliente.getTelefono()+"',"+
               objUser.getId()+");";
        try {
            Connection con=new Conexion().getConnection();
            System.out.println("SPInsert:  call InsertCliente"+parametros);
            CallableStatement cs = con.prepareCall("call InsertCliente"+parametros);
            cs.executeQuery();
            
            return true;           
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
}
