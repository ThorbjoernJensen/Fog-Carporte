package business.services;


import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;
import business.persistence.OrderMapper;

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

    public void setOrderPrice(double price, int orderId) throws UserException {
        orderMapper.setOrderPrice(price,orderId);
    }

}
