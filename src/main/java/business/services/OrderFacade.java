package business.services;


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

    public void carportToOrder (int carportId, int userId, double price, int status) throws UserException{
        orderMapper.carportToOrder(carportId, userId, price, status);
    }

}
