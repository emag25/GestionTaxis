
package gui;

import SQLconecion.ClienteDB;
import java.awt.Frame;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FrmPerfil extends javax.swing.JDialog {
    
    private Point pt;
    private Frame parent;
    private String[] date;
    private JDialog jdgInicio;
    
    public FrmPerfil(java.awt.Frame parent, boolean modal, Point pt, String[] date,JDialog jdgInicio) {
        super(parent, modal);
        this.parent = parent;
        this.pt = pt;
        this.date = date;
        this.jdgInicio = jdgInicio;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnModDatos = new javax.swing.JButton();
        btnCambiarCta = new javax.swing.JButton();
        btnEliminarCta = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(pt);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnModDatos.setText("Modificar datos Personales");
        btnModDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModDatosActionPerformed(evt);
            }
        });

        btnCambiarCta.setText("Cambiar cuenta bancaria");
        btnCambiarCta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCtaActionPerformed(evt);
            }
        });

        btnEliminarCta.setText("Eliminar cuenta Personal");
        btnEliminarCta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCtaActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModDatos)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCambiarCta)
                                    .addComponent(btnEliminarCta)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnRegresar)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarCta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarCta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarCtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCtaActionPerformed
        this.dispose();
        FrmModificarP2 frmModificarP2 = new FrmModificarP2(parent, true, date);
        frmModificarP2.setVisible(true);
    }//GEN-LAST:event_btnCambiarCtaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModDatosActionPerformed
        this.dispose();
        FrmModificarP1 frmModificarP1 = new FrmModificarP1(parent, true,date);
        frmModificarP1.setVisible(true);
    }//GEN-LAST:event_btnModDatosActionPerformed

    private void btnEliminarCtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCtaActionPerformed
        ClienteDB cDB = new ClienteDB();
        //cDB.eliminarUsuario(date[0]);
        if (JOptionPane.showConfirmDialog(null, "Seguro que deseas  eliminar su cuenta.", "ELIMINAR CUENTA",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {             
            cDB.eliminarUsuario(date[0]);
            jdgInicio.dispose();
            this.dispose();
        } else {
            this.dispose();
        }
        
    }//GEN-LAST:event_btnEliminarCtaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarCta;
    private javax.swing.JButton btnEliminarCta;
    private javax.swing.JButton btnModDatos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
