package business.services;

import business.entities.User;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;
import business.persistence.UserMapper;

public class CarportFacade
{
    CarportMapper carportMapper;

    public CarportFacade(Database database)
    {
        carportMapper = new CarportMapper(database);
    }



    public void insertHeight(int height) throws UserException {
        carportMapper.insertHeight(height);
    }


//    public User login(String email, String password) throws UserException
//    {
//        return userMapper.login(email, password);
//    }
//
//    public User createUser(String email, String password) throws UserException
//    {
//        User user = new User(email, password, "customer");
//        userMapper.createUser(user);
//        return user;
//    }

}
