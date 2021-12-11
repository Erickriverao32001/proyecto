package Ventanas_personas;

import Entidades.Persona;
import javax.swing.JOptionPane;
import ConfigBd.BD;
import java.awt.Dialog;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public  class PanelUsuarios extends javax.swing.JPanel {
    Persona person = new Persona();
    BD db = new BD();
    //Variable global que siempre tendra el id de la fila seleccionada por la tabla
    String id;
    boolean started = false;
    
    public PanelUsuarios() {
        initComponents();
        this.started = true;
        this.recargarTabla();        
    }
    
    //Funcion que recarga la tabla haciendo una consulta con la base de datos y llenandola otra vez
    public void recargarTabla(){        
        tablaPersonas.setModel(db.getPersonas());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setBackground(new java.awt.Color(102, 204, 255));
        setForeground(new java.awt.Color(0, 102, 102));
        setPreferredSize(new java.awt.Dimension(592, 450));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuarios");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 534, 34));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 109, 40));

        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPersonas.setEditingColumn(0);
        tablaPersonas.setEditingRow(0);
        tablaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPersonasMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablaPersonas);

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

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded

    }//GEN-LAST:event_formComponentAdded

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

    }//GEN-LAST:event_formComponentHidden

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(this.id == null){
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun usuario");
                return;    
         } 

        db.eliminarRegistro("Personas", id, "Id_persona");
        //Receteando el id seleccionado desde la tabla
        this.id = null;
        this.recargarTabla();  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaPersonasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonasMousePressed
       //Evento que obtiene el id de la fila seleccionada
        JTable Tabla = (JTable) evt.getSource();
        int row = Tabla.rowAtPoint(evt.getPoint());    
        id = Tabla.getValueAt(row, 0).toString();     
    }//GEN-LAST:event_tablaPersonasMousePressed

    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Abriendo el formulario de registrar haciendo lo visible
        Registrar frameRegistrar = new Registrar();           
        frameRegistrar.setFormVisible(this, false);        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
           //Comprobando que haga una fila seleccionada
            if(this.id == null){
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun usuario");
                return;    
            }
            
            //Trayendo la data desde la base de datos
            Map<String, String> data = db.getByUsuariosId("Personas", "Id_persona", id);
            DefaultTableModel tabla;

            //Abriendo la ventana de edicion
            FrameEditPersona frameEdit = new  FrameEditPersona();
            
            Registrar frameRegistrar = new Registrar();  
            //Pasandole la instancia del Panel actual el formulario de registrar, para que este pueda resetear la tabla a la hora se guarde edite la persona
            frameRegistrar.asignarReferencia(this);
            
            //Obteniendo la data del usuario que se va actualizar
            frameEdit.getData(id,data, frameRegistrar, this);
            frameEdit.setVisible(true);
            
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaPersonas;
    // End of variables declaration//GEN-END:variables
}
