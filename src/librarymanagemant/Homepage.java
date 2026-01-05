/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymanagemant;

import java.awt.Color;
import javax.swing.border.Border;


public class Homepage extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Homepage.class.getName());

   Color mouseEnterColor=new Color(0,0,0);
Color mouseExitColor=new Color(51,51,51);
    public Homepage() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        mb = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ms = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ib = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Booktable = new rojerusan.RSTableMetro();
        jScrollPane2 = new javax.swing.JScrollPane();
        StudentTable = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 30));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("Welcome Admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 10, 250, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Managememt  System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 390, -1));

        jLabel4.setFont(new java.awt.Font("Liberation Serif", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("   X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1790, 10, 110, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 70));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel5.setText("Defaulter List");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, 340, 60));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel8.setText(" Lms Dashbord");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 230, 40));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 340, 60));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Features");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 40));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, 60));

        mb.setBackground(new java.awt.Color(51, 51, 51));
        mb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mbMouseExited(evt);
            }
        });
        mb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel10.setText("Manage Books");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        mb.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 40));

        jPanel2.add(mb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 340, 60));

        ms.setBackground(new java.awt.Color(51, 51, 51));
        ms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                msMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                msMouseExited(evt);
            }
        });
        ms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel11.setText("Manage Student");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        ms.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 40));

        jPanel2.add(ms, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 340, 60));

        ib.setBackground(new java.awt.Color(51, 51, 51));
        ib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ibMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ibMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ibMouseExited(evt);
            }
        });
        ib.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        jLabel12.setText("Issue Book");
        ib.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 40));

        jPanel2.add(ib, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel13.setText("Issue Book");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 230, 40));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel14.setText("Issue Book");
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 40));

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel13MouseExited(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel15.setText("Return Book");
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 40));

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 340, 60));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel16.setText("View Records");
        jPanel14.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 40));

        jPanel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 340, 60));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel17.setText("View Issued Book");
        jPanel15.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 40));

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 340, 60));

        jPanel16.setBackground(new java.awt.Color(255, 0, 0));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel18.setText("Home Page");
        jPanel16.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 230, 40));

        jPanel2.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 60));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Exit_26px_1.png"))); // NOI18N
        jLabel6.setText("Logout");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 230, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 860, 340, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 1000));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Z003", 0, 48)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel19.setText("10");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, 60));

        jPanel17.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 260, 140));

        jLabel7.setFont(new java.awt.Font("Z003", 0, 36)); // NOI18N
        jLabel7.setText("NO Books");
        jPanel17.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 190, 40));

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 153, 0)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Z003", 0, 48)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_People_50px.png"))); // NOI18N
        jLabel20.setText("10");
        jPanel18.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 190, 60));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 260, 140));

        jLabel21.setFont(new java.awt.Font("Z003", 0, 36)); // NOI18N
        jLabel21.setText("NO Student");
        jPanel17.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 190, 40));

        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Z003", 0, 48)); // NOI18N
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        jLabel22.setText("10");
        jPanel19.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 190, 60));

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 260, 140));

        jLabel23.setFont(new java.awt.Font("Z003", 0, 36)); // NOI18N
        jLabel23.setText("NO issued book");
        jPanel17.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 230, 40));

        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 255, 102)));
        jPanel20.setForeground(new java.awt.Color(51, 255, 51));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Z003", 0, 48)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagemant/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        jLabel24.setText("10");
        jPanel20.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 190, 60));

        jPanel17.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 60, 260, 140));

        jLabel25.setFont(new java.awt.Font("Z003", 0, 36)); // NOI18N
        jLabel25.setText("NO defaulter");
        jPanel17.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 20, 190, 40));

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
        jScrollPane1.setViewportView(Booktable);

        jPanel17.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, 1020, 310));

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
        jScrollPane2.setViewportView(StudentTable);

        jPanel17.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 1020, 310));

        getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1570, 1010));

        setSize(new java.awt.Dimension(1921, 1023));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void mbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbMouseClicked
        // TODO add your handling code here:
        new ManageBooks().setVisible(true);
        dispose();
    }//GEN-LAST:event_mbMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
         new ManageBooks().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void msMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msMouseClicked
        // TODO add your handling code here:
        new ManageStudent().setVisible(true);
        dispose();
    }//GEN-LAST:event_msMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
         new ManageStudent().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void mbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbMouseEntered
        // TODO add your handling code here:
     
    }//GEN-LAST:event_mbMouseEntered

    private void mbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbMouseExited
        // TODO add your handling code here:
    
    }//GEN-LAST:event_mbMouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
  mb.setBackground(mouseEnterColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
        mb.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel10MouseExited

    private void msMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msMouseEntered
        // TODO add your handling code here:
         ms.setBackground(mouseEnterColor);
    }//GEN-LAST:event_msMouseEntered

    private void msMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msMouseExited
        // TODO add your handling code here:
         ms.setBackground(mouseExitColor);
    }//GEN-LAST:event_msMouseExited

    private void ibMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ibMouseClicked
        // TODO add your handling code here:
        new Issuebook().setVisible(true);
        dispose();
    }//GEN-LAST:event_ibMouseClicked

    private void ibMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ibMouseEntered
        // TODO add your handling code here:
            ib.setBackground(mouseEnterColor);
    }//GEN-LAST:event_ibMouseEntered

    private void ibMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ibMouseExited
        // TODO add your handling code here:
            ib.setBackground(mouseExitColor);
    }//GEN-LAST:event_ibMouseExited

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        // TODO add your handling code here:
        new ReturnBook().setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        // TODO add your handling code here:
        jPanel13.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        // TODO add your handling code here:
          jPanel13.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel13MouseExited

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
        java.awt.EventQueue.invokeLater(() -> new Homepage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Booktable;
    private rojerusan.RSTableMetro StudentTable;
    private javax.swing.JPanel ib;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mb;
    private javax.swing.JPanel ms;
    // End of variables declaration//GEN-END:variables
}
