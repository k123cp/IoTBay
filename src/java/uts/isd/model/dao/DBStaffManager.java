package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uts.isd.model.Staff;

/**
 * Author:  John
 * Created: 18 May 2023
 */
public class DBStaffManager {
    
    private Connection conn;
    
    public DBStaffManager(Connection conn) throws SQLException {
        this.conn = conn;
    }
    
    // find staff by email
    public Staff findStaff(String email) throws SQLException {
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM tblUser INNER JOIN tblStaff ON tblUser.User_ID = tblStaff.Staff_ID WHERE Email_Address = ?");
        selectStatement.setString(1, email);
        ResultSet rs = selectStatement.executeQuery();
        
        while (rs.next()){
            int userid = rs.getInt(1);
            String user_email = rs.getString(2);
            String fname = rs.getString(3);
            String lname = rs.getString(4);
            String phone_number = rs.getString(5);
            String password = rs.getString(7);
            String staff_number = rs.getString(8);
            boolean is_Activated = rs.getBoolean(9);
           
            System.out.println("hello"+ user_email);
           return new Staff(userid, user_email, fname, lname, phone_number, password, staff_number, is_Activated);
       }
       selectStatement.close();
       throw new SQLException("No such staff exists.");
    }
    
    // add staff details to database
    public void addStaff (String email, String fname, String lname, String phoneno, String password, String staff_number, boolean is_Activated) throws SQLException {
        // insert into user table
        PreparedStatement insertStatement = conn.prepareStatement("INSERT INTO tblUser(Email_Address, First_Name, Last_Name, Phone_Number) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        insertStatement.setString(1, email);
        insertStatement.setString(2, fname);
        insertStatement.setString(3, lname);
        insertStatement.setString(4, phoneno);
         
        insertStatement.executeUpdate();
        
        int id;
        
        try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);   
            }
            else {
                insertStatement.close();
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
        
        insertStatement.close();
        // based on id from user table, insert the remaining info into staff table
        PreparedStatement insertStatement1 = conn.prepareStatement("INSERT INTO tblStaff(Staff_ID, Password, staff_number, Is_Activated) VALUES (?,?,?,?)");
        insertStatement1.setInt(1,id);
        insertStatement1.setString(2, password);
        insertStatement1.setString(3, staff_number);
        insertStatement1.setBoolean(4, is_Activated);
        
        insertStatement1.executeUpdate();
        insertStatement1.close();
    }
    
    // update staff by user id
    public void updateStaff(int id, String fname, String lname, String phoneno, String password, String staff_number) throws SQLException {
        PreparedStatement updateStatement = conn.prepareStatement("UPDATE tblUser SET First_Name = ?, Last_Name = ?, Phone_Number = ? WHERE User_ID = ?");
        updateStatement.setString(1, fname);
        updateStatement.setString(2, lname);
        updateStatement.setString(3, phoneno);
        updateStatement.setInt(4, id);
         
        updateStatement.executeUpdate();
        updateStatement.close();
        
        PreparedStatement updateStatement1 = conn.prepareStatement("UPDATE tblStaff SET Password = ?, Staff_Number = ? WHERE Staff_ID = ?");
        updateStatement1.setString(1, password);
        updateStatement1.setString(2, staff_number);
        updateStatement1.setInt(3, id);
        
        updateStatement1.executeUpdate();
        updateStatement1.close();
    }
    
    // delete the staff from database
    public void deleteStaff(int id) throws SQLException {
        PreparedStatement updateStatement = conn.prepareStatement("UPDATE tblStaff SET Is_Activated = False WHERE Staff_ID = ?");
        updateStatement.setInt(1, id);
        
        updateStatement.executeUpdate();
        updateStatement.close();
    }
}
