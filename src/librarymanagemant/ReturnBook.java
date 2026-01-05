/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymanagemant;


import app.bolivia.swing.JCTextField;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ReturnBook extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReturnBook.class.getName());

    public ReturnBook() {
        initComponents();
     
    }
    public boolean searchBook(int id, JTextField nameField, JTextField authorField, JTextField qtyField) {
    boolean found = false;
    String sql = "SELECT * FROM book WHERE bookid = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        
        try (java.sql.ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                // Fill the text fields with data from the database
                bookname.setText(rs.getString("name"));
                
                found = true;
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Search Error: " + e.getMessage());
    }
    return found;
}
    public void searcsud() {
    String sId = studid.getText().trim();
    
    // SQL JOIN: Connects student, borrowed_books, and book tables
    String sql = "SELECT s.name AS student_name, bk.name AS book_name, b.bookid, b.borrow_id " +
                 "FROM borrowed_books b " +
                 "JOIN student s ON b.student_id = s.student_id " +
                 "JOIN book bk ON b.bookid = bk.bookid " +
                 "WHERE b.student_id = ? AND b.status = 'Issued' " +
                 "ORDER BY b.borrow_id DESC LIMIT 1";

    if (!sId.isEmpty()) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, sId);
            java.sql.ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Fill the UI fields with the joined data
                studentname.setText(rs.getString("student_name"));
                bookname.setText(rs.getString("book_name"));
                
                // Important: Store these in hidden labels or variables for the Return function
                bid.setText(rs.getString("bookid"));
                issid.setText(rs.getString("borrow_id"));
                
            } else {
                // Clear fields if no active issue is found
                JOptionPane.showMessageDialog(this, "No active issued book found for this Student ID");
                studentname.setText("");
                bookname.setText("");
            }

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }
}
    
   public boolean returnBook(int borrowId, int bookId) {
    boolean success = false;
    
    // SQL 1: Change status to 'Returned'
    String sqlReturn = "UPDATE borrowed_books SET status = 'Returned' WHERE borrow_id = ?";
    // SQL 2: Increase the quantity in book table
    String sqlUpdateQty = "UPDATE book SET quantity = quantity + 1 WHERE bookid = ?";

    try (Connection conn = DatabaseConnection.getConnection()) {
        // Start Transaction
        conn.setAutoCommit(false); 

        try (PreparedStatement pst1 = conn.prepareStatement(sqlReturn);
             PreparedStatement pst2 = conn.prepareStatement(sqlUpdateQty)) {

            // Execute Status Update
            pst1.setInt(1, borrowId);
            pst1.executeUpdate();

            // Execute Stock Update
            pst2.setInt(1, bookId);
            pst2.executeUpdate();

            // If both succeed, commit changes
            conn.commit();
            success = true;
        } catch (SQLException e) {
            conn.rollback(); // Undo everything if one fails
            JOptionPane.showMessageDialog(null, "Transaction Failed: " + e.getMessage());
        }
    } catch (SQLException e) {
        System.err.println("Database Error: " + e.getMessage());
    }
    return success;
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMaterialButtonCircleBeanInfo1 = new rojerusan.RSMaterialButtonCircleBeanInfo();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        bookname = new app.bolivia.swing.JCTextField();
        studentname = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        bid = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        issid = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        studid = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bookid = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 51, 51));
        jLabel13.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel13.setText("Book name");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 220, 70));

        bookname.setBackground(new java.awt.Color(255, 0, 51));
        bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        bookname.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        bookname.setPlaceholder("  .....");
        bookname.addActionListener(this::booknameActionPerformed);
        jPanel5.add(bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 260, 50));

        studentname.setBackground(new java.awt.Color(255, 0, 51));
        studentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studentname.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        studentname.setPlaceholder(".......");
        jPanel5.add(studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 270, 50));

        jLabel9.setBackground(new java.awt.Color(255, 51, 51));
        jLabel9.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel9.setText("Book Details");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 270, 100));

        bid.setBackground(new java.awt.Color(255, 51, 51));
        bid.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        bid.setForeground(new java.awt.Color(0, 204, 255));
        bid.setText("Book id : ");
        jPanel5.add(bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 220, 70));

        jLabel22.setBackground(new java.awt.Color(255, 51, 51));
        jLabel22.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Book id");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 220, 70));

        issid.setBackground(new java.awt.Color(255, 51, 51));
        issid.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        issid.setForeground(new java.awt.Color(255, 0, 51));
        jPanel5.add(issid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 220, 70));

        jLabel23.setBackground(new java.awt.Color(255, 51, 51));
        jLabel23.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Student Name");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 220, 70));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, -20, 430, 830));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        studid.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        studid.setPlaceholder("book name .....");
        studid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                studidFocusLost(evt);
            }
        });
        jPanel1.add(studid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 280, 50));

        jLabel16.setBackground(new java.awt.Color(255, 51, 51));
        jLabel16.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel16.setText("Book iD");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 220, 70));

        jLabel17.setBackground(new java.awt.Color(255, 51, 51));
        jLabel17.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 0));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel17.setText("Student Id");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 220, 70));

        bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        bookid.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        bookid.setPlaceholder("book name .....");
        bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bookidFocusLost(evt);
            }
        });
        jPanel1.add(bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 280, 50));

        jLabel19.setBackground(new java.awt.Color(255, 51, 51));
        jLabel19.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 204, 0));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel19.setText("Return book");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 260, 70));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(204, 255, 0));
        rSMaterialButtonCircle1.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle1.setText("Find");
        rSMaterialButtonCircle1.addActionListener(this::rSMaterialButtonCircle1ActionPerformed);
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 170, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(204, 255, 0));
        rSMaterialButtonCircle2.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle2.setText("return");
        rSMaterialButtonCircle2.addActionListener(this::rSMaterialButtonCircle2ActionPerformed);
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 420, 800));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/icons/library-3.png.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 40, 680, 780));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel3.setText("Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1505, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new Homepage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_booknameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
searcsud();



    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookidFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bookidFocusLost

    private void studidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studidFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_studidFocusLost

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
    // 1. Get the IDs from your hidden labels (populated by searcsud)
    String borrowIdText = issid.getText();
    String bookIdText = bid.getText();

    if (borrowIdText.isEmpty() || bookIdText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please search for a student first!");
        return;
    }

    int bId = Integer.parseInt(borrowIdText);
    int bookId = Integer.parseInt(bookIdText);

    // 2. Call the return function
    if (returnBook(bId, bookId)) {
        JOptionPane.showMessageDialog(this, "Book Returned Successfully!");
        
        // 3. Clear UI for next return
        clearFields();
    }
}

// Helper to clear the screen
public void clearFields() {
    studid.setText("");
    studentname.setText("");
    bookname.setText("");
    issid.setText("");
  
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ReturnBook().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bid;
    private app.bolivia.swing.JCTextField bookid;
    private app.bolivia.swing.JCTextField bookname;
    private javax.swing.JLabel issid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircleBeanInfo rSMaterialButtonCircleBeanInfo1;
    private app.bolivia.swing.JCTextField studentname;
    private app.bolivia.swing.JCTextField studid;
    // End of variables declaration//GEN-END:variables


}
