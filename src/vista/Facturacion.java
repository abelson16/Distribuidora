/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Abelson
 */
public class Facturacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Facturacion
     */
    public Facturacion() {
        initComponents();

        jtDetalleComprobante.getColumnModel().getColumn(0).setPreferredWidth(500);
        //jtDetalleComprobante.getTableHeader().setBackground(new Color(65,129,208));
        jtDetalleComprobante.getColumnModel().getColumn(1).setPreferredWidth(60);
        jtDetalleComprobante.getColumnModel().getColumn(2).setPreferredWidth(60);
        jtDetalleComprobante.getColumnModel().getColumn(3 ).setPreferredWidth(80);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtDetalleComprobante = new javax.swing.JTable();
        jcVendedores = new javax.swing.JLabel();
        tfMontoPrecio = new javax.swing.JTextField();
        btAgregarProducto = new javax.swing.JButton();
        jcTipoDocumento = new javax.swing.JComboBox();
        btEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MaskFormatter mascara = null;
        try {
            mascara = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
        }
        tfFecha = new JFormattedTextField(mascara);
        btGrabar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlDocumento = new javax.swing.JLabel();
        jlSerie = new javax.swing.JLabel();
        jlCodigo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfDireccionCliente = new javax.swing.JTextField();
        tfNombreCliente = new javax.swing.JTextField();
        btBuscarCliente = new javax.swing.JButton();
        tfNumeroDocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfEmpresa = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfMontoIGV = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfMontoTotal = new javax.swing.JTextField();
        cbVendedores = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtDetalleComprobante.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtDetalleComprobante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio", "Cantidad", "Sub total"
            }
        ));
        jtDetalleComprobante.setName("jtDetalleComprobante"); // NOI18N
        jScrollPane1.setViewportView(jtDetalleComprobante);

        jcVendedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcVendedores.setText("Precio");
        jcVendedores.setName("jcVendedores"); // NOI18N

        tfMontoPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfMontoPrecio.setName("tfMontoPrecio"); // NOI18N

        btAgregarProducto.setText("Agregar");
        btAgregarProducto.setActionCommand("BuscarProducto");
        btAgregarProducto.setName("btAgregarProducto"); // NOI18N

        jcTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FACTURA", "BOLETA", " " }));
        jcTipoDocumento.setName("jcTipoDocumento"); // NOI18N

        btEliminar.setText("Eliminar");
        btEliminar.setName("btEliminar"); // NOI18N

        jLabel1.setText("Fecha:");
        jLabel1.setName("jLabel1"); // NOI18N

        tfFecha.setValue("");
        try {
            tfFecha.commitEdit();
        } catch (ParseException ex1) {
        }
        tfFecha.setName("tfFecha"); // NOI18N

        btGrabar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btGrabar.setText("Grabar");
        btGrabar.setActionCommand("GrabarComprobante");
        btGrabar.setName("btGrabar"); // NOI18N

        jLabel5.setText("Tipo de Comprobante:");
        jLabel5.setName("jLabel5"); // NOI18N

        btSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSalir.setText("Salir");
        btSalir.setName("btSalir"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jlDocumento.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlDocumento.setForeground(new java.awt.Color(170, 10, 50));
        jlDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDocumento.setText("Factura");
        jlDocumento.setName("jlDocumento"); // NOI18N

        jlSerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlSerie.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlSerie.setText("jLabel7");
        jlSerie.setName("jlSerie"); // NOI18N

        jlCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCodigo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlCodigo.setText("jLabel9");
        jlCodigo.setName("jlCodigo"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText(" - ");
        jLabel8.setName("jLabel8"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(75, 75, 75)
                        .add(jlSerie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jlCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(32, 32, 32)
                        .add(jlDocumento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jlDocumento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlCodigo)
                    .add(jlSerie)
                    .add(jLabel8))
                .add(32, 32, 32))
        );

        jPanel2.setToolTipText("Cliente");
        jPanel2.setName("jPanel2"); // NOI18N

        tfDireccionCliente.setName("tfDireccionCliente"); // NOI18N

        tfNombreCliente.setName("tfNombreCliente"); // NOI18N

        btBuscarCliente.setText("Buscar Cliente");
        btBuscarCliente.setActionCommand("BuscarCliente");
        btBuscarCliente.setName("btBuscarCliente"); // NOI18N

        tfNumeroDocumento.setName("tfNumeroDocumento"); // NOI18N

        jLabel4.setText("RUC / DNI:");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel2.setText("Cliente:");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("Direccion:");
        jLabel3.setName("jLabel3"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(91, 91, 91)
                .add(btBuscarCliente)
                .add(94, 94, 94)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(tfNumeroDocumento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tfNombreCliente)
                    .add(tfDireccionCliente))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btBuscarCliente)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(tfNumeroDocumento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(tfNombreCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tfDireccionCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(204, 50));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Comprobante");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel6.setName("jLabel6"); // NOI18N

        tfEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfEmpresa.setText("jLabel7");
        tfEmpresa.setName("tfEmpresa"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 184, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(tfEmpresa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 339, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .add(tfEmpresa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(74, 129, 205));
        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 6));

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 6, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("IGV:");
        jLabel11.setName("jLabel11"); // NOI18N

        tfMontoIGV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfMontoIGV.setName("tfMontoIGV"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Monto Total:");
        jLabel12.setName("jLabel12"); // NOI18N

        tfMontoTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfMontoTotal.setName("tfMontoTotal"); // NOI18N

        cbVendedores.setActionCommand("SeleccionVendedor");
        cbVendedores.setName("cbVendedores"); // NOI18N

        jLabel7.setText("Vendedor:");
        jLabel7.setName("jLabel7"); // NOI18N

        btImprimir.setText("Imprimir");
        btImprimir.setActionCommand("ImprimirComprobante");
        btImprimir.setName("btImprimir"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(25, 25, 25)
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(tfFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel7)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(cbVendedores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 226, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(42, 42, 42)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jLabel5)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jcTipoDocumento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(17, 17, 17))))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 815, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(btAgregarProducto)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(btEliminar)
                                        .add(0, 0, Short.MAX_VALUE))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(0, 0, Short.MAX_VALUE)
                                        .add(btImprimir)))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(btGrabar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(btSalir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(33, 33, 33)
                                        .add(jcVendedores)
                                        .add(18, 18, 18)
                                        .add(tfMontoPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jLabel11)
                                .add(18, 18, 18)
                                .add(tfMontoIGV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jLabel12)
                                .add(18, 18, 18)
                                .add(tfMontoTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1)
                    .add(jLabel5)
                    .add(jcTipoDocumento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbVendedores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(btAgregarProducto)
                        .add(btEliminar))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(tfMontoPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jcVendedores)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfMontoIGV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel11))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfMontoTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel12))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 55, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btGrabar)
                    .add(btSalir)
                    .add(btImprimir))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btAgregarProducto;
    public javax.swing.JButton btBuscarCliente;
    public javax.swing.JButton btEliminar;
    public javax.swing.JButton btGrabar;
    public javax.swing.JButton btImprimir;
    public javax.swing.JButton btSalir;
    public javax.swing.JComboBox cbVendedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox jcTipoDocumento;
    private javax.swing.JLabel jcVendedores;
    public javax.swing.JLabel jlCodigo;
    public javax.swing.JLabel jlDocumento;
    public javax.swing.JLabel jlSerie;
    public javax.swing.JTable jtDetalleComprobante;
    public javax.swing.JTextField tfDireccionCliente;
    public javax.swing.JLabel tfEmpresa;
    public javax.swing.JFormattedTextField tfFecha;
    public javax.swing.JTextField tfMontoIGV;
    public javax.swing.JTextField tfMontoPrecio;
    public javax.swing.JTextField tfMontoTotal;
    public javax.swing.JTextField tfNombreCliente;
    public javax.swing.JTextField tfNumeroDocumento;
    // End of variables declaration//GEN-END:variables
}