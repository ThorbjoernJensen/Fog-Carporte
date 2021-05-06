package business.services;

import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;

public class CarportFacade
{
    CarportMapper carportMapper;

    public CarportFacade(Database database)
    {
        carportMapper = new CarportMapper(database);
    }



    public void insertCarport(int height,int width,int length, int shedwidth, int shedlength) throws UserException {
        carportMapper.insertCarport(height, width, length, shedwidth, shedlength);
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
