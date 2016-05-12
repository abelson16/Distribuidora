/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.dao.UsuarioDAO;
import modelo.vo.Usuario;
import vista.Login;
import vista.Principal;

/**
 *
 * @author Abelson
 */
public class ControladorLogin {
    private Login vista;
    private UsuarioDAO modelo;
    private Usuario usuario;
    
    public ControladorLogin(Login view,UsuarioDAO model){
        this.vista=view;
        this.modelo=model;
    }
    
    public void CargarLogin(){
       this.vista.show();    
   }
    
   public void ValidarLogin(Usuario objUusario){
       this.usuario=this.modelo.validarUsuario(objUusario);
       if (this.usuario!= null){
           vista.hide();
           LlamarPrincipal();
       }
       else{
           JOptionPane.showMessageDialog(vista,"Usuario o Contraseña incorrectos");
       }
   } 

    private void LlamarPrincipal() {
        Principal objvista =new Principal();
        ControladorPrincipal controlador=new ControladorPrincipal(objvista, this.usuario);
        objvista.setControler(controlador);
        controlador.cargarPrincipal();
       
    }
    
    
}
