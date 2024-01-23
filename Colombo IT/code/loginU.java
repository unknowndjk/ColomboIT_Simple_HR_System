
package code;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import code.dbconnect;
import javax.swing.JOptionPane;
import inf.login;
import inf.Admin;

public class loginU extends login {
  private ResultSet rs = null;
  private PreparedStatement pst = null;
  private Connection conn = null;

  public loginU() {
     abdbconnect db = new abdbconnect();
     conn  = db.connect();
  }

  // Check Login
  public void login_Check(String username, String password, login frame) {
    try {
      String sql = "SELECT * from users WHERE username='" + username + "' AND password='" + password + "'";
      pst = (PreparedStatement) conn.prepareStatement(sql);
      rs = pst.executeQuery();
      if (rs.next()) {
        System.out.println("Login success");
        JOptionPane.showMessageDialog(frame, "Login Success!");
        //pass username to check usertype from the user class
        user us = new user();
        us.userRedirect(username,frame);
      } else {
        JOptionPane.showMessageDialog(frame, "Username or Password Incorrect!");
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }

  // Getter for connection
  public Connection getConn() {
    return conn;
  }
  
//  public PreparedStatement getpst() {
//    return pst;
//  }

  // Setter for connection
  public void setPst(PreparedStatement pst) {
    this.pst = pst;
  }
}