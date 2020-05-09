package Main;

import Conexion.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class Prestar extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection con = conexion.getConnection();
    int cantidadProductoTrabajador;
    int cantidadProductoPersonas;

    public Prestar() {
        initComponents();
        this.setTitle("Prestamos");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        cargarCombo(cbxAreaP, "domareas", "area");
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoTrabajadorT1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cbxAreaP = new javax.swing.JComboBox<>();
        cbxProductoP = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCodigoP = new javax.swing.JTextField();
        txtCantidadPersonas = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 135, 158));

        jButton2.setText("Prestar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo Trabajador:");

        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyReleased(evt);
            }
        });

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Tabla1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Codigo Producto:");

        txtCodigoTrabajadorT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoTrabajadorT1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoProducto))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoTrabajadorT1)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigoTrabajadorT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Trabajador", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 135, 158));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripcion:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Area:");

        cbxAreaP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAreaP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAreaPItemStateChanged(evt);
            }
        });

        cbxProductoP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Selecciona-" }));
        cbxProductoP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProductoPItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Producto:");

        jButton1.setText("Prestar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Codigo Producto:");

        txtCodigoP.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cantidad:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addComponent(cbxAreaP, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxProductoP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadPersonas)
                            .addComponent(txtCodigoP))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxAreaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxProductoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodigoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(92, 92, 92))
        );

        jTabbedPane1.addTab("Personas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha = sdf.format(date);
        String folio = String.valueOf(UUID.randomUUID());
        try {
            iniciarTransaccion(txtCodigoTrabajadorT1.getText(), fecha, folio);
            llenarTabla();
        } catch (SQLException e) {
            if (e.getMessage().contains("a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(this, "No existe el trabajador");
            }
            try {
                System.out.println(e.getMessage());
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            if (e.getMessage().contains("For input string:")) {
                JOptionPane.showMessageDialog(this, "Colocar un numero");
            }
        } finally {
            try {
                con.setAutoCommit(true);
                limpiarCajas();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String descripcion = txtDescripcion.getText();
        String codigoProducto = txtCodigoP.getText();
        String cantidad = txtCantidadPersonas.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha = sdf.format(date);
        String folio = String.valueOf(UUID.randomUUID());
        
        try {
            iniciarTransaccionPersona(nombre, apellido, descripcion, codigoProducto, cantidad, fecha, folio);
            
        } catch (SQLException e) {
            try {
                System.out.println(e.getMessage());
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            if (e.getMessage().contains("For input string:")) {
                JOptionPane.showMessageDialog(this, "Colocar un numero");
            }
        } finally {
            try {
                con.setAutoCommit(true);
                limpiarCajas();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxAreaPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAreaPItemStateChanged
        cargarComboAnidado(cbxProductoP, "productos", "Nombre", cbxAreaP.getSelectedItem().toString());
    }//GEN-LAST:event_cbxAreaPItemStateChanged

    private void cbxProductoPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProductoPItemStateChanged
        try {
            PreparedStatement ps = con.prepareStatement("select * from productos where nombre=?");
            ps.setString(1, cbxProductoP.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txtCodigoP.setText(rs.getString("codigo"));
                cantidadProductoPersonas = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_cbxProductoPItemStateChanged

    private void txtCodigoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            insertarTempoProductos(txtCodigoProducto.getText());
            llenarTabla();
        }
    }//GEN-LAST:event_txtCodigoProductoKeyReleased

    private void txtCodigoTrabajadorT1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoTrabajadorT1KeyReleased

    }//GEN-LAST:event_txtCodigoTrabajadorT1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Prestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.JComboBox<String> cbxAreaP;
    private javax.swing.JComboBox<String> cbxProductoP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCantidadPersonas;
    private javax.swing.JTextField txtCodigoP;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoTrabajadorT1;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    public void iniciarTransaccion(String CodigoTrabajador, String Fecha, String Folio) throws SQLException {
        if (CodigoTrabajador.equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el codigo del trabajador");
            return;
        } else {
            PreparedStatement ps = con.prepareStatement("select * from trabajadores where codigo=?");
            ps.setString(1, CodigoTrabajador);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                PreparedStatement ps2 = con.prepareStatement("select * from tempoproductos");
                ResultSet rs2 = ps2.executeQuery();
                if(Tabla1.getRowCount() > 0){
                    while(rs2.next()){
                        con.setAutoCommit(false);
                        PreparedStatement ps3 = con.prepareStatement("INSERT INTO `inventario`.`historialtrabajadores` "
                        + "(`CodigoProducto`, `CodigoTrabajador`, `Fecha`, `Folio`, `CantidadProducto`) "
                        + "VALUES (?,?,?,?,?)");
                        ps3.setString(1, rs2.getString("codigo"));
                        ps3.setString(2, CodigoTrabajador);
                        ps3.setString(3, Fecha);
                        ps3.setString(4, Folio);
                        ps3.setInt(5, rs2.getInt("cantidad"));
                        ps3.execute();
                        ps3.close();
                        con.commit();
                    }
                    con.setAutoCommit(false);
                    PreparedStatement ps4 = con.prepareStatement("delete from tempoproductos");
                    ps4.execute();
                    con.commit();
                    JOptionPane.showMessageDialog(this, "Prestamo exitoso");
                }
                else{
                    JOptionPane.showMessageDialog(this, "No hay productos en lista");
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "No existe el trabajador");
            }
        }

    }

    public void cargarCombo(JComboBox combo, String tabla, String columna) {
        DefaultComboBoxModel cbxM = new DefaultComboBoxModel();
        cbxM.addElement("-Selecciona-");
        try {
            PreparedStatement ps = con.prepareStatement("select * from " + tabla);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbxM.addElement(rs.getString(columna));
            }
            combo.setModel(cbxM);
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void cargarComboAnidado(JComboBox combo, String tabla, String columna, String itemSeleccionado) {
        DefaultComboBoxModel cbxM = new DefaultComboBoxModel();
        cbxM.addElement("-Selecciona-");
        try {
            PreparedStatement ps = con.prepareStatement("select * from " + tabla + " where area=?");
            ps.setString(1, itemSeleccionado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbxM.addElement(rs.getString(columna));
            }
            combo.setModel(cbxM);
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void iniciarTransaccionPersona(
    String Nombre,String apellido, String Descripcion,String CodigoProducto,String cantidad,
            String fecha,String folio) throws SQLException, Exception{
        if (Integer.parseInt(cantidad) > cantidadProductoPersonas) {
            JOptionPane.showMessageDialog(this, "Exedio el limite de productos");

        } else {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("INSERT INTO `inventario`.`historialpersonas` "
                    + "(`Nombre`, `Apellido`, `Descripcion`, `CodigoProducto`, `CantidadProducto`, `Fecha`, `Folio`)"
                    + " VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, Nombre);
            ps.setString(2, apellido);
            ps.setString(3, Descripcion);
            ps.setString(4, CodigoProducto);
            ps.setString(5, cantidad);
            ps.setString(6, fecha);
            ps.setString(7, folio);
            ps.executeUpdate();
            ps.close();

            int c = cantidadProductoPersonas - Integer.parseInt(txtCantidadPersonas.getText());
            PreparedStatement ps2 = con.prepareStatement("UPDATE `inventario`.`productos`"
                    + " SET `Cantidad` =? WHERE (`Codigo` = ?)");
            ps2.setInt(1, c);
            ps2.setString(2, CodigoProducto);
            ps2.executeUpdate();
            ps2.close();
            con.commit();
            JOptionPane.showMessageDialog(this, "Prestamo exitoso");
        }
        
    }
    public void limpiarCajas() {
        txtApellido.setText("");
        txtNombre.setText("");
        //txtCantidadTrabajador.setText("");
        txtCodigoP.setText("");
        //txtCodigoT.setText("");
        txtCodigoProducto.setText("");
        txtDescripcion.setText("");
        cbxAreaP.setSelectedIndex(0);
        //cbxAreaT.setSelectedIndex(0);
        cbxProductoP.setSelectedIndex(0);
        //cbxProductoT.setSelectedIndex(0);
        txtCantidadPersonas.setText("");
    }
    
    public void insertarTempoProductos(String codigo){
        try{
            PreparedStatement ps = con.prepareStatement("select * from productos where codigo=?");
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("cantidad") > 0){
                        PreparedStatement ps2 = con.prepareStatement("select codigo, cantidad from tempoproductos where codigo=?");
                        ps2.setString(1, rs.getString("codigo"));
                        ResultSet rs2 = ps2.executeQuery();
                    if(rs2.next()){
                        con.setAutoCommit(false);
                        PreparedStatement ps3 = con.prepareStatement("UPDATE `tempoproductos`"
                        + " SET `Cantidad` =? WHERE (`Codigo` = ?)");
                        ps3.setInt(1, rs2.getInt("cantidad") + 1);
                        ps3.setString(2, rs2.getString("codigo"));
                        ps3.executeUpdate();
                        ps3.close();

                        PreparedStatement ps4 = con.prepareStatement("UPDATE `productos`"
                        + " SET `Cantidad` =? WHERE (`Codigo` = ?)");
                        ps4.setInt(1, rs.getInt("cantidad") - 1);
                        ps4.setString(2, rs.getString("codigo"));
                        ps4.executeUpdate();
                        ps4.close();
                        con.commit();
                    }
                    else{
                        con.setAutoCommit(false);
                        PreparedStatement ps3 = con.prepareStatement("INSERT INTO `tempoproductos`"
                        + "(`codigo`, `nombre`, `area`, `cantidad`) "
                        + "VALUES (?,?,?,?)");
                        ps3.setString(1, rs.getString("codigo"));
                        ps3.setString(2, rs.getString("nombre"));
                        ps3.setString(3, rs.getString("area"));
                        ps3.setInt(4, 1);
                        ps3.executeUpdate();
                        ps3.close();

                        PreparedStatement ps4 = con.prepareStatement("UPDATE `productos`"
                        + " SET `Cantidad` =? WHERE (`Codigo` = ?)");
                        ps4.setInt(1, rs.getInt("cantidad") - 1);
                        ps4.setString(2, rs.getString("codigo"));
                        ps4.executeUpdate();
                        ps4.close();
                        con.commit();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No hay mas productos del codigo " + rs.getString("nombre") + " en inventario");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }
        }
        catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public void llenarTabla(){
        String titulos[] = {
            "Codigo","Nombre","Area","Cantidad"  
        };
        DefaultTableModel dtm = new DefaultTableModel(titulos,0);
        try {
        PreparedStatement ps = con.prepareStatement("select * from tempoproductos");
        ResultSet rs = ps.executeQuery();
        Object row[]= new Object[5];
        while(rs.next()){
            row[0]=rs.getString("codigo");
            row[1]=rs.getString("nombre");
            row[2]=rs.getString("area");
            row[3]=rs.getString("cantidad");
            dtm.addRow(row);
        }
        Tabla1.setModel(dtm);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
    }
    }
}
