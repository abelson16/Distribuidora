/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.conexion.Conexion;
import modelo.vo.Usuario;

/**
 *
 * @author Abelson
 */
public class UsuarioDAO{
    private Conexion con=new Conexion();
    
    public Usuario validarUsuario(Usuario objUsuario) {
        String query= "call sp_usuario_validarLogin('"+objUsuario.getCuenta()+"','"+objUsuario.getPassword()+"');";
        try {
            Connection conn=con.conectar();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet res =pstm.executeQuery();
            if (res.next()){
                objUsuario.setId(Integer.parseInt(res.getObject("idUsuario").toString()));
                objUsuario.setNombre(res.getObject("Nombres").toString());
                objUsuario.setApellidoPaterno(res.getObject("ApellidoPaterno").toString());
                objUsuario.setApellidoMaterno(res.getObject("ApellidoMaterno").toString());
            }
            else{
            objUsuario= null;
            }
            res.close();
            con.desconectar();
            return objUsuario;
        }catch(SQLException | NumberFormatException ex){
            return null;
        }
    }
    
    
    
    
    public Object[][] select (String tabla,String campos,String valores){
        int registros=0;
        Conexion conectar=new Conexion();
        Connection con=conectar.conectar();
        String colname[]=campos.split(",");
        //consulta
        String q="Select "+campos+" from " + tabla;
        String q2="Select count(*) as total from "+tabla;
        if(valores != null){
            q+= " Where " + valores;
            q2+= " where " + valores;
        }
        
        try {
            PreparedStatement pstm = con.prepareStatement(q2);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros=res.getInt("total");
            res.close();        
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(q2);
        System.out.println(q);
        ///se crea la matriz con los datos solicitados
        Object[][] data = new String[registros][campos.split(",").length];
        try {
            PreparedStatement pstm = con.prepareStatement(q);
            ResultSet res =pstm.executeQuery();
            int i=0;
            while(res.next()){
                for (int j = 0; j <= campos.split(",").length-1; j++) {
                    data[i][j]=res.getString(colname[j].trim());
                }
                i++;
            }
            res.close();
            conectar.desconectar();            
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
    
    
    
    
    
}
