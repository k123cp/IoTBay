/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import uts.isd.model.Order;

/**
 *
 * @author ruodannayang
 */
public class OrderDAO {
    private Connection conn;

    public OrderDAO() throws SQLException, ClassNotFoundException {
        DBConnector dbConnector = new DBConnector();
        this.conn = dbConnector.openConnection();
    }

    public void addOrder(Order order) throws SQLException {
        // code to add order
    }

    public Order getOrder(String orderId) throws SQLException {
        // code to get order by id
    }

    public List<Order> getAllOrders(String userId) throws SQLException {
        // code to get all orders of a user
    }

    public void updateOrder(Order order) throws SQLException {
        // code to update order
    }

    public void deleteOrder(String orderId) throws SQLException {
        // code to delete order
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}

