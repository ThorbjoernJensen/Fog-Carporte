package business.services;


import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class OrderFacade
{
    OrderMapper orderMapper;

    public OrderFacade(Database database)
    {
        orderMapper = new OrderMapper(database);
    }

    public Order carportToOrder (Order order) throws UserException{
        orderMapper.carportToOrder(order);
        return order;
    }


    public List<Order> getAllOrders() throws UserException {
        return orderMapper.getAllOrders();
    }
    public Order getOrderById(int orderId) throws UserException {
        return orderMapper.getOrderById(orderId);
    }

    public int deleteOrder(int order_id) throws UserException {
        return orderMapper.deleteOrder(order_id);
    }

    public int updateOrder(Double price, int order_id) throws UserException {
        return orderMapper.updateOrder(price, order_id);
    }
}
