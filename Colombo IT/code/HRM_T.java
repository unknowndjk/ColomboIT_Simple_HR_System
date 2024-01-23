
package code;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class HRM_T extends loginU {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public HRM_T(){
        abdbconnect db = new abdbconnect();
        conn  = db.connect();
        dataWtringTXT();
    }
    //this for connetion pre chcek connctions 
    public void s(){
        System.out.println(conn);;
        System.out.println(rs);
        System.out.println(pst);
    }
    
    //Add new employee to the system
    public void addEmployee(String name,String gender, int epf_number,String emp_design, String emp_dep, JTable table){
        if(!name.equals("")){
            try {
                String sql = "SELECT dep_name FROM department WHERE dep_name = '"+emp_dep+"'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next()){
                    String sql2 = "SELECT design_name FROM designation WHERE design_name = '"+emp_design+"'";
                    pst = conn.prepareStatement(sql2);
                    rs = pst.executeQuery();
                    if(rs.next()){
                        String sql3 = "INSERT INTO employee(emp_name,emp_gender,emp_epf_num,emp_design,emp_dep) VALUES('"+name+"','"+gender+"','"+epf_number+"','"+emp_design+"','"+emp_dep+"')";
                        pst = conn.prepareStatement(sql3);
                        pst.execute();
                        JOptionPane.showMessageDialog(rootPane, "Employee ADD done");
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "That Job Position Not avaliable");
                    }
                
                }else{
                    JOptionPane.showMessageDialog(rootPane, "This department Not avilable now");
                }
            
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Enter Details First");
        }
    }
    
    //Employee database table load for the UI table
    public void empTableLoad(JTable table){
        try {
            String sql = "SELECT * FROM employee";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (Exception e) {
        }
    }
    
    //Delete employee from the system
    public void userDelate(String emp_id){
        try {
            String sql = "DELETE FROM employee WHERE emp_id = '"+emp_id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "User Delated!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //Update employee
     public void update(int id , String name,String gender, int epf_number,String emp_design, String emp_dep, JTable table){
        System.out.println(id);
        try {
           String sql = "UPDATE employee SET emp_name='"+name+"',emp_gender = '"+gender+"',emp_epf_num='"+epf_number+"',emp_design='"+emp_design+"',emp_dep='"+emp_dep+"' WHERE emp_id = '"+id+"' LIMIT 1";
           pst = conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(rootPane, "User Updated"); 
           empTableLoad(table);
                 
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
     
    //search employee with EPF number,with Department,With Designation,ID,Name
    public void searchEmpolyees(String search, JTable table, JRadioButton btn1 , JRadioButton btn2,JRadioButton btn3,JRadioButton btn4,JRadioButton btn5){
        try {
            if(btn1.isSelected()){
                String sql1 = "SELECT * FROM employee WHERE emp_id LIKE '%"+search+"%'";
                pst = conn.prepareStatement(sql1);
                rs = pst.executeQuery();
            }else if(btn2.isSelected()){
                String sql2 = "SELECT * FROM employee WHERE emp_design LIKE '%"+search+"%'";
                pst = conn.prepareStatement(sql2);
                rs = pst.executeQuery();
            }else if(btn3.isSelected()){
                String sql3 = "SELECT * FROM employee WHERE emp_epf_num LIKE '%"+search+"%'";
                pst = conn.prepareStatement(sql3);
                rs = pst.executeQuery();
            }else if(btn4.isSelected()){
                String sql4 = "SELECT * FROM employee WHERE emp_dep LIKE '%"+search+"%'";
                pst = conn.prepareStatement(sql4);
                rs = pst.executeQuery();
            }else if(btn5.isSelected()){
                String sql5 = "SELECT * FROM employee WHERE emp_name LIKE '%"+search+"%'";
                pst = conn.prepareStatement(sql5);
                rs = pst.executeQuery();
            }else{
                String sql = "SELECT * FROM employee WHERE emp_name LIKE '%"+search+"%'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
           
            }
        
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setModel(table.getModel());
     
                
                   
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Department database table load for the UI table
    public void depTableLoead(JTable table){
        try {
            String sql = "SELECT * FROM department";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
        
    }
    
    //ADD new Department
    public void addDepartment(String dep_name){
        try {
            String sql = "INSERT INTO department(dep_name) VALUES('"+dep_name+"') ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "DEP ADD DONE");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //Update Deparment
    public void updateDep(int dep_id, String dep_name){
        try {
            String sql = "UPDATE department SET dep_name = '"+dep_name+"' WHERE dep_id = '"+dep_id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Employee done update");
        } catch (Exception e) {
        }
          
    }
    
    //Delete Department
    public void depDelate(int dep_id){
        try {
            String sql = "DELETE FROM department WHERE dep_id = '"+dep_id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "User Delated!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
    //Designation database table load for the UI table
    public void designTableLoead(JTable table){
        try {
            String sql = "SELECT * FROM designation";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
        }
    } 
    
    //ADD new designation
    public void addDesignation(String design_name){
        try {
            String sql = "INSERT INTO designation(design_name) VALUES('"+design_name+"') ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Design ADD DONE");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //Update Designation
    public void updateDesign(int design_id, String design_name){
        try {
            String sql = "UPDATE designation SET design_name = '"+design_name+"' WHERE design_id = '"+design_id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Employee done update");
        } catch (Exception e) {
        }
          
    }
    
    //Delate designation
    public void designDelate(int design_id){
        try {
            String sql = "DELETE FROM designation WHERE design_id = '"+design_id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "User Delated!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void dataWtringTXT(){
        try {
            String sql = "SELECT * FROM users WHERE user_type = 'HRA'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("ID" + "\t" + "Name" + "\t" + "UserName" + "\t" + "User Type" + "\n\n");
            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(5) + "\n" );
                try {
                    
                    writer.write(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(5) + "\n");
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
            writer.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void getTxtFile(){
        try {
            // Specify the command to open Notepad with the file
            String command = "notepad.exe output.txt";

            // Execute the command
            Process process = Runtime.getRuntime().exec(command);

            // Optionally, wait for the process to exit
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
