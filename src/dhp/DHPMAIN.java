 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhp;

import user.UserDashboard;
import admin.AdminDashboard;
import config.dbConnector;
import config.passwordHasher;
import config.session;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SCC-COLLEGE
 */
public class DHPMAIN extends javax.swing.JFrame {

    /**
     * Creates new form DHPMAIN
     */
    public DHPMAIN() {
        initComponents();
    }
    
        static String status;
        static String type;

    
    public static boolean logAcc(String username, String password)
    {
        dbConnector connector = new dbConnector();
        try
        {
            String query = "SELECT * FROM tbl_user WHERE u_username='"+ username +"'AND u_password='"+ password +"'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
                session sess = session.getInstance();

                sess.setUid(resultSet.getInt("u_id"));
                sess.setFname(resultSet.getString("u_fname"));
                sess.setLname(resultSet.getString("u_lname"));
                sess.setUsername(resultSet.getString("u_username"));
                sess.setEmail(resultSet.getString("u_email"));               
                sess.setType(resultSet.getString("u_type"));

                

                return true;
            }else
            {
                return false;
            }
        }catch(SQLException ex)
        {
            return false;
        }
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ADUSERT = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        right = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton3.setBackground(new java.awt.Color(51, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("LIST IN CHECKUP");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/3D Hospital Emergency Healthcare Illustration.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        ADUSERT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ADUSERT.setText(" Username");
        jPanel1.add(ADUSERT, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 130, 40));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 320, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 130, 40));

        jButton5.setBackground(new java.awt.Color(51, 153, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("SIGN UP");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 90, 30));

        right.setBackground(new java.awt.Color(51, 153, 255));
        right.setToolTipText("");
        right.setPreferredSize(new java.awt.Dimension(400, 500));
        right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        right.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 125, -1, -1));
        right.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DIAGNOSIS HISTORY PROFILE");
        right.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 350, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/log in bg.png"))); // NOI18N
        right.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 280, 480, 410));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-medical-records-100.png"))); // NOI18N
        right.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 100, 120));

        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 356, 590));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Do you have an account?");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 200, 30));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 320, 40));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 153, 255));
        jButton6.setText("LOGIN");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AdminDashboard rd = new AdminDashboard();
        rd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                Signup fm = new Signup();
                   fm.setVisible(true);
                   this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        Signup fm = new Signup();
        fm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String uname = username.getText().trim();
         String pass = new String(password.getPassword()).trim();
        
     try 
            {
                String npass = passwordHasher.hashPassword(password.getText());
        if(pass.isEmpty() || uname.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Fill all Boxes");
        }else if(logAcc(uname,npass))
        {
        if(!status.equals("Active"))
        {
            JOptionPane.showMessageDialog(null, "Inactive Account, Contact the Admin");
        }else
        {

            if(type.equals("Admin"))
            {
                JOptionPane.showMessageDialog(null, "Login Succesfully");
                AdminDashboard ad = new AdminDashboard();
                ad.setVisible(true);
                this.dispose();
            }else if(type.equals("Patient"))
            {
                JOptionPane.showMessageDialog(null, "Login Succesfully");
                UserDashboard ed = new UserDashboard();
                ed.setVisible(true);
                this.dispose();
            }else if(type.equals("Medical Staff"))
            {
                JOptionPane.showMessageDialog(null, "Login Succesfully");
                UserDashboard ed = new UserDashboard();
                ed.setVisible(true);
                this.dispose();
            }else if(!type.equals("User") || !type.equals("Pending") || !type.equals("Admin"))
            {
                JOptionPane.showMessageDialog(null, "Unknown Account Type, Contact the Admin");
            }
        }
        }else
        {
            JOptionPane.showMessageDialog(null, "Invalid Account");
        }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("" + ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(DHPMAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DHPMAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DHPMAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DHPMAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DHPMAIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADUSERT;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JPanel right;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
