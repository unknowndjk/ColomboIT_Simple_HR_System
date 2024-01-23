/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author dinet
 */
public class HRA_T extends HRM_T {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public HRA_T() {
         abdbconnect db = new abdbconnect();
         conn  = db.connect();
    }
    
    // HRM JFRAM HAVE INHERIT WITH HRA_T CLASS 
    
    //for Show the HRA users for the HR Managers
    public void showAssistant(JTable table){
        try {
            String sql = "SELECT id,name,username,user_type FROM users WHERE user_type = 'HRA'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setModel(table.getModel());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
