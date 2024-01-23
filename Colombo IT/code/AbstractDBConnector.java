package code;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

// abstract class for database connection
public abstract class AbstractDBConnector {


    public abstract Connection connect();
}


