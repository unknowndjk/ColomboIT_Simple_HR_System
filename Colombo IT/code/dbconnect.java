
package code;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class dbconnect {
    public static Connection connect(){
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/colomboit","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.WARNING_MESSAGE);
        }
        
        return conn;
    }
}
