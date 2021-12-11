package Ventanas_personas;

import javax.swing.JOptionPane;
import Entidades.Persona;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;

public class Registrar extends javax.swing.JFrame {
    private  PanelUsuarios Parent;
    private boolean isLogin = false;
    
    public Registrar() {        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void redirectLogin(){
         Login log = new Login();
         log.setVisible(true);
         this.setVisible(false);
    }
    
    public void setFormVisible(PanelUsuarios parent,boolean islogin){ 
        //Esta ventana se usa para crear un usuario antes de logearte y tambien para crear dentro del crud
          this.isLogin = islogin;
          this.Parent = parent;
          
          //Si se llama desde el login se oculta el boton de volver al login
          if(this.isLogin == false){
               this.btnRegistrar.setText("Registrar");
               this.volverLogin.setVisible(false);
          }
          //Siendo desde el login o no como quiera este se abre
          this.setVisible(true);
   }
    
  //Funcion que me permite obtener la instancia del panel para poder recargar la tabla  
  public void asignarReferencia(PanelUsuarios parent){
       this.Parent = parent;
       this.Parent.recargarTabla();
  }
    
    public void redireccionar(boolean loginOrClose, List<String> values){
            //Combirtiendo la lista en un String separado por coma
            String valuesJoin = String.join("','", values);
            
            //Cuando se ejecuta la funcion se comprueba si esta ventana se abrio desde el login me redirije al login
             if(loginOrClose){
                 Persona person = new Persona();
                 person.agregarRegisto(valuesJoin, "Personas");
                 this.redirectLogin();
             } 
             //Si este se ejecuta desde el crud se cierra el login y se recarga la tabla
             else{
                 Persona person = new Persona();
                 person.agregarRegisto(valuesJoin, "Personas");
                 this.Parent.recargarTabla();
                 this.setVisible(false);                       
             }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtRepetirPassword = new javax.swing.JPasswordField();
        volverLogin = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 88, 191, 29));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Apellido");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 88, 191, 29));

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 123, 191, 31));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Username");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 180, 191, 29));

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 215, 191, 31));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 180, 191, 29));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Teléfono");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 191, 29));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 191, 31));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 19, 454, 32));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 123, 191, 31));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrarse");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 339, 124, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Repetir password");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 191, 29));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 215, 191, 31));

        txtRepetirPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepetirPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtRepetirPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 290, 200, 30));

        volverLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        volverLogin.setForeground(new java.awt.Color(0, 153, 153));
        volverLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volverLogin.setText("¿Ya esta registrado?  Login");
        volverLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volverLoginMouseClicked(evt);
            }
        });
        getContentPane().add(volverLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 385, 454, 58));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
      
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
       
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String userName = txtUsername.getText();
        String password = txtPassword.getText();
        String password2 = txtRepetirPassword.getText();
        
        //Validando que ningun campo este vacio
        if(nombre.equals("") && apellido.equals("") && userName.equals("") && telefono.equals("") && password.equals("") ){
            JOptionPane.showMessageDialog(rootPane, "Complete todos los campos");
            return;
        } 
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Complete el campo nombre");
            return;
        }
        if(apellido.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Complete el campo apellido");
            return;
        }
        if(userName.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Complete el campo userName");
            return;
        }
        
        if(telefono.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Complete el campo telefono");
            return;
        }
        
        if(telefono.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Complete el campo telefono");
            return;
        }
        
        if(password.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Complete el campo Password");
            return;
        }
        if(password2.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Complete el campo Repetir password");
            return;
        }
        //Validando si las contraseñas son iguales
        if(txtPassword.getText().equals(txtRepetirPassword.getText())) {
             List<String> values = new ArrayList();
             values.add(nombre);
             values.add(userName);
             values.add(apellido);
             values.add(telefono);
             values.add(password);
                          
             this.redireccionar(this.isLogin, values);
        }
        else{
             JOptionPane.showMessageDialog(rootPane, "Las contraseñas son diferentes");
             return;
        }
        
       
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtRepetirPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepetirPasswordActionPerformed
   
    }//GEN-LAST:event_txtRepetirPasswordActionPerformed

    private void volverLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverLoginMouseClicked
        this.redirectLogin();
    }//GEN-LAST:event_volverLoginMouseClicked

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRepetirPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel volverLogin;
    // End of variables declaration//GEN-END:variables
}
