/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeltest.Register;
import modeltest.RentalLineItem;
import modeltest.Store;
import static proto.Orders.store;

/**
 *
 * @author Shane
 */
public class rOrders extends javax.swing.JFrame {
    static Store store;
    Register reg;
    RentalLineItem line;
    /**
     * Creates new form Orders
     * @param store
     */
    public rOrders(Store store) {
        initComponents();
        rOrders.store = store;
        this.reg = store.getReg();
        store.addRental();
        createTransID();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idTextField = new javax.swing.JTextField();
        qtyTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JTextArea();
        idLabel = new javax.swing.JLabel();
        qtyLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        totalTextField = new javax.swing.JTextField();
        userLabel = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        qtyLabel1 = new javax.swing.JLabel();
        dayTextField = new javax.swing.JTextField();
        returnButton = new javax.swing.JButton();
        transIDTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("addOrder");

        qtyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyTextFieldActionPerformed(evt);
            }
        });

        orderList.setEditable(false);
        orderList.setColumns(20);
        orderList.setRows(5);
        jScrollPane1.setViewportView(orderList);

        idLabel.setText("ID");

        qtyLabel.setText("QTY");

        addButton.setText("Add Order");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit Order");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        totalLabel.setText("Total:");

        totalTextField.setEditable(false);

        userLabel.setText("Cashier ID:");

        userTextField.setEditable(false);

        qtyLabel1.setText("DAYS");

        dayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayTextFieldActionPerformed(evt);
            }
        });

        returnButton.setText("Return Rental");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        transIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transIDTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("If Return,");

        jLabel2.setText("Trans ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(totalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(submitButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(returnButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qtyLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(qtyLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dayTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qtyTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(idLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(transIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalLabel)
                            .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(transIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnButton)
                        .addGap(15, 15, 15))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createTransID() {
        Connection conn = store.getConn();
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT COUNT(*) AS amount FROM scrum.transactions";
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            int count = rs.getInt("amount");
            count++;
            sql = "INSERT INTO scrum.transactions VALUES (" + count + ", " + reg.getUser() + ", 0, CURRENT_TIMESTAMP, NULL)";
            s.executeUpdate(sql);
            reg.setRentalTransID(count);
        } catch (SQLException ex) {
            Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        Total f = new Total(store);
        f.setTotalTextField(totalTextField.getText());
        f.setOrderTextArea(orderList.getText());
        f.pack();
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_submitButtonActionPerformed

    public void setUserTextField() {
        userTextField.setText(reg.getUserName());
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            int qty = Integer.parseInt(qtyTextField.getText());
            int days = Integer.parseInt(dayTextField.getText());
            line = reg.enterRItem(idTextField.getText(), qty, days, store.getConn());
        } catch (SQLException ex) {
            Logger.getLogger(rOrders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(line.getDesc() == null) {
            JOptionPane.showMessageDialog(null, "Invalid Item ID");
        }
        else {
            orderList.append(line.getDesc() + "(x" + qtyTextField.getText() + ")\t" + line.getDays()+"\t"+String.format("%5.2f", line.getSubtotal()) + "\r\n");
            totalTextField.setText(String.format("%5.2f", reg.getRTotal()));
        }
        idTextField.setText("");
        qtyTextField.setText("");
        dayTextField.setText("");
    }//GEN-LAST:event_addButtonActionPerformed

    private void dayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayTextFieldActionPerformed

    private void qtyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyTextFieldActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        try {
            String tID = transIDTextField.getText();
            reg.returnItems(tID);
            reg.endSale();
            NewSaleManager f = new NewSaleManager(store);
            f.pack();
            f.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(rOrders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_returnButtonActionPerformed

    private void transIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transIDTextFieldActionPerformed
                                          

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
            java.util.logging.Logger.getLogger(rOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rOrders(store).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField dayTextField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea orderList;
    private javax.swing.JLabel qtyLabel;
    private javax.swing.JLabel qtyLabel1;
    private javax.swing.JTextField qtyTextField;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTextField;
    private javax.swing.JTextField transIDTextField;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
