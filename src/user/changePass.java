/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.dbConnector;
import config.passwordHasher;
import config.session;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class changePass extends javax.swing.JFrame {

    /**
     * Creates new form changePass
     */
    public changePass() {
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        name1 = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        oldPassword = new javax.swing.JPasswordField();
        name2 = new javax.swing.JLabel();
        newPassword = new javax.swing.JPasswordField();
        name3 = new javax.swing.JLabel();
        Cpassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 100, 30));

        name1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name1.setText("ENTER OLD PASS");
        jPanel1.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 110, 30));

        add1.setBackground(new java.awt.Color(204, 204, 204));
        add1.setText("Confirm");
        add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add1MouseClicked(evt);
            }
        });
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel1.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 100, 30));

        oldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(oldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 210, 30));

        name2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name2.setText("ENTER NEW PASS");
        jPanel1.add(name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 110, 30));

        newPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(newPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 210, 30));

        name3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name3.setText("RE-ENTER NEW PASS");
        jPanel1.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 130, 30));

        Cpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(Cpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 210, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("CHANGE PASSWORD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bg change pass.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        accountDetails m = new accountDetails();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add1MouseClicked

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        String passw = new String(newPassword.getPassword()).trim();
        String Cpassw = new String(Cpassword.getPassword()).trim();
        


        if(passw.isEmpty() || Cpassw.isEmpty() || oldPassword.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Fill all Boxes");
        }else if(passw.length() <= 7)
        {
            JOptionPane.showMessageDialog(null, "Password Must be Exactly 8 Characters Long");
        }else if(!passw.equals(Cpassw))
        {
            JOptionPane.showMessageDialog(null, "Password does not match");
        }else if(passw.equals(Cpassw))
        {
            try
            {
                dbConnector dbc = new dbConnector();
                session sess = session.getInstance();


                String query = "SELECT * FROM tbl_user WHERE u_id='"+ sess.getUid() +"'";
                ResultSet rs = dbc .getData(query);
                if(rs.next())
                {
                    String olddbPassword = rs.getString("u_password");  
                    String oldhash = passwordHasher.hashPassword(oldPassword.getText());
                    System.out.println(""+olddbPassword);
                    System.out.println("" + oldhash);


                    if(olddbPassword.equals(oldhash))
                    {

                        String npass = passwordHasher.hashPassword(newPassword.getText());
                        dbc.updateData("UPDATE tbl_user SET u_password = '"+npass+"' WHERE u_id = '"+ sess.getUid() +"'");
                        JOptionPane.showMessageDialog(null, "Updated Succesfully");
                        accountDetails ad = new accountDetails();
                        ad.setVisible(true);
                        this.dispose();

                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Old Password is Incorrect");
                    }
                }
            } catch(SQLException | NoSuchAlgorithmException ex)
            {
                System.out.println(""+ex);
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Unknown Error Occured");
        }
        
    }//GEN-LAST:event_add1ActionPerformed

    private void oldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldPasswordActionPerformed

    private void newPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPasswordActionPerformed

    private void CpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CpasswordActionPerformed

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
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Cpassword;
    public javax.swing.JButton add1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JPasswordField oldPassword;
    // End of variables declaration//GEN-END:variables
}
