/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uts.isd.model.User;

/**
 *
 * @author ruodannayang
 */
public class UserDAO {

    private Connection conn;

    public UserDAO() throws SQLException, ClassNotFoundException {
        DBConnector dbConnector = new DBConnector();
        this.conn = dbConnector.openConnection();
    }

    public User findUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement prepStmt = this.conn.prepareStatement(query);
        prepStmt.setString(1, username);
        prepStmt.setString(2, password);
        ResultSet rs = prepStmt.executeQuery();

        if (rs.next()) {
            return new User(
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("address")
            );
        }

        return null;
    }

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO users(name, username, email, password, address) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement prepStmt = this.conn.prepareStatement(query);
        prepStmt.setString(1, user.getName());
        prepStmt.setString(2, user.getUsername());
        prepStmt.setString(3, user.getEmail());
        prepStmt.setString(4, user.getPassword());
        prepStmt.setString(5, user.getAddress());
        prepStmt.execute();
    }

    public void updateUser(User user) throws SQLException {
        String query = "UPDATE users SET name = ?, email = ?, password = ?, address = ? WHERE username = ?";
        PreparedStatement prepStmt = this.conn.prepareStatement(query);
        prepStmt.setString(1, user.getName());
        prepStmt.setString(2, user.getEmail());
        prepStmt.setString(3, user.getPassword());
        prepStmt.setString(4, user.getAddress());
        prepStmt.setString(5, user.getUsername());
        prepStmt.execute();
    }

    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE username = ?";
        PreparedStatement prepStmt = this.conn.prepareStatement(query);
        prepStmt.setString(1, username);
        prepStmt.execute();
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
