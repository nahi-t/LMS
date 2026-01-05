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
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
public class ManageStudent extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManageStudent.class.getName());

    /**
     * Creates new form ManageBooks
     */
    public ManageStudent() {
        initComponents();
          loadStudentData();
    
    }
    // ADD STUDENT
public void addstudent(String id, String name, String course, String branch) {
    String sql = "INSERT INTO student (student_id, name, course, branch) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, course);
        pstmt.setString(4, branch);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
    }
}

// UPDATE STUDENT
public void updateStudent(String id, String name, String course, String branch) {
    // Note: Changed 'book' to 'student' in the query
    String sql = "UPDATE student SET name = ?, course = ?, branch = ? WHERE student_id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, name);
        pstmt.setString(2, course);
        pstmt.setString(3, branch);
        pstmt.setString(4, id);
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Update Error: " + e.getMessage());
    }
}
public void loadStudentData() {
    // Define columns to match your database schema
    String[] columns = {"Student ID", "Name", "Course", "Branch"};
    DefaultTableModel model = new DefaultTableModel(null, columns);

    String sql = "SELECT * FROM student";

    try (Connection conn = DatabaseConnection.getConnection();
        java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            // Make sure these names match your MySQL column names EXACTLY
            String id = rs.getString("student_id"); 
            String name = rs.getString("name");
            String course = rs.getString("course");
            String branch = rs.getString("branch");

            Object[] row = {id, name, course, branch};
            model.addRow(row);
        }
        
        // Update your RSTableMetro
        StudentTable.setModel(model);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
    }
}
public void deleteStudent(String id) {
    String sql = "DELETE FROM student WHERE student_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, id);

        int rowsDeleted = pstmt.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null, "Student record deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "No student found with that ID.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Delete Error: " + e.getMessage());
    }
}
public void clearFields() {
    studentid.setText("");
    studname.setText("");
    studcourse.setText("");
    studbranch.setText("");
    // Re-enable the ID field if you disabled it during editing
    studentid.setEditable(true);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        login = new rojerusan.RSMaterialButtonCircle();
        login1 = new rojerusan.RSMaterialButtonCircle();
        login2 = new rojerusan.RSMaterialButtonCircle();
        studentid = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        StudentTable = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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
        jLabel11.setText("Course");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 220, 70));

        studcourse.setBackground(new java.awt.Color(102, 102, 255));
        studcourse.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studcourse.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        studcourse.setPlaceholder(" enter course .....");
        studcourse.addActionListener(this::studcourseActionPerformed);
        jPanel3.add(studcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 370, 50));

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
        jPanel3.add(studbranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 370, 50));

        jLabel6.setBackground(new java.awt.Color(255, 51, 51));
        jLabel6.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Add Student");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 190, 70));

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
        jPanel3.add(studname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 370, 50));

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

        studentid.setBackground(new java.awt.Color(102, 102, 255));
        studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studentid.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        studentid.setPlaceholder("Student id .....");
        studentid.addActionListener(this::studentidActionPerformed);
        jPanel3.add(studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 370, 50));

        jLabel8.setBackground(new java.awt.Color(255, 51, 51));
        jLabel8.setFont(new java.awt.Font("Ubuntu Sans", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel8.setText("Student Id");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 220, 70));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentID", "name", "course", "branch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        StudentTable.setFont(new java.awt.Font("URW Gothic", 1, 24)); // NOI18N
        StudentTable.setFuenteFilas(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        StudentTable.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        StudentTable.setRowHeight(40);
        jScrollPane2.setViewportView(StudentTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 1020, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1140, 820));

        setSize(new java.awt.Dimension(1724, 817));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login1ActionPerformed
        // TODO add your handling code here:
                                              
    String sId = studentid.getText().trim(); // Getting text from JCTextField
    String sName = studname.getText().trim();
    String sCourse = studcourse.getText().trim();
    String sBranch = studbranch.getText().trim();

    if (sId.isEmpty() || sName.isEmpty() || sCourse.isEmpty() || sBranch.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields!");
        return;
    }

    addstudent(sId, sName, sCourse, sBranch);
    JOptionPane.showMessageDialog(this, "Student Added!");
    loadStudentData();
   // This refreshes your table


    }//GEN-LAST:event_login1ActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
String id = studentid.getText().trim(); // Get ID from the JCTextField

    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a student from the table to delete.");
        return;
    }

    // Confirmation Dialog
    int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete Student ID: " + id + "?", 
            "Confirm Deletion", 
            JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        // 1. Call the delete function
        deleteStudent(id);
        
        // 2. Refresh the table to show the student is gone
        loadStudentData(); 
        
        // 3. Clear the text fields
        clearFields();
    }       
    }//GEN-LAST:event_loginActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
      if (SessionManager.userRole != null && SessionManager.userRole.equalsIgnoreCase("Admin")) {
            Homepage adminHome = new Homepage();
            adminHome.setVisible(true);
           dispose(); 
        } 
        else if (SessionManager.userRole != null && SessionManager.userRole.equalsIgnoreCase("Staff")) {
            Homepagestaff staffHome = new Homepagestaff();
            staffHome.setVisible(true);
           dispose();
        } 
    }//GEN-LAST:event_jLabel3MouseClicked

    private void login2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login2ActionPerformed
    // Refresh the JTable
                                      
    String sId = studentid.getText().trim(); 
    String sName = studname.getText().trim();
    String sCourse = studcourse.getText().trim();
    String sBranch = studbranch.getText().trim();

    updateStudent(sId, sName, sCourse, sBranch);
  loadStudentData();

    
    
    }//GEN-LAST:event_login2ActionPerformed

    private void studcourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studcourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studcourseActionPerformed

    private void studnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studnameActionPerformed

    private void studbranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studbranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studbranchActionPerformed

    private void studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentidActionPerformed

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
       new LoginPage().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro StudentTable;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle login;
    private rojerusan.RSMaterialButtonCircle login1;
    private rojerusan.RSMaterialButtonCircle login2;
    private app.bolivia.swing.JCTextField studbranch;
    private app.bolivia.swing.JCTextField studcourse;
    private app.bolivia.swing.JCTextField studentid;
    private app.bolivia.swing.JCTextField studname;
    // End of variables declaration//GEN-END:variables

    private void deleteBook(JCTextField studentid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
