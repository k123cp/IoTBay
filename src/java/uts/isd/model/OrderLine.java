package uts.isd.model;

import java.io.Serializable;

/**
 * Author:  John
 * Created: 18 May 2023
 */
public class OrderLine implements Serializable{
    private int orderID;
    private int productID;
    private int quantity;
    private double price;

    public OrderLine(int orderID, int productID, int quantity, double price) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "OrderID: " + orderID + ", productID: " +productID + ", quantity: "+quantity+ ", price: " + price;
    }
}
