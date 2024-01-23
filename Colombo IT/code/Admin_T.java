
package code;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import inf.Admin;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import code.abdbconnect;

public class Admin_T extends Admin {
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    public Admin_T(){
        abdbconnect db = new abdbconnect();
        conn  = db.connect();
    }
    
    //Add New HRM/HRA to system
    public void userAdd(String name,String username, String password, String user_Type,Admin frame){
        if(!name.equals("") || !password.equals("") || !username.equals("")){
                try {
//            String sql = "INSERT INTO users(name,username,password,user_type VALUES('"+name+"','"+username+"','"+password+"','"+user_Type+"')";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            if(rs.next()){
//                JOptionPane.showMessageDialog(null, "User ADD");
//            }
                String sql_Ucheck = "SELECT username from users WHERE username = '"+username+"'";
                pst = conn.prepareStatement(sql_Ucheck);
                rs = pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "This username Already used");
                }else{
                    String sql = "INSERT INTO users(name,username,password,user_type) VALUES('"+name+"','"+username+"','"+password+"','"+user_Type+"')";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "User ADD Success full");
                
               
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Fill Details pls");
        }
    }
    
    //Update current system users
    public void update(String id,String name,String username,String password,String user_Type ){
        System.out.println(id);
        try {
           String sql = "UPDATE users SET name='"+name+"',username = '"+username+"',password='"+password+"',user_type='"+user_Type+"' WHERE id = '"+id+"' LIMIT 1";
           pst = conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(rootPane, "User Updated"); 
       
                 
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    
    //Search system users with id,username,usertype
    public void search(String search , JTable table,JRadioButton btn1 , JRadioButton btn2,JRadioButton btn3){
        try {
            if(btn1.isSelected()){
                String sql = "SELECT * FROM users WHERE id LIKE '%"+search+"%' ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
            }else if(btn2.isSelected()){
                String sql = "SELECT * FROM users WHERE username LIKE '%"+search+"%'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                
            }else if(btn3.isSelected()){
                String sql = "SELECT * FROM users WHERE user_type LIKE '%"+search+"%'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
            }else{
                String sql = "SELECT * FROM users WHERE name LIKE '%"+search+"%'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setModel(table.getModel());
         
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //Delete system users
    public void userDelate(String username){
        try {
            String sql = "DELETE FROM users WHERE username='"+username+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "User Delated!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
  
}
