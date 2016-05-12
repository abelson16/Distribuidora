/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.ClienteDAO;
import vista.Jf_Mant_Clientes;
import vista.Principal;

/**
 *
 * @author Abelson
 */
public class ControladorCliente {
    private Jf_Mant_Clientes vista;
    private ClienteDAO modelo;
    
    public ControladorCliente(Jf_Mant_Clientes view,ClienteDAO model){
        this.vista=view;
        this.modelo=model;
    }
    
    public void CargarClientes(Principal vistaPrincipal){
        vista.tbClientes.setModel(modelo.listarClientes());       
        this.vista.setClosable(true);
       this.vista.setMaximizable(true);
       this.vista.setResizable(true);
        vistaPrincipal.pnPrincipal.add(vista);
        vista.show();
    }
    public int nuevoCliente() {
        return this.modelo.ObtenerCorrelativo();
    }

    public void AgregarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
