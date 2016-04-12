/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto;
import modeltest.Store;

/**
 *
 * @author Ian W
 */
public class NewSaleManager extends javax.swing.JFrame {

    static Store store;
    
    /**
     * Creates new form NewSaleManager
     */
    public NewSaleManager(Store store) {
        initComponents();
        this.store = store;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newSale = new javax.swing.JButton();
        shutdownButton = new javax.swing.JButton();
        userButton = new javax.swing.JButton();
        newSale1 = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newSale.setText("New Sale");
        newSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSaleActionPerformed(evt);
            }
        });

        shutdownButton.setText("Shutdown System");
        shutdownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shutdownButtonActionPerformed(evt);
            }
        });

        userButton.setText("Manage Users");
        userButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonActionPerformed(evt);
            }
        });

        newSale1.setText("New Rental");
        newSale1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSale1ActionPerformed(evt);
            }
        });

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        returnButton.setText("New Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newSale, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shutdownButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newSale1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newSale, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(logOutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shutdownButton)
                    .addComponent(userButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSaleActionPerformed
        Orders f = new Orders(store);
        f.setUserTextField();
        f.pack();
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_newSaleActionPerformed

    private void shutdownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shutdownButtonActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_shutdownButtonActionPerformed

    private void newSale1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSale1ActionPerformed
        rOrders f = new rOrders(store);
        f.pack();
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_newSale1ActionPerformed

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userButtonActionPerformed
        // TODO add your handling code here:
        ManageUsers f = new ManageUsers(store);
        f.pack();
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_userButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        // TODO add your handling code here:
        Login f = new Login(store);
        f.pack();
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        returnOrders f = new returnOrders(store);
        f.setUserTextField();
        f.pack();
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NewSaleManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSaleManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSaleManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSaleManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewSaleManager(store).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton newSale;
    private javax.swing.JButton newSale1;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton shutdownButton;
    private javax.swing.JButton userButton;
    // End of variables declaration//GEN-END:variables
}
