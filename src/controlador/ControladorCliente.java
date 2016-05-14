/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.table.TableModel;
import modelo.dao.ClienteDAO;
import modelo.vo.Cliente;
import modelo.vo.Usuario;
import vista.Jf_Mant_Clientes;
import vista.Principal;

/**
 *
 * @author Abelson
 */
public class ControladorCliente {
    private Jf_Mant_Clientes vista;
    private ClienteDAO modelo;
    private Usuario objUsuario;

    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }
    
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
    public void listarClientes(){
        vista.tbClientes.setModel(modelo.listarClientes());
    }

    public Boolean AgregarCliente(Cliente pCliente) {
        return this.modelo.InsertCliente(pCliente,this.objUsuario);
        
    }

    public Cliente BuscarClientePorId(int id) {
        return this.modelo.buscarClientebyId(id);
    }

    public boolean ActualiarCliente(Cliente auxcliente) {
        return this.modelo.UpdateCliente(auxcliente,this.objUsuario);
    }

    
}
