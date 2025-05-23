/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cliente;

import com.sun.org.apache.xpath.internal.compiler.OpCodes;
import database.DBWorker;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class JFrameInserirCliente extends javax.swing.JFrame {

    /**
     * Creates new form JFrameInserirCliente
     */
    public JFrameInserirCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        txtCC = new javax.swing.JTextField();
        txtTelemovel = new javax.swing.JTextField();
        txtMorada = new javax.swing.JTextField();
        btnInsereCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNome.setText("Insere nome aqui...");
        txtNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeMouseClicked(evt);
            }
        });
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCC.setText("Insere cartao cidadao aqui...");
        txtCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCCMouseClicked(evt);
            }
        });

        txtTelemovel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTelemovel.setText("Insere telemovel aqui...");
        txtTelemovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelemovelMouseClicked(evt);
            }
        });

        txtMorada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMorada.setText("Insere morada aqui...");
        txtMorada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMoradaMouseClicked(evt);
            }
        });

        btnInsereCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInsereCliente.setText("Submeter");
        btnInsereCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsereClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCC, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(txtNome)
                    .addComponent(txtTelemovel)
                    .addComponent(txtMorada))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnInsereCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelemovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMorada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInsereCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnInsereClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsereClienteActionPerformed
        try {
            //Conectar a base de dados
            DBWorker db = new DBWorker("127.0.0.1", "root", "", "gice");
            
            String cc = txtCC.getText();
            String nome = txtNome.getText();
            String telemovel = txtTelemovel.getText();
            String morada = txtMorada.getText();
            String sqlCode = "INSERT INTO clientes(cartao_cidadao,nome,morada,telemovel) VALUES('" + cc + "','" + nome + "','" + morada + "','" + telemovel + "');";
            boolean verificarNome = VerificaStringSeHaNumeros(nome);
            boolean verificarTelemovel = VerificarString(telemovel);
            boolean verificarCC = VerificarString(cc);
            
            if(nome.isEmpty() == false && morada.isEmpty() == false && cc.isEmpty() == false && telemovel.isEmpty() == false) {
                if(cc.length() == 8 && telemovel.length() == 9) {
                    if(!verificarNome && !verificarTelemovel && !verificarCC) {
                        db.executeUpdate(sqlCode);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Por favor reveja os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } 
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Por favor reveja os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Por favor preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(JFrameInserirCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInsereClienteActionPerformed

    private void txtCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCCMouseClicked
        // TODO add your handling code here:
        txtCC.setText("");
    }//GEN-LAST:event_txtCCMouseClicked

    private void txtNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeMouseClicked
        // TODO add your handling code here:
        txtNome.setText("");
    }//GEN-LAST:event_txtNomeMouseClicked

    private void txtTelemovelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelemovelMouseClicked
        // TODO add your handling code here:
        txtTelemovel.setText("");
    }//GEN-LAST:event_txtTelemovelMouseClicked

    private void txtMoradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMoradaMouseClicked
        // TODO add your handling code here:
        txtMorada.setText("");
    }//GEN-LAST:event_txtMoradaMouseClicked

    private boolean VerificaStringSeHaNumeros(String text) {
        String s = "";
        s = text;
        char arr[] = s.toCharArray();
        if(text == null) {
            return false;
        } else {
            for(char c: arr) {
                if(Character.isDigit(c)) {
                    return true;
                } else if((c >= 33 && c <= 47) | (c >= 58 && c <= 64)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean VerificarString(String text) {
        String s = "";
        s = text;
        char arr[] = s.toCharArray();
        if(text == null) {
            return false;
        } else {
            for(char c: arr) {
                if(!Character.isDigit(c)) {
                    return true;
                } else if((c >= 33 && c <= 47) | (c >= 58 && c <= 64)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
//    private String sanitizeString(String text) {
//        String s = "";
//        s = text;
//        String reultado = "";
//        char arr[] = s.toCharArray();
//        if (s == null || s.trim().isEmpty()) {
//            return s;
//        } else {
//            for(int i = 0; i < arr.length; i++) {
//                if(arr[i] == 59) {
//                    JOptionPane.showMessageDialog(rootPane, "Por favor nao insire characters especiais.", "Erro", JOptionPane.WARNING_MESSAGE);
//                } else {
//                    reultado = reultado + arr[i];
//                }
//            }
//        }
//        return reultado;
//    }
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameInserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameInserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameInserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameInserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameInserirCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsereCliente;
    private javax.swing.JTextField txtCC;
    private javax.swing.JTextField txtMorada;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelemovel;
    // End of variables declaration//GEN-END:variables
}
