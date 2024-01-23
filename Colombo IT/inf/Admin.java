/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf;

import code.Admin_T;
import code.dbconnect;
import code.user;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author dinet
 */
public class Admin extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
   
    
    public Admin() {
        conn = dbconnect.connect(); 
        initComponents();
        tableload();
        
        
    }
    
    public void tableload(){
        try {
            String sql = "SELECT * FROM users";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    String id_V;
    
    public void tableData(){
        int r = table1.getSelectedRow();
        String id = table1.getValueAt(r, 0).toString();
        String name = table1.getValueAt(r, 1).toString();
        String username = table1.getValueAt(r, 2).toString();
        String password = table1.getValueAt(r, 3).toString();
        String user_Type = table1.getValueAt(r, 4).toString();
       
        id_V = id;
       id_Box.setText(id);
       name_Box.setText(name);
       user_Name_Box.setText(username);
       password_Box.setText(password);
       user_Type_Box.setSelectedItem(user_Type);
       
       Admin_T update = new Admin_T();
      
        
    }
    
    public void userNameDisplay(String username){
        display_Name_Box.setText(username);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name_Box = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        user_Name_Box = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password_Box = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user_Type_Box = new javax.swing.JComboBox();
        add_New_Btn = new javax.swing.JButton();
        update_Btn = new javax.swing.JButton();
        delete_Btn = new javax.swing.JButton();
        clear_Btn = new javax.swing.JButton();
        id_Box = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        display_Name_Box = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        logout_Btn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        search_Box = new javax.swing.JTextField();
        id_R_Btn = new javax.swing.JRadioButton();
        username_R_Btn = new javax.swing.JRadioButton();
        user_Type_Btn = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 164, 127));
        jPanel1.setPreferredSize(new java.awt.Dimension(880, 5100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 97, 103));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Admin Page");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 50));
        jPanel2.add(name_Box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 211, 43));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 64, -1));
        jPanel2.add(user_Name_Box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 211, 43));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 103, -1));
        jPanel2.add(password_Box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 211, 43));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 103, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("User Type");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 103, -1));

        user_Type_Box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user_Type_Box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HRM", "HRA" }));
        user_Type_Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_Type_BoxActionPerformed(evt);
            }
        });
        jPanel2.add(user_Type_Box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 211, 45));

        add_New_Btn.setBackground(new java.awt.Color(153, 255, 255));
        add_New_Btn.setText("ADD NEW");
        add_New_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_New_BtnActionPerformed(evt);
            }
        });
        jPanel2.add(add_New_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 120, 40));

        update_Btn.setBackground(new java.awt.Color(102, 255, 255));
        update_Btn.setText("UPDATE");
        update_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_BtnActionPerformed(evt);
            }
        });
        jPanel2.add(update_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 120, 40));

        delete_Btn.setBackground(new java.awt.Color(102, 255, 255));
        delete_Btn.setText("DELETE");
        delete_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_BtnActionPerformed(evt);
            }
        });
        jPanel2.add(delete_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 120, 40));

        clear_Btn.setBackground(new java.awt.Color(153, 255, 255));
        clear_Btn.setText("Clear");
        clear_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_BtnActionPerformed(evt);
            }
        });
        jPanel2.add(clear_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 120, 40));

        id_Box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        id_Box.setText("ID");
        jPanel2.add(id_Box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 210, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("ID");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, 40));

        display_Name_Box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        display_Name_Box.setText("username");
        jPanel2.add(display_Name_Box, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 90, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, 30));

        logout_Btn.setBackground(new java.awt.Color(102, 255, 255));
        logout_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        logout_Btn.setText("Logout");
        logout_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_BtnActionPerformed(evt);
            }
        });
        jPanel2.add(logout_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 410, 530));

        jPanel5.setBackground(new java.awt.Color(238, 164, 127));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Users", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        search_Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_BoxActionPerformed(evt);
            }
        });
        search_Box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_BoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_BoxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_Box, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_Box, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 440, 80));

        id_R_Btn.setBackground(new java.awt.Color(238, 164, 127));
        buttonGroup1.add(id_R_Btn);
        id_R_Btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        id_R_Btn.setText("ID");
        jPanel1.add(id_R_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        username_R_Btn.setBackground(new java.awt.Color(238, 164, 127));
        buttonGroup1.add(username_R_Btn);
        username_R_Btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        username_R_Btn.setText("Username");
        jPanel1.add(username_R_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, -1));

        user_Type_Btn.setBackground(new java.awt.Color(238, 164, 127));
        buttonGroup1.add(user_Type_Btn);
        user_Type_Btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user_Type_Btn.setText("User Type");
        jPanel1.add(user_Type_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, -1, -1));

        table1.setBackground(new java.awt.Color(204, 204, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.setGridColor(new java.awt.Color(153, 153, 153));
        table1.setRequestFocusEnabled(false);
        table1.setSelectionForeground(new java.awt.Color(238, 164, 127));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 540, 381));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("COLOMBO INSITUTE OF EDUCATION");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 690, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void add_New_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_New_BtnActionPerformed

        String name = name_Box.getText();
        String username = user_Name_Box.getText();
        String password = password_Box.getText();
        String user_Type = user_Type_Box.getSelectedItem().toString();
        JTable table = table1;
        
        Admin_T dataAdd = new Admin_T();
        dataAdd.userAdd(name, username, password, user_Type, this);
        tableload();
        cleardata();
        
    }//GEN-LAST:event_add_New_BtnActionPerformed

    private void user_Type_BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_Type_BoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_Type_BoxActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        tableData();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyPressed
  
        
    }//GEN-LAST:event_table1KeyPressed

    private void update_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_BtnActionPerformed
        Admin_T up = new Admin_T();
        
        String name = name_Box.getText();
        String username = user_Name_Box.getText();
        String password = password_Box.getText();
        String user_Type = user_Type_Box.getSelectedItem().toString();
        up.update(id_V, name, username, password, user_Type);
        tableload();
        cleardata();
    }//GEN-LAST:event_update_BtnActionPerformed

    private void search_BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_BoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_search_BoxActionPerformed

    private void search_BoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_BoxKeyReleased
        // TODO add your handling code here:
        
        Admin_T Adser = new Admin_T();
        String search = search_Box.getText();
        Adser.search(search, table1,id_R_Btn, username_R_Btn, user_Type_Btn );
//        tableload();
    }//GEN-LAST:event_search_BoxKeyReleased

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        // TODO add your handling code here:
        tableload();
    }//GEN-LAST:event_table1KeyReleased

    private void delete_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_BtnActionPerformed
        
        String username = user_Name_Box.getText();
        Admin_T delate = new Admin_T();
        delate.userDelate(username);
        tableload();
        cleardata();
    }//GEN-LAST:event_delete_BtnActionPerformed

    private void search_BoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_BoxKeyPressed
        // TODO add your handling code here:
        tableload();
    }//GEN-LAST:event_search_BoxKeyPressed

    private void logout_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_BtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        login log = new login();
        log.setVisible(true);
    }//GEN-LAST:event_logout_BtnActionPerformed

    private void clear_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_BtnActionPerformed
       cleardata();
    }//GEN-LAST:event_clear_BtnActionPerformed
    
    public void cleardata(){
       id_Box.setText("ID genarate by System");
       name_Box.setText("");
       user_Name_Box.setText("");
       password_Box.setText("");
    }
        
        
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_New_Btn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clear_Btn;
    private javax.swing.JButton delete_Btn;
    private javax.swing.JLabel display_Name_Box;
    private javax.swing.JLabel id_Box;
    private javax.swing.JRadioButton id_R_Btn;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_Btn;
    private javax.swing.JTextField name_Box;
    private javax.swing.JTextField password_Box;
    private javax.swing.JTextField search_Box;
    private javax.swing.JTable table1;
    private javax.swing.JButton update_Btn;
    private javax.swing.JTextField user_Name_Box;
    private javax.swing.JComboBox user_Type_Box;
    private javax.swing.JRadioButton user_Type_Btn;
    private javax.swing.JRadioButton username_R_Btn;
    // End of variables declaration//GEN-END:variables
}