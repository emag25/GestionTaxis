
package gui;

import SQLconecion.ClienteDB;
import gui.system.FrmSystem;
import javax.swing.JOptionPane;
import model.FondoPanel;

public class IniciarSesion extends javax.swing.JFrame{
    private ClienteDB cDB = new ClienteDB();
    
    public IniciarSesion() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new FondoPanel(this);
        logotipo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRecuperacion = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recorridos");
        setResizable(false);

        logotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/l1.png"))); // NOI18N

        jLabel1.setText("Cedula");

        jLabel2.setText("Contraseña");

        txtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaActionPerformed(evt);
            }
        });

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        btnIngresar.setText("Iniciar sesión");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel3.setText("¿Has olvidado tu contraseña?");

        btnRecuperacion.setText("?");
        btnRecuperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperacionActionPerformed(evt);
            }
        });

        btnRegistro.setText("Crear nueva cuenta");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(logotipo))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(29, 29, 29)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(escritorioLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRecuperacion)))))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(logotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnRecuperacion))
                .addGap(18, 18, 18)
                .addComponent(btnRegistro)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaActionPerformed
        // null
    }//GEN-LAST:event_txtContraseniaActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // null
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String date[];
        if( txtCedula.getText().equals("admin")){
            date = cDB.verificarUsuario(txtCedula.getText());
            if(date[2]!=null){
                if(date[2].equals(txtContrasenia.getText())){
                    FrmSystem frmSystem = new FrmSystem(this,true);
                    frmSystem.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario o Contraseña\n incorrecta");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Usuario o Contraseña\n incorrecta");
            }
        }else{
            if(!txtCedula.getText().isBlank() && !txtContrasenia.getText().isBlank()){
                date = cDB.verificarUsuario(txtCedula.getText());
                if(date[2]!=null){
                    if(date[2].equals(txtContrasenia.getText())){
                        FrmPaginaInicio frmInicio = new FrmPaginaInicio(this,true, date);
                        frmInicio.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario o Contraseña\n incorrecta");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario o Contraseña\n incorrecta");
                }   
            }else{
                JOptionPane.showMessageDialog(null,"Llene todos los datos");
            }
            
        }
       txtCedula.setText("");
       txtContrasenia.setText("");
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        
        FrmRegistroP1 frmRegistroP1 = new FrmRegistroP1(this, true);
        frmRegistroP1.setVisible(true);
        
        
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnRecuperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperacionActionPerformed
        JOptionPane.showMessageDialog(null, "Esta funcion estará \ndisponible en las \nnuevas versiones");
    }//GEN-LAST:event_btnRecuperacionActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRecuperacion;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel logotipo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasenia;
    // End of variables declaration//GEN-END:variables
    
}
