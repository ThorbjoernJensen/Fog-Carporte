package business.entities;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int carportId;
    private double price;
    private int userId;
    private int materialList;
    private Timestamp orderDate;
    private int orderStatusId;

    public Order(int orderId, int carportId, double price, int userId, int materialList, Timestamp orderDate, int orderStatusId) {
        this.orderId = orderId;
        this.carportId = carportId;
        this.price = price;
        this.userId = userId;
        this.materialList = materialList;
        this.orderDate = orderDate;
        this.orderStatusId = orderStatusId;
    }

    public Order(int carportId, int userId, double price, Timestamp orderDate, int orderStatusId) {
        this.carportId = carportId;
        this.userId = userId;
        this.price = price;
        this.orderDate = orderDate;
        this.orderStatusId = orderStatusId;
    }

    public Order(int carportId, int userId, double price, int orderStatusId) {
        this.carportId = carportId;
        this.userId = userId;
        this.price = price;
        this.orderStatusId = orderStatusId;
    }

    public int getMaterialList() {
        return materialList;
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

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
}
