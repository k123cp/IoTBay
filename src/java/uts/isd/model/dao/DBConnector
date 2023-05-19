package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private String URL = "jdbc:derby://localhost:1527/ass3DB"; //replace "iotbaydb" with your database name
    private String dbUser = "test";  //replace with your database username
    private String dbPass = "test";  //replace with your database password
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private Connection conn;

    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(URL, dbUser, dbPass);
    }

    public Connection openConnection(){
        return this.conn;
    }  

    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
