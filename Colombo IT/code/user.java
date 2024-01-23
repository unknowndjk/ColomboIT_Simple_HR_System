
package code;

import code.dbconnect;
import inf.Admin;
import inf.HRM;
import inf.HRA;
import inf.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class user extends loginU {
    ResultSet rs = null;
    PreparedStatement pst = null;

    public user(){
//         conn = dbconnect.connect();
    }
    login login_Frame;
    String username;
    public void userRedirect(String username , login frame){
        loginU lo = new loginU();
        // check user type for redirect to correct page
        try {
             
            String sql = "SELECT user_type FROM users WHERE username='"+username+"'";
            System.out.println("HEREeeee");
            System.out.println(username);
            
            pst = lo.getConn().prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               if(rs.getString("user_type").equals("admin")){
                   System.out.println("Adminnnn");
                   Admin ad = new Admin();
                   ad.setVisible(true);    
                   System.out.println();
                   frame.dispose();
                   ad.userNameDisplay(username);
                   
//                   JOptionPane.showMessageDialog(rootPane, "You have log as admin");
               }else if(rs.getString("user_type").equals("HRM")){
                   HRM hra_Frame = new HRM();
                   hra_Frame.setVisible(true);
                   frame.dispose();
                   
                   hra_Frame.userNameDisplay(username);
                   
//                   JOptionPane.showMessageDialog(rootPane, "You have log as HR Manager");
               }else if(rs.getString("user_type").equals("HRA")){
                   HRA hrm_Frame = new HRA();
                   hrm_Frame.setVisible(true);
                   
                   frame.dispose();
                   hrm_Frame.userNameDisplay(username);
//                   JOptionPane.showMessageDialog(rootPane, "You have log as HR Assistence");
               }else{
                   
                   JOptionPane.showMessageDialog(rootPane, "Error! Contact your Adminstrator");
               }
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
        }
       
    }
    
}
