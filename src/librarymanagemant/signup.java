/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymanagemant;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class signup extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(signup.class.getName());

    public signup() {
        initComponents();
    }




    // Replace with your actual database URL, username, and password
 

    public void addStaff(String username, String email, String plainPassword, String fullname, String contact) {
        String sql = "INSERT INTO staff (username, email, password, fullname, contact) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Binding the parameters to the ? placeholders
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, plainPassword); // Reminder: Hash this in production!
            pstmt.setString(4, fullname);
            pstmt.setString(5, contact);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Staff member added successfully!");
            }

        } catch (SQLException e) {
            // This will catch duplicate usernames or emails (Primary Key/Unique violations)
            System.err.println("Error adding staff: " + e.getMessage());
        }
    }
    public boolean isUsernameExists(String username) {
    boolean exists = false;
    String sql = "SELECT username FROM staff WHERE username = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, username);
        
        // Execute the query and check if there is a result
        try (java.sql.ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                exists = true; // The username was found
            }
        }
    } catch (SQLException e) {
        System.err.println("Database error: " + e.getMessage());
    }
    return exists;
}
public String[] getStaffDetails(String username) {
    String sql = "SELECT * FROM staff WHERE username = ?";
    String[] details = null;

    try (Connection conn =DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, username);
        try (java.sql.ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                // Store the database results in a String array
                details = new String[4]; 
                details[0] = rs.getString("email");
                details[1] = rs.getString("password");
                details[2] = rs.getString("fullname");
                details[3] = rs.getString("contact");
            }
        }
    } catch (SQLException e) {
        System.err.println("Search Error: " + e.getMessage());
    }
    return details; // Returns null if no user is found
}
public void updateStaff(String username, String email, String fullname, String contact,String Password) {
    String sql = "UPDATE staff SET email = ?, fullname = ?, contact = ? ,password=? WHERE username = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, email);
        pstmt.setString(2, fullname);
        pstmt.setString(3, contact);
         pstmt.setString(4, Password);
        
        pstmt.setString(5, username); // The WHERE clause

        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Staff record updated successfully!");
        } else {
            System.out.println("No staff found with username: " + username);
        }

    } catch (SQLException e) {
        System.err.println("Update Error: " + e.getMessage());
    }
}
public boolean deleteStaff(String username) {
    String sql = "DELETE FROM staff WHERE username = ?";
    boolean isDeleted = false;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, username);

        int rowsDeleted = pstmt.executeUpdate();
        if (rowsDeleted > 0) {
            isDeleted = true;
        }

    } catch (SQLException e) {
        System.err.println("Delete Error: " + e.getMessage());
    }
    return isDeleted;
}
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        contact = new app.bolivia.swing.JCTextField();
        username = new app.bolivia.swing.JCTextField();
        email = new app.bolivia.swing.JCTextField();
        password = new app.bolivia.swing.JCTextField();
        fullname = new app.bolivia.swing.JCTextField();
        delet = new rojerusan.RSMaterialButtonCircle();
        Add = new rojerusan.RSMaterialButtonCircle();
        update = new rojerusan.RSMaterialButtonCircle();
        search = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Linux Libertine Display O", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Group-5");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 220, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/icons/signup-library-icon.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 900, 710));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 830));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jLabel3.setText("Contact");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 220, 70));

        jLabel4.setBackground(new java.awt.Color(255, 51, 51));
        jLabel4.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add staff");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 220, 70));

        jLabel5.setBackground(new java.awt.Color(255, 51, 51));
        jLabel5.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/icons/icons8_Account_50px.png"))); // NOI18N
        jLabel5.setText("User Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 220, 70));

        jLabel6.setBackground(new java.awt.Color(255, 51, 51));
        jLabel6.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jLabel6.setText("Email");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 220, 70));

        jLabel7.setBackground(new java.awt.Color(255, 51, 51));
        jLabel7.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/icons/icons8_Forgot_Password_50px_4.png"))); // NOI18N
        jLabel7.setText("password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 220, 70));

        jLabel8.setBackground(new java.awt.Color(255, 51, 51));
        jLabel8.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/icons/icons8_Account_50px.png"))); // NOI18N
        jLabel8.setText("Full Name");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 220, 70));

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Admin" }));
        jPanel2.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 290, 50));

        contact.setBackground(new java.awt.Color(102, 102, 255));
        contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        contact.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        contact.setPlaceholder("enter user name .....");
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 370, 50));

        username.setBackground(new java.awt.Color(102, 102, 255));
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        username.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        username.setPlaceholder("enter user name .....");
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 370, 50));

        email.setBackground(new java.awt.Color(102, 102, 255));
        email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        email.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        email.setPlaceholder("enter user name .....");
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 370, 50));

        password.setBackground(new java.awt.Color(102, 102, 255));
        password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        password.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        password.setPlaceholder("enter user name .....");
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 370, 50));

        fullname.setBackground(new java.awt.Color(102, 102, 255));
        fullname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        fullname.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        fullname.setPlaceholder("enter user name .....");
        jPanel2.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 370, 50));

        delet.setBackground(new java.awt.Color(255, 51, 0));
        delet.setText("Delete");
        delet.addActionListener(this::deletActionPerformed);
        jPanel2.add(delet, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 730, 230, -1));

        Add.setBackground(new java.awt.Color(153, 153, 255));
        Add.setText("Add staff");
        Add.addActionListener(this::AddActionPerformed);
        jPanel2.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 220, -1));

        update.setBackground(new java.awt.Color(102, 204, 0));
        update.setText("Update staff");
        update.addActionListener(this::updateActionPerformed);
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, 230, -1));

        search.setBackground(new java.awt.Color(255, 255, 0));
        search.setForeground(new java.awt.Color(0, 0, 0));
        search.setText("serch by username");
        search.addActionListener(this::searchActionPerformed);
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 310, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 620, 830));

        setSize(new java.awt.Dimension(1523, 865));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletActionPerformed
       String user = username.getText();

    if (user.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a username to delete.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete " + user + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
      
        if (deleteStaff(user)) {
            JOptionPane.showMessageDialog(this, "Staff Deleted.");
            // Clear fields after deletion
           clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "User not found.");
        }
    }
    }//GEN-LAST:event_deletActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
      String user = username.getText().trim();
    
   

    // 1. Check for empty field first
    if (user.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username cannot be empty!");
        return;
    }

    // 2. Check if username exists
    if (isUsernameExists(user)) {
        JOptionPane.showMessageDialog(this, "This username is already taken. Please choose another.");
    } else {
        // 3. Proceed to add the staff if it doesn't exist
        String mail = email.getText();
        String pass = password.getText();
        String name = fullname.getText();
        String phone = contact.getText();
        
       addStaff(user, mail, pass, name, phone);
        JOptionPane.showMessageDialog(this, "Staff added successfully!");
         clearFields();
    }
    }//GEN-LAST:event_AddActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
     // Get the current (edited) values from the fields
    String user = username.getText(); 
    String mail = email.getText();
    String name = fullname.getText();
    String phone = contact.getText();
    String Password = password.getText();

    // Call the update function we built previously
    updateStaff(user, mail, name, phone,Password);
    
    JOptionPane.showMessageDialog(this, "Staff updated successfully!");
    
    // Re-enable username field for the next operation
    username.setEditable(true);
    clearFields();
    }//GEN-LAST:event_updateActionPerformed
private void clearFields() {
    username.setText("");
    email.setText("");
    password.setText("");
    fullname.setText("");
    contact.setText("");
    username.setEditable(true);
}
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
      String user = username.getText().trim();

    if (user.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a username to search.");
        return;
    }

  
    String[] data = getStaffDetails(user);

    if (data != null) {
        // Populate the text fields with the data found
        email.setText(data[0]);
        password.setText(data[1]);
        fullname.setText(data[2]);
        contact.setText(data[3]);
        
        // Optional: Disable username field so they don't change the ID while editing
        username.setEditable(false); 
    } else {
        JOptionPane.showMessageDialog(this, "Staff member not found.");
    }
    }//GEN-LAST:event_searchActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new signup().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Add;
    private app.bolivia.swing.JCTextField contact;
    private rojerusan.RSMaterialButtonCircle delet;
    private app.bolivia.swing.JCTextField email;
    private app.bolivia.swing.JCTextField fullname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private app.bolivia.swing.JCTextField password;
    private javax.swing.JComboBox<String> role;
    private rojerusan.RSMaterialButtonCircle search;
    private rojerusan.RSMaterialButtonCircle update;
    private app.bolivia.swing.JCTextField username;
    // End of variables declaration//GEN-END:variables
}
