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
public class Issuebook extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Issuebook.class.getName());

    public Issuebook() {
        initComponents();
     
    }
    public boolean issueBook(int bookId, int studentId, java.util.Date bDate, java.util.Date rDate) {
    // 1. Get Today's Date (at 00:00:00 for accurate comparison)
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
    cal.set(java.util.Calendar.MINUTE, 0);
    cal.set(java.util.Calendar.SECOND, 0);
    cal.set(java.util.Calendar.MILLISECOND, 0);
    java.util.Date today = cal.getTime();

    // 2. Rule: Borrow Date must be Today
    if (!bDate.equals(today)) {
        JOptionPane.showMessageDialog(null, "Error: Borrow date must be today's date!");
        return false;
    }

    // 3. Rule: Return Date must be Today or Later (Next Day+)
    if (rDate.before(today)) {
        JOptionPane.showMessageDialog(null, "Error: Return date cannot be in the past!");
        return false;
    }

    // 4. Rule: Check for Duplicate Borrowing
    if (isAlreadyBorrowed(bookId, studentId)) {
        JOptionPane.showMessageDialog(null, "This student already has an active issue for this book!");
        return false;
    }

    // 5. Database Transaction (Insert Borrow + Update Qty)
    String issueSql = "INSERT INTO  borrowed_books (bookid, student_id, borrow_date, return_date, status) VALUES (?, ?, ?, ?, 'Issued')";
    String updateQtySql = "UPDATE book SET quantity = quantity - 1 WHERE bookid = ? AND quantity > 0";

    try (Connection conn = DatabaseConnection.getConnection()) {
        conn.setAutoCommit(false);
        try (PreparedStatement pstIssue = conn.prepareStatement(issueSql);
             PreparedStatement pstUpdate = conn.prepareStatement(updateQtySql)) {
            
            pstIssue.setInt(1, bookId);
            pstIssue.setInt(2, studentId);
            pstIssue.setDate(3, new java.sql.Date(bDate.getTime()));
            pstIssue.setDate(4, new java.sql.Date(rDate.getTime()));
            pstIssue.executeUpdate();

            pstUpdate.setInt(1, bookId);
            if (pstUpdate.executeUpdate() > 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Book is Out of Stock!");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
    }
    return false;
}
    public boolean isAlreadyBorrowed(int bookId, int studentId) {
    boolean exists = false;
    String sql = "SELECT * FROM borrowed_books WHERE bookid = ? AND student_id = ? AND status = 'Issued'";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setInt(1, bookId);
        pst.setInt(2, studentId);
        java.sql.ResultSet rs = pst.executeQuery();
        if (rs.next()) exists = true;
    } catch (SQLException e) { e.printStackTrace(); }
    return exists;
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
                bookauthor.setText(rs.getString("author"));
                bookquantity.setText(String.valueOf(rs.getInt("quantity")));
                found = true;
            }else{
            labales.setText("no book available");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Search Error: " + e.getMessage());
    }
    return found;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMaterialButtonCircleBeanInfo1 = new rojerusan.RSMaterialButtonCircleBeanInfo();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        bookauthor = new app.bolivia.swing.JCTextField();
        bookquantity = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bookname = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        studcourse = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        studbranch = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        studname = new app.bolivia.swing.JCTextField();
        studentid = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        labales = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        studid = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        bookid = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        bd = new rojeru_san.componentes.RSDateChooser();
        rd = new rojeru_san.componentes.RSDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 51, 51));
        jLabel13.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel13.setText("Author");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 220, 70));

        bookauthor.setBackground(new java.awt.Color(255, 0, 51));
        bookauthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        bookauthor.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        bookauthor.setPlaceholder(" author .....");
        bookauthor.addActionListener(this::bookauthorActionPerformed);
        jPanel5.add(bookauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 260, 50));

        bookquantity.setBackground(new java.awt.Color(255, 0, 51));
        bookquantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        bookquantity.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        bookquantity.setPlaceholder("enter quantity.......");
        jPanel5.add(bookquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 270, 50));

        jLabel9.setBackground(new java.awt.Color(255, 51, 51));
        jLabel9.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel9.setText("Book Details");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 270, 100));

        jLabel10.setBackground(new java.awt.Color(255, 51, 51));
        jLabel10.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel10.setText(" Name");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, 70));

        bookname.setBackground(new java.awt.Color(255, 0, 51));
        bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        bookname.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        bookname.setPlaceholder("book name .....");
        jPanel5.add(bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 280, 50));

        jLabel21.setBackground(new java.awt.Color(255, 51, 51));
        jLabel21.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jLabel21.setText("Quantity");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 220, 70));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 470, 830));

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
        jLabel11.setText("Course");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 220, 70));

        studcourse.setBackground(new java.awt.Color(102, 102, 255));
        studcourse.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studcourse.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        studcourse.setPlaceholder(" enter course .....");
        studcourse.addActionListener(this::studcourseActionPerformed);
        jPanel3.add(studcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 280, 50));

        jLabel12.setBackground(new java.awt.Color(255, 51, 51));
        jLabel12.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jLabel12.setText("branch");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 220, 70));

        studbranch.setBackground(new java.awt.Color(102, 102, 255));
        studbranch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studbranch.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        studbranch.setPlaceholder("enter branch.......");
        studbranch.addActionListener(this::studbranchActionPerformed);
        jPanel3.add(studbranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 300, 50));

        jLabel6.setBackground(new java.awt.Color(255, 51, 51));
        jLabel6.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel6.setText("Student Details");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 290, 110));

        jLabel7.setBackground(new java.awt.Color(255, 51, 51));
        jLabel7.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel7.setText(" Name");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 220, 70));

        studname.setBackground(new java.awt.Color(102, 102, 255));
        studname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studname.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        studname.setPlaceholder("Student name .....");
        studname.addActionListener(this::studnameActionPerformed);
        jPanel3.add(studname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 280, 50));

        studentid.setBackground(new java.awt.Color(102, 102, 255));
        studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studentid.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        studentid.setPlaceholder("Student id .....");
        studentid.addActionListener(this::studentidActionPerformed);
        jPanel3.add(studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 260, 50));

        jLabel8.setBackground(new java.awt.Color(255, 51, 51));
        jLabel8.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel8.setText("Student Id");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 220, 70));

        labales.setBackground(new java.awt.Color(255, 51, 51));
        labales.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        labales.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(labales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 380, 70));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 830));

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
        jPanel1.add(studid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 280, 50));

        jLabel15.setBackground(new java.awt.Color(255, 51, 51));
        jLabel15.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel15.setText(" Return_date ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 220, 70));

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

        jLabel18.setBackground(new java.awt.Color(255, 51, 51));
        jLabel18.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 0));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel18.setText(" borrow_date ");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 220, 70));

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
        jLabel19.setText("borrow book");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 190, 70));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(204, 255, 0));
        rSMaterialButtonCircle1.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle1.setText("Add Issued Book");
        rSMaterialButtonCircle1.addActionListener(this::rSMaterialButtonCircle1ActionPerformed);
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 590, 170, -1));
        jPanel1.add(bd, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));
        jPanel1.add(rd, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 470, 800));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new Homepage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void studcourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studcourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studcourseActionPerformed

    private void studbranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studbranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studbranchActionPerformed

    private void studnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studnameActionPerformed

    private void studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentidActionPerformed

    private void bookauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookauthorActionPerformed

    private void bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookidFocusLost
        // TODO add your handling code here:
        String idText = bookid.getText().trim();

    if (idText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a Book ID to search.");
        return;
    }

    try {
        int id = Integer.parseInt(idText);
        
        // Call the search function
        boolean isFound = searchBook(id, bookname, bookauthor, bookquantity);

        if (!isFound) {
            JOptionPane.showMessageDialog(this, "Book not found!");
            // Optional: Clear fields if not found
            bookname.setText("");
            bookauthor.setText("");
            bookquantity.setText("");
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid ID format. Please enter a number.");
    }
    }//GEN-LAST:event_bookidFocusLost

    private void studidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studidFocusLost
        // TODO add your handling code here:
        String sId = studid.getText().trim();

    if (!sId.isEmpty()) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE student_id = ?")) {

            pstmt.setString(1, sId);
            java.sql.ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // If student is found, fill the fields
                studentid.setText(rs.getString("student_id"));
                studname.setText(rs.getString("name"));
                studcourse.setText(rs.getString("course"));
                studbranch.setText(rs.getString("branch"));
            } else {
                // If not found, you might want to clear fields or alert the user
                studname.setText("");
                studcourse.setText("");
                studbranch.setText("");
                labales.setText("No stodent available");
                // Optional: Show a small warning
                // JOptionPane.showMessageDialog(this, "Student ID not found");
            }

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_studidFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
                                             
   int bId = Integer.parseInt(bookid.getText());
     int sId = Integer.parseInt(studentid.getText());
   
   
    
    // Getting dates from RSDateChooser
    java.util.Date bd1 = bd.getDatoFecha();
    java.util.Date rd1 = rd.getDatoFecha();

    if (bd1 == null || rd1 == null) {
        JOptionPane.showMessageDialog(this, "Please select both dates!");
        return;
    }

    if (issueBook(bId, sId, bd1, rd1)) {
        JOptionPane.showMessageDialog(this, "Book Issued Successfully!");
        // Optional: update your labels/tables here
    } else {
        JOptionPane.showMessageDialog(this, "Can't issue the book.");
    }

    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Issuebook().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser bd;
    private app.bolivia.swing.JCTextField bookauthor;
    private app.bolivia.swing.JCTextField bookid;
    private app.bolivia.swing.JCTextField bookname;
    private app.bolivia.swing.JCTextField bookquantity;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labales;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircleBeanInfo rSMaterialButtonCircleBeanInfo1;
    private rojeru_san.componentes.RSDateChooser rd;
    private app.bolivia.swing.JCTextField studbranch;
    private app.bolivia.swing.JCTextField studcourse;
    private app.bolivia.swing.JCTextField studentid;
    private app.bolivia.swing.JCTextField studid;
    private app.bolivia.swing.JCTextField studname;
    // End of variables declaration//GEN-END:variables


}
