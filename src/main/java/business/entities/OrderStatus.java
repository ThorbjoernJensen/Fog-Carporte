package business.entities;

public class OrderStatus {

    private int orderId;
    private int carportId;
    private int userId;
    private int orderStatusId;
    private String orderStatusText;

    public int getOrderId() {
        return orderId;
    }

    public int getCarportId() {
        return carportId;
    }

    public int getUserId() {
        return userId;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }
}
