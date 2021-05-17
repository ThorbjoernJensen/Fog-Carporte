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

    public void carportToOrder (Order order, int status) throws UserException{
        orderMapper.carportToOrder(order,status);
    }

}
