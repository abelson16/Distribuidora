/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.ClienteDAO;
import modelo.vo.Usuario;
import vista.Jf_Mant_Clientes;
import vista.Principal;

/**
 *
 * @author Abelson
 */
public class ControladorPrincipal {
    Principal vista;
    Usuario objUsario;
    
    public ControladorPrincipal(Principal view,Usuario pUsuario){
        this.vista=view;
        this.objUsario=pUsuario;
    }
    
    public void cargarPrincipal(){
        this.vista.setTitle("Distribuidora : "+this.objUsario.getCuenta());
        this.vista.show();
    }
    
    public void LlamarMantenimientoClientes(){
        Jf_Mant_Clientes objvista=new Jf_Mant_Clientes();
        ClienteDAO objmodelo=new ClienteDAO();
        ControladorCliente controlador=new ControladorCliente(objvista, objmodelo);
        objvista.setControler(controlador);
        controlador.CargarClientes(vista);
        
    }
    
}
