/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import modelo.dao.Modelo;
import modelo.vo.ComprobanteDetalle;
import modelo.vo.Entrada;
import modelo.vo.Producto;
import modelo.vo.Precio;
import modelo.vo.Marca;
import modelo.vo.Nivel;
import modelo.vo.Categoria;
import modelo.vo.Cliente;
import modelo.vo.Proveedor;
import modelo.vo.Vendedor;
import modelo.vo.ItemComboBox;
import modelo.vo.KardexEntrada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.*;


/**
 *
 * @author Abelson
 */
public class Controlador {
    Login view;
    Modelo model;
    
    Principal vtnPrincipal;
    Jf_Mant_Clientes vtnMantenimientoCliente;
    Jf_Mant_Marca vtnMantenimientoMarca;
    Jf_Mant_Productos vtnMantenimientoProducto;
    Jf_Mant_Proveedor vtnMantenimientoProveedor;
    Facturacion vtnFacturacion;
    MostrarClientes vtnMostrarClientes;
    MostrarProductos vtnMostrarProductos;
    Jf_Sist_Ingreso vtnRegistrarIngreso;
    
    
    
   public Controlador(Login ventana,Modelo modelo){
       this.view=ventana;
       this.model=modelo;   
   }
/*
   //--- //Login[FLOG]
   void CargarLogin(){
       this.view.show();    
   }
   public void ValidarLogin(String usuario,String password){
       if (this.model.ValidarUsuario(usuario,password)){
           view.hide();
           CargarPrincipal();
       }
       else{
           JOptionPane.showMessageDialog(view,"Usuario o Contraseña incorrectos");
       }
   }
  
   private  void CargarPrincipal(){
       this.vtnPrincipal=new Principal();
       this.vtnPrincipal.setTitle("Distribuidora : "+this.model.user.getCuenta());
       this.vtnPrincipal.setControler(this);
       this.vtnPrincipal.show();
   }
   */
   //--- //Principal[FPri]
   //Menu Mantenimiento 
   /*
   public void LlamarMantenimientoCliente(){
       this.vtnMantenimientoCliente=new Jf_Mant_Clientes();
       this.vtnMantenimientoCliente.setControler(this);
       this.vtnMantenimientoCliente.tbClientes.setModel(this.model.llamarClientes());
       this.vtnMantenimientoCliente.setClosable(true);
       this.vtnMantenimientoCliente.setMaximizable(true);
       this.vtnMantenimientoCliente.setResizable(true);
       
       this.vtnPrincipal.pnPrincipal.add(this.vtnMantenimientoCliente);
       this.vtnMantenimientoCliente.show();
   }
   */
   public  void  LlamarMantenimientoProveedor(){
       this.vtnMantenimientoProveedor=new Jf_Mant_Proveedor();
       this.vtnMantenimientoProveedor.setControler(this);
       this.vtnMantenimientoProveedor.tbProveedores.setModel(this.model.llamarProveedores());
       this.vtnMantenimientoProveedor.setClosable(true);
       this.vtnMantenimientoProveedor.setMaximizable(true);
       this.vtnMantenimientoProveedor.setResizable(true);
       this.vtnPrincipal.pnPrincipal.add(this.vtnMantenimientoProveedor);
       this.vtnMantenimientoProveedor.show();
       
   }
   
      
   //--- //Cliente[FCli]
   public void BuscarCliente(String nombre){
       this.vtnMantenimientoCliente.tbClientes.setModel(this.model.buscarCliente(nombre));
   }
   
   
   
   //--- //Proveedor[FPRO]
   public void AgregarProveedor(){
       Proveedor auxProveedor=new Proveedor();
       auxProveedor.setRuc((String) this.vtnMantenimientoProveedor.tfRuc.getText());
       auxProveedor.setRazonSocial(this.vtnMantenimientoProveedor.tfRazonSocial.getText());
       auxProveedor.setDireccion(this.vtnMantenimientoProveedor.tfDireccion.getText());
       auxProveedor.setTelefono(this.vtnMantenimientoProveedor.tfTelefono.getText());
       auxProveedor.setCelular1(this.vtnMantenimientoProveedor.tfCelular.getText());
       if(this.model.registrarProveedor(auxProveedor)){
           JOptionPane.showMessageDialog(vtnMantenimientoProveedor,"Se ingreso correctamente el Proveedor");
           vtnMantenimientoProveedor.tbProveedores.setModel(this.model.llamarProveedores());
       }else{
           JOptionPane.showMessageDialog(vtnMantenimientoProveedor, "Error al ingresar el Proveedor","Ingreso de Proveedores", JOptionPane.ERROR_MESSAGE);
       }
   }
   /*
   public void BuscarProveedorPorId(int id){
       Proveedor auxProveedor=this.model.buscarProveedorId(id);
       this.vtnMantenimientoProveedor.show();
       
   }
   
   
   
    
   
   ///Listener de la vista
    @Override
    public void actionPerformed(ActionEvent e) {
       String opcion=e.getActionCommand();
       
       
      if (opcion.equals("Salir")){
           cerrar(this.vtnFacturacion);
       }
       
       
       //--MenuComprobante
       else if (opcion.equals("ComprobanteFactura")){
           abrirFacturacion(1);
       }
       else if (opcion.equals("ComprobanteBoleta")){
           abrirFacturacion(3);
       }
       ///MantenimientoProducto--jf_Productos
       else if (opcion.equals("MantenimientoProducto")){
           abrirMantenimientoProducto();
       }
       else if (opcion.equals("InsertProducto")){
           Producto auxProducto=new Producto();
           auxProducto.setCodigoproducto(this.vtnMantenimientoProducto.tfCodigoProducto.getText());
           auxProducto.setNombre(this.vtnMantenimientoProducto.tfNombre.getText());
           auxProducto.setDescripcion(this.vtnMantenimientoProducto.tfDescripcion.getText());
           auxProducto.setPresentacion(this.vtnMantenimientoProducto.tfPresentacion.getText());
           auxProducto.setEnvase(this.vtnMantenimientoProducto.tfEnvase.getText());
           auxProducto.setUnidadmedida(this.vtnMantenimientoProducto.tfUnidadMedida.getText());
           auxProducto.setMedida(Double.valueOf(this.vtnMantenimientoProducto.tfMedida.getText()));
           
           ItemComboBox auxItemCombo;
           
           auxItemCombo=(ItemComboBox) this.vtnMantenimientoProducto.cbMarca.getSelectedItem();
           //agregando la marca
           Marca auxMarca=new Marca();
           auxMarca.setIdMarca(Integer.parseInt(auxItemCombo.getCodigo()));
           auxMarca.setNombre(auxItemCombo.getNombre());
           auxProducto.setObjMarca(auxMarca);
           //agregando la categoria
           auxItemCombo=(ItemComboBox) this.vtnMantenimientoProducto.cbCategoria.getSelectedItem();
           Categoria auxCategoria=new Categoria();
           auxCategoria.setIdCategoria(Integer.parseInt(auxItemCombo.getCodigo()));
           auxCategoria.setNombre(auxItemCombo.getNombre());
           auxProducto.setObjCategoria(auxCategoria);
           //agregando el nivel
           auxItemCombo=(ItemComboBox) this.vtnMantenimientoProducto.cbNivel.getSelectedItem();
           Nivel auxNivel=new Nivel();
           auxNivel.setIdNivel(Integer.parseInt(auxItemCombo.getCodigo()));
           auxNivel.setNombre(auxItemCombo.getNombre());
           auxProducto.setObjNivel(auxNivel);
           //agregar el proveedor
           auxItemCombo=(ItemComboBox) this.vtnMantenimientoProducto.cbProveedor.getSelectedItem();
           Proveedor auxProveedor=new Proveedor();
           auxProveedor.setIdProveedor(Integer.parseInt(auxItemCombo.getCodigo()));
           auxProveedor.setNombre(auxItemCombo.getNombre());
           auxProducto.setObjProveedor(auxProveedor);
           this.model.objProducto=auxProducto;
           //ingrear el precio con comprobante
           Precio auxPrecio =new Precio();
           auxPrecio.setTipoCompra("CCM");
           auxPrecio.setMoneda("S");
           auxPrecio.setPrecio(Double.parseDouble(this.vtnMantenimientoProducto.tfPrecioComprobante.getText()));
           this.model.objProducto.setListaPrecios(auxPrecio);
           //ingrear el precio sin comprobante
           auxPrecio=new Precio();
           auxPrecio.setTipoCompra("SCM");
           auxPrecio.setMoneda("S");
           auxPrecio.setPrecio(Double.parseDouble(this.vtnMantenimientoProducto.tfPrecioSinComprobante.getText()));
           this.model.objProducto.setListaPrecios(auxPrecio);
          this.model.registrarProducto();
           vtnMantenimientoProducto.tbProductos.setModel(this.model.llamarVistaDB("listamantproducto"));           
       }
       
       
       ///MantenimientoMarca--jf_Marca
       else if (opcion.equals("MantenimientoMarca")){
           abrirMantenimientoMarca();
       }
       else if (opcion.equals("InsertMarca")){
           Marca auxMarca=new Marca();
           auxMarca.setNombre(this.vtnMantenimientoMarca.tfNombre.getText());
           auxMarca.setTipoProducto(this.vtnMantenimientoMarca.tfTipoProducto.getText());
           model.objMarca=auxMarca;
           this.model.registrarMarca();
           vtnMantenimientoMarca.tbMarcas.setModel(this.model.llamarVistaDB("listaMarcas"));
       }
       ///MantenimientoProveedor--jf_Proveedor
       else if (opcion.equals("MantenimientoProveedor")){
           abrirMantenimientoProveedor();
       }
       
       
       //Almacen
       //Entrada[FENT]
       else if (opcion.equals("RegistrarEntrada")){
         abrirRegistrarEntrada();  
       }
       //agregar productos a la tabla de ingresos
       else if (opcion.equals("AgregarProducto")){
        KardexEntrada auxKardexEntrada =new KardexEntrada();
        
        ItemComboBox auxItemCombo;
           auxItemCombo=(ItemComboBox) this.vtnRegistrarIngreso.cbProductos.getSelectedItem();
          
        Producto auxproducto=new Producto();
          auxproducto.setCodigoproducto(auxItemCombo.getCodigo());
          auxproducto.setNombre(auxItemCombo.getNombre());

          auxKardexEntrada.setObjProducto(auxproducto);
          auxKardexEntrada.setCantidad(Integer.parseInt(vtnRegistrarIngreso.tfCantidad.getText()));
          auxKardexEntrada.setEstado("ACTIVO");
          model.objEntrada.setListaKardex(auxKardexEntrada);
          vtnRegistrarIngreso.tbKardexEntrada.setModel(mostrarEnTablaLista((DefaultTableModel) limpiarTabla((DefaultTableModel)vtnRegistrarIngreso.tbKardexEntrada.getModel()),model.objEntrada.listarKardexEntrada()));
       }
       //registrar el ingreso al almacen
       else if (opcion.equals("RegistrarIngreso")){
           this.model.objEntrada.setIdEntrada(Integer.parseInt(vtnRegistrarIngreso.lbIngresoId.getText()));
           this.model.objEntrada.setTipoEntrada(vtnRegistrarIngreso.cbTipoIngreso.getSelectedItem().toString());
           if(vtnRegistrarIngreso.cbTipoComprobante.getSelectedItem().toString().equals("Factura")){
               this.model.objEntrada.setTipoComprobante(1);
           }
           else{
                this.model.objEntrada.setTipoComprobante(3);
           }
           this.model.objEntrada.setSerieComprobante(Integer.parseInt(vtnRegistrarIngreso.tfSerieComprobante.getText()));
           this.model.objEntrada.setCodigoComprobante(Integer.parseInt(vtnRegistrarIngreso.tfSerieComprobante.getText()));
          
           ItemComboBox auxItemCombo;
           auxItemCombo=(ItemComboBox) this.vtnRegistrarIngreso.cbProveedor.getSelectedItem();
           
           Proveedor auxproveedor=new Proveedor();
           auxproveedor.setIdProveedor(Integer.parseInt(auxItemCombo.getCodigo()));
           auxproveedor.setNombre(auxItemCombo.getNombre());
           this.model.objEntrada.setObjProveedor(auxproveedor);
           this.model.registrarEntrada();
       }
   
       //Facturacion[FFAC]
       //--Seleccionar un vendedor
       else if (opcion.equals("SeleccionVendedor")){
           ItemComboBox objSeleccionado=(ItemComboBox) vtnFacturacion.cbVendedores.getSelectedItem();
           Vendedor auxVendedor=new Vendedor();
           auxVendedor.setIdvendedor(Integer.parseInt(objSeleccionado.getCodigo()));
           auxVendedor.setNombrecompleto(objSeleccionado.getNombre());
           model.objComprobante.setObjVendedor(auxVendedor);
       }

       //--Buscar Producto
       else if (opcion.equals("BuscarProducto")){
           abrirMostrarProductos();
       }
       //imprimir
       else if(opcion.equals("ImprimirComprobante")){
           this.model.Rep_ImprimirFactura(7, 1, 3);
       }
       //Grabar Comprobante
       else if(opcion.equals("GrabarComprobante")){
           if(this.model.Registrarcomprobante()){
               JOptionPane.showMessageDialog(null,"Se registro el comprobante correctamente", "Comprobante Ingresado",JOptionPane.INFORMATION_MESSAGE);
           }
           else{
               JOptionPane.showMessageDialog(null,"No se registro el comprobante correctamente", "ERROR AL REGISTRAR",JOptionPane.ERROR_MESSAGE);
           }
       }
       //BuscarCliente[FBUS]
       else if (opcion.equals("AgregarCliente")){
           /*Cliente auxcliente=new Cliente(Integer.valueOf((String) vtnMostrarClientes.tbClientes.getValueAt(vtnMostrarClientes.tbClientes.getSelectedRow(), 0)),
                   String.valueOf(vtnMostrarClientes.tbClientes.getValueAt(vtnMostrarClientes.tbClientes.getSelectedRow(), 3)),
                   String.valueOf( vtnMostrarClientes.tbClientes.getValueAt(vtnMostrarClientes.tbClientes.getSelectedRow(), 2)),
                   String.valueOf(vtnMostrarClientes.tbClientes.getValueAt(vtnMostrarClientes.tbClientes.getSelectedRow(), 4)));
           this.model.objComprobante.setObjCliente(auxcliente);
           vtnMostrarClientes.dispose();
           
           vtnFacturacion.tfNumeroDocumento.setText(model.objComprobante.getObjCliente().getNumeroDocumento());
           vtnFacturacion.tfNombreCliente.setText(model.objComprobante.getObjCliente().getNombres());
           vtnFacturacion.tfDireccionCliente.setText(model.objComprobante.getObjCliente().getDireccion());
       }
       //BuscarProducto[FBPT]
       else if (opcion.equals("AgregarProducto")){
           
           ComprobanteDetalle auxComprobantedetalle =new ComprobanteDetalle();
                      
          Producto auxproducto=new Producto();
          auxproducto.setCodigoproducto(String.valueOf(vtnMostrarProductos.tbProductos.getValueAt(vtnMostrarProductos.tbProductos.getSelectedRow(),0)));
          auxproducto.setNombre(String.valueOf(vtnMostrarProductos.tbProductos.getValueAt(vtnMostrarProductos.tbProductos.getSelectedRow(),1)));
          auxproducto.setPresentacion(String.valueOf(vtnMostrarProductos.tbProductos.getValueAt(vtnMostrarProductos.tbProductos.getSelectedRow(),2)));
          auxproducto.setEnvase(String.valueOf(vtnMostrarProductos.tbProductos.getValueAt(vtnMostrarProductos.tbProductos.getSelectedRow(),3)));
          auxproducto.setMedida(Double.valueOf(String.valueOf(vtnMostrarProductos.tbProductos.getValueAt(vtnMostrarProductos.tbProductos.getSelectedRow(),4))));
          auxproducto.setUnidadmedida(String.valueOf(vtnMostrarProductos.tbProductos.getValueAt(vtnMostrarProductos.tbProductos.getSelectedRow(),5)));
          
          auxComprobantedetalle.setObjProducto(auxproducto);
          
          auxComprobantedetalle.setPrecio(Double.valueOf(String.valueOf(vtnMostrarProductos.tbProductos.getValueAt(vtnMostrarProductos.tbProductos.getSelectedRow(),7))));
          auxComprobantedetalle.setCantidad(Integer.valueOf(vtnMostrarProductos.tfCantidad.getText()));
          auxComprobantedetalle.calcularSubTotal();
          model.objComprobante.setListaproductos(auxComprobantedetalle);
          
          vtnMostrarProductos.dispose();
          vtnFacturacion.jtDetalleComprobante.setModel(mostrarEnTablaLista((DefaultTableModel) limpiarTabla((DefaultTableModel)vtnFacturacion.jtDetalleComprobante.getModel()),model.objComprobante.listarDetalleComprobante()));
          model.objComprobante.calcularMontoTotal();
          vtnFacturacion.tfMontoPrecio.setText(String.valueOf(model.objComprobante.getPrecio()));
          vtnFacturacion.tfMontoIGV.setText(String.valueOf(model.objComprobante.getIgv()));
          vtnFacturacion.tfMontoTotal.setText(String.valueOf(model.objComprobante.getMontoTotal()));
          
       }
       
    }
    
    
    
    
    
    private void salir(JFrame jfra){
        try {
            jfra.dispose();
        } catch (Exception e) {
            
        }
    }
    
    private void cerrar(JInternalFrame jfra){
        try {
            jfra.dispose();
        } catch (Exception e) {  
        }
    }
/*
    private void abrirFacturacion(int tipocomprobante) {
        vtnFacturacion=new Facturacion();
        this.model.NuevoCombronate();
        
         //cargar las variables globales
        this.vtnFacturacion.tfEmpresa.setText(this.model.variablesGlobales.getEmpresa());
        
        //--cargar los datos del comprobante
        this.model.objComprobante.setFechaEmision(this.model.variablesGlobales.getFecha());
        
        //lenar el correlativo del comprobante
        int[] correlativo=this.model.DatosComprobante(tipocomprobante);
        
        this.model.objComprobante.setIdtipocomprobante(tipocomprobante);
        this.model.objComprobante.setIdcomprobante(correlativo[0]);
        this.model.objComprobante.setIdserie(correlativo[1]);
        //Combrobante en estado activo
        this.model.objComprobante.setEstado("Activo");
        
        //Cargar los datos del comprobante en el formulario
        DateFormat fecha= new SimpleDateFormat("dd/MM/yyyy");     
        this.vtnFacturacion.tfFecha.setText(fecha.format(this.model.objComprobante.getFechaEmision()));              
        //--cargar vendedores
        llenarComboBox(vtnFacturacion.cbVendedores,this.model.itemCombobox("cblistavendedores"," idVendedor , NombreApellido "));
        
        if(this.model.objComprobante.getIdtipocomprobante() == 1){
            this.vtnFacturacion.jcTipoDocumento.setSelectedItem("FACTURA");
            this.vtnFacturacion.jlDocumento.setText("FACTURA");
        }
        else{
            this.vtnFacturacion.jcTipoDocumento.setSelectedItem("BOLETA");
            this.vtnFacturacion.jlDocumento.setText("BOLETA");
        }
        this.vtnFacturacion.jlSerie.setText(String.valueOf(this.model.objComprobante.getIdserie()));
        this.vtnFacturacion.jlCodigo.setText(String.valueOf(this.model.objComprobante.getIdcomprobante()));    
        
        this.vtnFacturacion.cbVendedores.addActionListener(this);
        this.vtnFacturacion.btBuscarCliente.addActionListener(this);
        this.vtnFacturacion.btAgregarProducto.addActionListener(this);
        this.vtnFacturacion.btGrabar.addActionListener(this);
        this.vtnFacturacion.btSalir.addActionListener(this);
        this.vtnFacturacion.btImprimir.addActionListener(this);
        this.vtnFacturacion.setClosable(true);
        this.vtnFacturacion.setMaximizable(true);
        this.vtnFacturacion.setResizable(true);
        
        this.vtnPrincipal.pnPrincipal.add(vtnFacturacion);
        
        DefaultComboBoxModel cbClienteModelo= (DefaultComboBoxModel)this.vtnFacturacion.cbCliente.getModel();
        ArrayList<ItemComboBox> lista= this.model.itemCombobox("cliente","idcliente , nombre ");
        for (int i = 0; i < lista.size(); i++) {
            cbClienteModelo.addElement(lista.get(i));
        }
        
        
        this.vtnFacturacion.setVisible(true);
        //this.vtnFacturacion.show();
    }
    
    private void abrirMostrarProductos(){
        vtnMostrarProductos=new MostrarProductos();
        vtnMostrarProductos.tbProductos.setModel(this.model.llamarVistaDB("listaProductos"));      
        
        vtnMostrarProductos.btAgregarProducto.addActionListener(this);
        vtnMostrarProductos.toFront();
        vtnMostrarProductos.setVisible(true);
    }
    
    
    
     private void abrirMantenimientoMarca() {
        vtnMantenimientoMarca =new Jf_Mant_Marca();
        vtnMantenimientoMarca.tbMarcas.setModel(this.model.llamarVistaDB("listaMarcas"));
        
        this.vtnMantenimientoMarca.btAgregarMarca.addActionListener(this);
        this.vtnMantenimientoMarca.setClosable(true);
        this.vtnMantenimientoMarca.setMaximizable(true);
        this.vtnMantenimientoMarca.setResizable(true);
        
        this.vtnPrincipal.pnPrincipal.add(vtnMantenimientoMarca);
        vtnMantenimientoCliente.toFront();
        vtnMantenimientoMarca.setVisible(true);
        
    }
     
     private void abrirMantenimientoProducto() {
        vtnMantenimientoProducto=new Jf_Mant_Productos();
        vtnMantenimientoProducto.tbProductos.setModel(this.model.llamarVistaDB("listamantproducto"));
         llenarComboBox(vtnMantenimientoProducto.cbMarca, this.model.itemCombobox("cblistaMarcas", " idmarca , nombre " ));
         llenarComboBox(vtnMantenimientoProducto.cbProveedor, this.model.itemCombobox("cblistaProveedor", " idproveedor , nombre " ));
         llenarComboBox(vtnMantenimientoProducto.cbCategoria, this.model.itemCombobox("cblistaCategorias", " idcategoria , Abreviado " ));
         llenarComboBox(vtnMantenimientoProducto.cbNivel, this.model.itemCombobox("cblistaNivel", " idnivel , Abreviado " ));
         
         this.vtnMantenimientoProducto.btAgregarProducto.addActionListener(this);
         
         this.vtnMantenimientoProducto.setClosable(true);
         this.vtnMantenimientoProducto.setMaximizable(true);
         this.vtnMantenimientoProducto.setResizable(true);
         
        this.vtnPrincipal.pnPrincipal.add(vtnMantenimientoProducto);
        vtnMantenimientoProducto.toFront();
        vtnMantenimientoProducto.setVisible(true);
    }
     
    private DefaultTableModel mostrarEnTablaLista(DefaultTableModel modeloTabla, Object[][] listaMostrar){
        for (int i=0;i<listaMostrar.length;i++) {
            modeloTabla.addRow(listaMostrar[i]);
        }
        return modeloTabla;
    }
    
    private DefaultTableModel limpiarTabla(DefaultTableModel modeloTabla){
        for(int i=modeloTabla.getRowCount()-1;i>=0;i--){
            modeloTabla.removeRow(i);
        }
        return modeloTabla;
    }

    private void llenarComboBox(JComboBox cbVendedores, ArrayList<ItemComboBox> lista) {
        cbVendedores.removeAll();
        cbVendedores.addItem(new ItemComboBox("0"," (Seleccione ) "));
        for (ItemComboBox itemComboBox : lista) {
            cbVendedores.addItem(itemComboBox);
        }
        
    }

    private void abrirRegistrarEntrada() {
        vtnRegistrarIngreso =new Jf_Sist_Ingreso();
        model.objEntrada=new Entrada();
        model.objEntrada.setEstado("ACTIVO");
        this.vtnRegistrarIngreso.lbIngresoId.setText(String.valueOf(model.llamarCorrelativoIngresoSalida("correlativoingreso")));
        llenarComboBox(vtnRegistrarIngreso.cbProveedor,this.model.itemCombobox("cblistaproveedor"," idProveedor , Nombre "));
        llenarComboBox(vtnRegistrarIngreso.cbProductos,this.model.itemCombobox("cblistaproductos"," CodigoProducto , Producto "));
        this.vtnRegistrarIngreso.btAgregarKardexEntrada.addActionListener(this);
        this.vtnRegistrarIngreso.btRegistrarIngreso.addActionListener(this);
        this.vtnRegistrarIngreso.setClosable(true);
        this.vtnRegistrarIngreso.setMaximizable(true);
        this.vtnRegistrarIngreso.setResizable(true);
        
        this.vtnPrincipal.pnPrincipal.add(vtnRegistrarIngreso);
        vtnRegistrarIngreso.toFront();
        vtnRegistrarIngreso.setVisible(true);
        
    }

    private void abrirMantenimientoProveedor() {
        vtnMantenimientoProveedor=new Jf_Mant_Proveedor();
        
        this.vtnMantenimientoProveedor.setClosable(true);
         this.vtnMantenimientoProveedor.setMaximizable(true);
         this.vtnMantenimientoProveedor.setResizable(true);
        this.vtnPrincipal.pnPrincipal.add(vtnMantenimientoProveedor);
        vtnMantenimientoProveedor.toFront();
        vtnMantenimientoProveedor.setVisible(true);
        
    }

   
*/
   

    


    
    
}
