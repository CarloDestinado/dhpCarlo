/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnector;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class AddUser extends javax.swing.JFrame {

    /**
     * Creates new form AddUser2
     */
    public AddUser() {
        initComponents();
    }
    
    
     public static String mail,usname;
   
    public boolean duplicateCheck()
    {
        System.out.println("\n1");

        dbConnector dbc = new dbConnector();
        String e = email.getText().trim();
        String us = Username.getText().trim();
        
        try
        {
            System.out.println("\n2");

            String query = "SELECT * FROM tbl_user WHERE u_username='"+ us +"'OR u_email='"+ e +"'";
            ResultSet resultSet = dbc.getData(query);
            System.out.println("\n2.3");

            if(resultSet.next())//here is problme
            {
                System.out.println("\n3");

                mail = resultSet.getString("u_email");
                if(mail.equals(e))
                {
                    JOptionPane.showMessageDialog(null, "Email is Already Used");
                    email.setText("");
                }
                
                usname = resultSet.getString("u_username");
                if(usname.equals(us))
                {
                    System.out.println("\n4");

                    JOptionPane.showMessageDialog(null, "Username is Already Used");
                    Username.setText("");
                }
                System.out.println("\nt");

                return true;
            }else
            {
                System.out.println("\nf1");

                return false;
            }
        }catch(SQLException ex)
        {
            System.out.println("\nf2");

            System.out.println(""+ex);
            return false;
        }
    }
    
    
    
    public boolean updateCheck()
    {
        dbConnector dbc = new dbConnector();
        String u = UID.getText().trim();
        String e = email.getText().trim();
        String us = Username.getText().trim();
        
        try
        {
            String query = "SELECT * FROM tbl_user WHERE (u_username='"+ us +"'OR u_phone='"+ e +"') AND u_id != '"+u+"'";
            ResultSet resultSet = dbc.getData(query);   
            if(resultSet.next())
            {
                mail = resultSet.getString("u_phone");
                if(mail.equals(e))
                {
                    JOptionPane.showMessageDialog(null, "Phone Number is Already Used");
                    email.setText("");
                }
                
                usname = resultSet.getString("u_username");
                if(usname.equals(us))
                {
                    JOptionPane.showMessageDialog(null, "Username is Already Used");
                    Username.setText("");
                }
                return true;
            }else
            {
                return false;
            }
        }catch(SQLException ex)
        {
            System.out.println(""+ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        Fname = new javax.swing.JTextField();
        age = new javax.swing.JLabel();
        Lname = new javax.swing.JTextField();
        address = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        dob = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        dob1 = new javax.swing.JLabel();
        Cpassword = new javax.swing.JPasswordField();
        phone = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        stats = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        stats1 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        name1 = new javax.swing.JLabel();
        UID = new javax.swing.JTextField();
        name2 = new javax.swing.JLabel();
        Age1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 100));

        name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name.setText("FIRSTNAME");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 80, 30));

        Fname.setBackground(new java.awt.Color(204, 204, 204));
        Fname.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FnameActionPerformed(evt);
            }
        });
        jPanel1.add(Fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 210, 30));

        age.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        age.setText("LASTNAME");
        jPanel1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 80, 30));

        Lname.setBackground(new java.awt.Color(204, 204, 204));
        Lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LnameActionPerformed(evt);
            }
        });
        jPanel1.add(Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 210, 30));

        address.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        address.setText("USERNAME");
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 80, 30));

        Username.setBackground(new java.awt.Color(204, 204, 204));
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 210, 30));

        dob.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dob.setText("PASSWORD");
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 80, 30));

        password.setBackground(new java.awt.Color(204, 204, 204));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 210, 30));

        dob1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dob1.setText("CONFIRM PASSWORD");
        jPanel1.add(dob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 150, 30));

        Cpassword.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(Cpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 210, 30));

        phone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phone.setText("EMAIL");
        jPanel1.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 50, 30));

        email.setBackground(new java.awt.Color(204, 204, 204));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 210, 30));

        stats.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stats.setText("TYPE");
        jPanel1.add(stats, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 40, 30));

        type.setBackground(new java.awt.Color(51, 153, 255));
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Patient", "Medical Staff" }));
        jPanel1.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 210, 30));

        add.setBackground(new java.awt.Color(204, 204, 204));
        add.setText("ADD USER");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 110, 30));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 110, 30));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 110, 30));

        update.setBackground(new java.awt.Color(204, 204, 204));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 110, 30));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setText("CLEAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 110, 30));

        stats1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stats1.setText("STATUS");
        jPanel1.add(stats1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 60, 30));

        status.setBackground(new java.awt.Color(51, 153, 255));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 210, 30));

        name1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name1.setText("USER ID");
        jPanel1.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 60, 30));

        UID.setEditable(false);
        UID.setBackground(new java.awt.Color(204, 204, 204));
        UID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        UID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UIDActionPerformed(evt);
            }
        });
        jPanel1.add(UID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 210, 30));

        name2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name2.setText("AGE");
        jPanel1.add(name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 40, 30));

        Age1.setBackground(new java.awt.Color(204, 204, 204));
        Age1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(Age1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 210, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/log in bg.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 450, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FnameActionPerformed

    private void LnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LnameActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        dbConnector dbc = new dbConnector();
        String a = Age1.getText().trim();
        String fn = Fname.getText().trim();
        String ln = Lname.getText().trim();
        String uname = Username.getText().trim();
        String pass = new String(password.getPassword()).trim();
        String Cpass = new String(Cpassword.getPassword()).trim();
        String e = email.getText().trim();
        String at = type.getSelectedItem().toString().trim();
        String s = status.getSelectedItem().toString().trim();
        
       
        if(a.isEmpty() ||uname.isEmpty() || pass.isEmpty() || Cpass.isEmpty() || ln.isEmpty() || fn.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Fill All Boxes");

        }else if(!pass.equals(Cpass))
        {
            JOptionPane.showMessageDialog(null, "Password Does Not Match");
            //System.out.println("Password ["+password+"] Length: "+password.length());
            //System.out.println("Confirm Password ["+Cpassword+"] Length: "+Cpassword.length());
        }else if (!isValidEmail(e)) {
            JOptionPane.showMessageDialog(null, "Invalid email format!");
        }else if(duplicateCheck())
        {
            System.out.println("Duplicate Exists");
        }else
        { try
            {
                String npass = passwordHasher.hashPassword(password.getText());

                dbc.insertData("INSERT INTO tbl_user (u_age, u_fname, u_lname, u_username, u_type, u_password, u_email, u_status) "
                + "VALUES ('"+a+"','" + fn + "', '" + ln + "', '" + uname + "', '"+at+"','" + npass + "', '" + e + "', '"+s+"')");
                JOptionPane.showMessageDialog(null, "Registered succesfully!");
                AdminDashboard rd = new AdminDashboard();
                rd.setVisible(true);
                this.dispose();
            } catch(NoSuchAlgorithmException ex) 
            {
                System.out.println("" + ex);
            }
        }
        
    }//GEN-LAST:event_addMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminDashboard d = new AdminDashboard();
        d.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        dbConnector dbc = new dbConnector();
        String a = Age1.getText().trim();
        String u = UID.getText().trim();
        String fn = Fname.getText().trim();
        String ln = Lname.getText().trim();
        String uname = Username.getText().trim();
        String pass = new String(password.getPassword()).trim();
        String Cpass = new String(Cpassword.getPassword()).trim();
        String e = email.getText().trim();
        String at = type.getSelectedItem().toString().trim();
        String s = status.getSelectedItem().toString().trim();

        if(uname.isEmpty() || pass.isEmpty() || Cpass.isEmpty() || ln.isEmpty() || fn.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Fill All Boxes");

        }else if(!pass.equals(Cpass))
        {
            JOptionPane.showMessageDialog(null, "Password Does Not Match");
        }else if (!isValidEmail(e)) {
            JOptionPane.showMessageDialog(null, "Invalid email format!");
        }else if(updateCheck())
        {
            System.out.println("Duplicate Exists");
        }else
        {
            try {
                String npass = passwordHasher.hashPassword(password.getText());

                dbc.updateData("UPDATE tbl_user SET u_age = '"+a+"', u_fname = '"+fn+"', u_lname = '"+ln+"', u_username = '"+uname+"',"
                    + " u_password = '"+npass+"', u_email = '"+e+"', u_type = '"+at+"', u_status = '"+s+"' WHERE u_id = '"+u+"'");
                AdminDashboard ad = new AdminDashboard();
                ad.setVisible(true);
                this.dispose();
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("" + ex);
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void UIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UIDActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Age1;
    public javax.swing.JPasswordField Cpassword;
    public javax.swing.JTextField Fname;
    public javax.swing.JTextField Lname;
    public javax.swing.JTextField UID;
    public javax.swing.JTextField Username;
    public javax.swing.JButton add;
    private javax.swing.JLabel address;
    private javax.swing.JLabel age;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel dob1;
    public javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    public javax.swing.JPasswordField password;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel stats;
    private javax.swing.JLabel stats1;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JComboBox<String> type;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    private boolean isValidEmail(String text) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    return matcher.matches();

    }

}
