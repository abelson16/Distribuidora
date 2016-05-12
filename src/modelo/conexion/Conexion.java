/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.conexion;

import java.sql.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Abelson
 */
public class Conexion {
    private Connection con=null;
    String url="jdbc:mysql://localhost/Distribuidora";
    String usuario="root";
    String password="root";
    
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,usuario,password);
            //System.out.println("Conexion a base de datos Distribuidor ... OK");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            //System.out.println("error de conexion"+ex.toString());
            return null;
        }
        
    }
    
    public void desconectar(){
        try {
            con.close();
            System.out.println("Desconectar conexion");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    /*    
    public Object[][] select (String tabla,String campos,String valores){
        int registros=0;
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
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
    
    
    public DefaultTableModel llamarVistaDB(String nombreVista){
        String sql="Select * from "+ nombreVista;
        DefaultTableModel modelo=new DefaultTableModel();
        try {
            Statement stm=con.createStatement();
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
    
    public int[] llamarCorrelativoComprobante(String procedimiento){
        int[] correlativo=new int[2];
        try {
            CallableStatement cs=con.prepareCall("call "+procedimiento);
            ResultSet rs=cs.executeQuery();
         while(rs.next()){
             correlativo[0]=rs.getInt(1);
             correlativo[1]=rs.getInt(2);
         }          
         return correlativo;   
        } catch (Exception e) {
        }
        return null;
        
    }
    
    
    public int llamarCorrelativoIngresoSalida(String procedimiento){
        int correlativo=0;
        try {
            CallableStatement cs=con.prepareCall("call "+procedimiento);
            ResultSet rs=cs.executeQuery();
         while(rs.next()){
             correlativo=rs.getInt(1);
         }          
         return correlativo;   
        } catch (Exception e) {
        }
        return 0;
        
    }
    
    
    
    public boolean ExecutarSPInsert(String procedimiento,String parametros){
        try {
            System.out.println("SPInsert:  call "+procedimiento+parametros);
            CallableStatement cs = con.prepareCall("call "+procedimiento+parametros);
            cs.executeQuery();
            
            return true;           
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public void IR_ImprimirFactura(int comprobante,int serie,int tipo){
       LlamarReporte reporte=new LlamarReporte();
       reporte.imprimirComprobante(comprobante, serie, tipo,con);
   }
    
  */  
    
}
