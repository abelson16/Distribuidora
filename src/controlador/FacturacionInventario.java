/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import modelo.dao.Modelo;
import modelo.dao.UsuarioDAO;
import vista.*;
/**
 *
 * @author Abelson
 */
public class FacturacionInventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Login vista=new Login();
        UsuarioDAO modelo=new UsuarioDAO();
       
       ControladorLogin controler=new ControladorLogin(vista,modelo);
       vista.setControler(controler);
       controler.CargarLogin(); 
        
    }

    
    
    
}
