package business.entities;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int carportId;
    private int userId;
    private double price;
    private Timestamp orderDate;
    private int orderStatusId;

    public Order(int orderId, int carportId, int userId, double price, Timestamp orderDate, int orderStatusId) {
        this.orderId = orderId;
        this.carportId = carportId;
        this.userId = userId;
        this.price = price;
        this.orderDate = orderDate;
        this.orderStatusId = orderStatusId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCarportId() {
        return carportId;
    }

    public void setCarportId(int carportId) {
        this.carportId = carportId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
}
