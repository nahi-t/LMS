/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymanagemant;


import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
public class ManageBooks extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManageBooks.class.getName());

    /**
     * Creates new form ManageBooks
     */
    public ManageBooks() {
        initComponents();
       getBookList();
    }
    int selectedBookId = -1;
    public void addBook(String name, String author, int quantity) {
    // We leave out bookid because it is auto_increment
    String sql = "INSERT INTO book (name, author, quantity) VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, name);
        pstmt.setString(2, author);
        pstmt.setInt(3, quantity);

        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Book added successfully!");
            
        }

    } catch (SQLException e) {
        System.err.println("Error adding book: " + e.getMessage());
    }
}
 
public DefaultTableModel getBookList() {
    // Create the column headers
    String[] columns = {"Book ID", "Book Name", "Author", "Quantity"};
    DefaultTableModel model = new DefaultTableModel(null, columns);

    String sql = "SELECT * FROM book";

    try (Connection conn = DatabaseConnection.getConnection();
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            // Get data from each row
            int id = rs.getInt("bookid");
            String name = rs.getString("name");
            String author = rs.getString("author");
            int qty = rs.getInt("quantity");

            // Add the row to the table model
            Object[] row = {id, name, author, qty};
           
           model.addRow(row);  
        }
        Booktable.setModel(model);
    } catch (SQLException e) {
        System.err.println("Error loading table: " + e.getMessage());
    }
    return model;
}
public void updateBook(int id, String name, String author, int qty) {
    String sql = "UPDATE book SET name = ?, author = ?, quantity = ? WHERE bookid = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, name);
        pstmt.setString(2, author);
        pstmt.setInt(3, qty);
        pstmt.setInt(4, id); 

        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
}
public DefaultTableModel loadBooks() {
    String[] columns = {"Book ID", "Book Name", "Author", "Quantity"};
    DefaultTableModel model = new DefaultTableModel(null, columns);

    String sql = "SELECT * FROM book";

    try (Connection conn = DatabaseConnection.getConnection();
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            int id = rs.getInt("bookid");
            String name = rs.getString("name");
            String author = rs.getString("author");
            int qty = rs.getInt("quantity");

            // Correct: Just add the row to the model
            Object[] row = {id, name, author, qty};
            model.addRow(row);
        }
        
        // After the loop finishes, set the model to the JTable
        Booktable.setModel(model);

    } catch (SQLException e) {
        System.err.println("Error loading table: " + e.getMessage());
    }
    return model;
}
public void deleteBook(int id) {
    String sql = "DELETE FROM book WHERE bookid = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);

        int rowsDeleted = pstmt.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null, "Book deleted successfully!");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Delete Error: " + e.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bookauthor = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        bookquantity = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bookname = new app.bolivia.swing.JCTextField();
        login = new rojerusan.RSMaterialButtonCircle();
        login1 = new rojerusan.RSMaterialButtonCircle();
        login2 = new rojerusan.RSMaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Booktable = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel3.setText("Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 60));

        jLabel11.setBackground(new java.awt.Color(255, 51, 51));
        jLabel11.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel11.setText("Author");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 220, 70));

        bookauthor.setBackground(new java.awt.Color(102, 102, 255));
        bookauthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        bookauthor.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        bookauthor.setPlaceholder(" author .....");
        bookauthor.addActionListener(this::bookauthorActionPerformed);
        jPanel3.add(bookauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 370, 50));

        jLabel12.setBackground(new java.awt.Color(255, 51, 51));
        jLabel12.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jLabel12.setText("Quantity");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 220, 70));

        bookquantity.setBackground(new java.awt.Color(102, 102, 255));
        bookquantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        bookquantity.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        bookquantity.setPlaceholder("enter quantity.......");
        jPanel3.add(bookquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 370, 50));

        jLabel6.setBackground(new java.awt.Color(255, 51, 51));
        jLabel6.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Add Book");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 190, 70));

        jLabel7.setBackground(new java.awt.Color(255, 51, 51));
        jLabel7.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel7.setText(" Name");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, 70));

        bookname.setBackground(new java.awt.Color(102, 102, 255));
        bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        bookname.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        bookname.setPlaceholder("book name .....");
        jPanel3.add(bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 370, 50));

        login.setBackground(new java.awt.Color(255, 51, 0));
        login.setText("DELETE");
        login.addActionListener(this::loginActionPerformed);
        jPanel3.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 680, 170, -1));

        login1.setBackground(new java.awt.Color(102, 102, 102));
        login1.setText("ADD Book");
        login1.addActionListener(this::login1ActionPerformed);
        jPanel3.add(login1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 170, -1));

        login2.setBackground(new java.awt.Color(204, 255, 51));
        login2.setText("UPDATE");
        login2.addActionListener(this::login2ActionPerformed);
        jPanel3.add(login2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 680, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 830));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Booktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookId", "name", "Authoe", "Quantity "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Booktable.setFuenteFilas(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Booktable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BooktableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Booktable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 1020, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1140, 820));

        setSize(new java.awt.Dimension(1724, 854));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login1ActionPerformed
        // TODO add your handling code here:
                                              
    String bookName = bookname.getText().trim();
    String authorName = bookauthor.getText().trim();
    String qtyString = bookquantity.getText().trim();

    // Basic Validation
    if (bookName.isEmpty() || authorName.isEmpty() || qtyString.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields!");
        return;
    }

    try {
        int qty = Integer.parseInt(qtyString); // Convert text to number
        
    
        addBook(bookName, authorName, qty);
        
        JOptionPane.showMessageDialog(this, "Book Added to Library!");
         getBookList();
        
        // Clear fields for next entry
        bookname.setText("");
        bookauthor.setText("");
        bookquantity.setText("");
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Quantity must be a valid number!");
    }

    }//GEN-LAST:event_login1ActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
if (selectedBookId == -1) {
        JOptionPane.showMessageDialog(this, "Select a book to delete!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Delete", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        deleteBook(selectedBookId); // Uses the variable from mouse click
        loadBooks();
        selectedBookId = -1; // Reset
    }        
    }//GEN-LAST:event_loginActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new Homepage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void login2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login2ActionPerformed
    // Refresh the JTable
    if (selectedBookId == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book from the table first!");
        return;
    }

    String name = bookname.getText();
    String author = bookauthor.getText();
    int qty = Integer.parseInt(bookquantity.getText());

    updateBook(selectedBookId, name, author, qty);
    loadBooks();

    }//GEN-LAST:event_login2ActionPerformed

    private void bookauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookauthorActionPerformed

    private void BooktableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BooktableMouseClicked
        // TODO add your handling code here:
                                          
    int row = Booktable.getSelectedRow();
    
    // Get values from the selected row index
 selectedBookId = Integer.parseInt(Booktable.getValueAt(row, 0).toString());
    String name = Booktable.getValueAt(row, 1).toString();
    String author = Booktable.getValueAt(row, 2).toString();
    String qty = Booktable.getValueAt(row, 3).toString();

    // Fill your text fields
  
    bookname.setText(name);
    bookauthor.setText(author);
    bookquantity.setText(qty);

    }//GEN-LAST:event_BooktableMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new ManageBooks().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Booktable;
    private app.bolivia.swing.JCTextField bookauthor;
    private app.bolivia.swing.JCTextField bookname;
    private app.bolivia.swing.JCTextField bookquantity;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle login;
    private rojerusan.RSMaterialButtonCircle login1;
    private rojerusan.RSMaterialButtonCircle login2;
    // End of variables declaration//GEN-END:variables
}
