package Ventanas_productos;
import ConfigBd.BD;
import Ventanas_productos.FrameRegistrarProductos;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Ventanas_personas.FrameEditPersona;
import Ventanas_personas.Registrar;

public class PanelProductos extends javax.swing.JPanel {
    private  PanelProductos Parent;
    String id;

    public PanelProductos() {
        initComponents();
        this.recargarTabla();
    }
    
    public void recargarTabla(){        
        BD db = new BD();
        tablaProductos.setModel(db.getProductos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 255));
        setPreferredSize(new java.awt.Dimension(592, 450));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 17, 560, 34));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 109, 40));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductos.setEditingColumn(0);
        tablaProductos.setEditingRow(0);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablaProductos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 560, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 109, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 109, 40));
    }// </editor-fold>//GEN-END:initComponents
 //Evento que se ejecuta cuando se hace click al boton eliminar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(this.id == null){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun producto");
            return;
        }
        BD db = new BD();
        db.eliminarRegistro("Productos", id, "Id_producto");
        //Receteando el id seleccionado desde la tabla
        this.id = null;
        this.recargarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    //Evento que se ejecuta cuando se hace click a una celda
    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed
        //Evento que obtiene el id de la fila seleccionada
        JTable Tabla = (JTable) evt.getSource();
        int row = Tabla.rowAtPoint(evt.getPoint());
        int column = Tabla.columnAtPoint(evt.getPoint());

        id = Tabla.getValueAt(row, 0).toString();
    }//GEN-LAST:event_tablaProductosMousePressed

    //Evento que se ejecuta cuando se hace click en Crear productos
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FrameRegistrarProductos frameCrearProducto = new FrameRegistrarProductos();
        frameCrearProducto.setVisible(true);
        frameCrearProducto.asignarReferencia(this);
    }//GEN-LAST:event_jButton3ActionPerformed
 //Evento que se ejecuta cuando se hace click al boton eliminar
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Comprobando que haga una fila seleccionada
        if(this.id == null){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun producto");
            return;
        }

        BD db = new BD();
        //Trayendo la data desde la base de datos
        Map<String, String> data = db.getProductoById("Productos", "Id_producto", id);

        //Abriendo el formulario de editar
        FrameEditarProducto frmEditar = new FrameEditarProducto();
        frmEditar.setVisible(true);
        
        //Instanciando y obteniendo la referencia al formulario Registrar
        FrameRegistrarProductos frmRegistrar = new FrameRegistrarProductos();
        frmRegistrar.asignarReferencia(this);
        
         frmEditar.getData(id, data, frmRegistrar, this);
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
