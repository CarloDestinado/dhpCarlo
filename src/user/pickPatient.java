/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;


import admin.*;
import config.session;
import config.dbConnector;
import java.awt.Color;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import dhp.DHPMAIN;



public class pickPatient extends javax.swing.JFrame {

    public pickPatient() {
        initComponents();
         displayData();
    }   
    
    
    private JComboBox<String> type;
    
        Color navcolor = new Color(51,255,255);
        Color hovercolor = new Color(204,255,204);
    
     public void displayData(){
            try{
                dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT u_id, u_fname, u_lname, u_username, u_email, u_type, u_status FROM tbl_user");
                user_table.setModel(DbUtils.resultSetToTableModel(rs));
                 rs.close();
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());

            }


        }


            DefaultTableModel model = new DefaultTableModel();

             public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();


                if (row == -1 || column == -1) {
                    return; 
                }

                updateDatabase(row, column);
            }
             session sess = session.getInstance();

        String[] columnNames = {"u_id", "u_email", "u_type", "u_username","u_password", "u_status"};
        model.setColumnIdentifiers(columnNames); 
        model.setRowCount(0);

        String sql = "SELECT u_id, u_email, u_type, u_username, u_password, u_status FROM tbl_user WHERE u_id != '"+sess.getUid()+"';";

        try (Connection connect = new dbConnector().getConnection();
             PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("u_id"),
                    rs.getString("email"),
                    rs.getString("type"),
                    rs.getString("username"),
                    rs.getString("pass"),
                    rs.getString("status")
                };
                model.addRow(row); 
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    
     private void updateDatabase(int row, int column) {
    try (Connection connect = (Connection) new dbConnector().getConnection()) {
        String columnName = user_table.getColumnName(column); 
        String newValue = user_table.getValueAt(row, column).toString(); 
        int userId = Integer.parseInt(user_table.getValueAt(row, 0).toString());

        String sql = "UPDATE tbl_user SET " + columnName + " = ? WHERE u_id = ?";
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setString(1, newValue);
            pst.setInt(2, userId);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Database Updated Successfully!");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
    }
}


      void addUser() {
   
     CreateUser createuserform = new CreateUser();
     createuserform.setVisible(true);
}
   public boolean addUser(String firstname, String lastname, String email, String type, String username, String password, String status) {
    Connection con = null;
    PreparedStatement pst = null;

    try {
        // Get database connection
        con = new dbConnector().getConnection();

        // SQL query to insert user data
        String query = "INSERT INTO tbl_user (u_fname, u_lname, u_username, u_email, u_password, u_status, u_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        pst = con.prepareStatement(query);

        // Set values correctly in PreparedStatement
        pst.setString(1, firstname);
        pst.setString(2, lastname);
        pst.setString(3, username);
        pst.setString(4, email); // Fixed order: email should be here
        pst.setString(5, password);
        pst.setString(6, status);
        pst.setString(7, type);  // Fixed order: type should be last

        // Execute update and check if insertion was successful
        int rowsInserted = pst.executeUpdate();
        return rowsInserted > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        // Close resources in finally block
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

      public boolean updateUser(String firstname, String lastname, String email, String type, String username, String password, String status) {
    try {
        
        Connection con = new dbConnector().getConnection();
        String query = "UPDATE tbl_user SET u_fname=?, u_lname=?, u_email=?, u_type=?, u_password=?, u_status=? WHERE u_username=?";
        PreparedStatement pst = con.prepareStatement(query);
       pst.setString(1, firstname);
       pst.setString(2, lastname);
       pst.setString(3, username);
       pst.setString(4, type);
       pst.setString(5, email);
       pst.setString(6, password);
       pst.setString(7, status);

        int rowsUpdated = pst.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

        private void loadUsersData() {
    DefaultTableModel model = (DefaultTableModel) user_table.getModel();
    model.setRowCount(0); // Clear the table before reloading

    String sql = "SELECT u_id, u_fname, u_lname, u_username, u_email, u_status FROM tbl_user";

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhpapp", "root", "");
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("u_id"),
                rs.getString("u_fname"),
                rs.getString("u_lname"),
                rs.getString("u_username"),
                rs.getString("u_email"),
                rs.getString("u_status")
            });
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading user data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}

        private void deleteUser() {
           
            session sess = session.getInstance();  // Logged-in admin
    int selectedRow = user_table.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a user to delete.");
        return;
    }

    int userId = (int) user_table.getValueAt(selectedRow, 0);
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        String sql = "DELETE FROM tbl_user WHERE u_id=?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhpapp", "root", "");
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, userId);
            int affectedRows = pst.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "User Deleted Successfully!");

                // ✅ Logging the deletion action
                String logQuery = "INSERT INTO tbl_log (u_id, u_username, u_type, log_status, log_description) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement logPst = con.prepareStatement(logQuery)) {
                    logPst.setInt(1, sess.getUid()); // Admin ID from session
                    logPst.setString(2, sess.getUsername()); // Admin username
                    logPst.setString(3, sess.getType()); // Admin type, e.g., "Admin"
                    logPst.setString(4, "Active"); // Status of the log
                    logPst.setString(5, "Deleted user account with ID: " + userId); // Description
                    logPst.executeUpdate();
                } catch (SQLException logEx) {
                    JOptionPane.showMessageDialog(this, "Log Error: " + logEx.getMessage(), "Log Error", JOptionPane.ERROR_MESSAGE);
                }

                loadUsersData();  // Ensure this method exists to reload the table or data

            } else {
                JOptionPane.showMessageDialog(this, "No user found to delete.", "Deletion Failed", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

         private String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
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

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        update.setText("Select");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cancel");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 450));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(user_table);

        jPanel8.add(jScrollPane1);

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 500, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
     addDiagnosis ad = new addDiagnosis();
     ad.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         
    }//GEN-LAST:event_formWindowActivated

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        int selectedRow = user_table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to edit.", "Selection Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String username = user_table.getValueAt(selectedRow, user_table.getColumn("u_username").getModelIndex()).toString();

        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selected user has no username.", "Selection Error", JOptionPane.ERROR_MESSAGE);
            return;

        }
    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int rowIndex = user_table.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select a User!");
        } else {
            try {
                dbConnector dbc = new dbConnector();
                TableModel tbl = user_table.getModel();

                String userId = tbl.getValueAt(rowIndex, 0).toString();

                // Fixed: Correct ID field name
                String query = "SELECT * FROM tbl_user WHERE u_id = ? AND u_type != 'Medical Staff' AND u_type != 'Admin'";

                PreparedStatement pst = dbc.getConnection().prepareStatement(query);
                pst.setString(1, userId);  // Bind the userId to the query
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    addDiagnosis ad = new addDiagnosis();

                    ad.p_name.setText(rs.getString("u_fname")); 
                    ad.p_lname.setText(rs.getString("u_lname")); 

                    ad.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Selected user is not eligible (Admin or Medical Staff).");
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_updateActionPerformed
    
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
            java.util.logging.Logger.getLogger(pickPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pickPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pickPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pickPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pickPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton update;
    private javax.swing.JTable user_table;
    // End of variables declaration//GEN-END:variables
}
