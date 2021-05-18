package business.services;


import business.entities.Carport;
import business.entities.User;
import business.entities.materials.Dimensions;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;

import java.util.List;

public class CarportFacade
{
    CarportMapper carportMapper;

    public CarportFacade(Database database)
    {
        carportMapper = new CarportMapper(database);
    }



    public void insertCarportWithShed(int height,int width,int length, int shedwidth, int shedlength, String roofmaterial) throws UserException {
        carportMapper.insertCarportWithShed(height, width, length, shedwidth, shedlength, roofmaterial);
    }

    public void insertCarportWithoutShed(int height,int width,int length, String roofmaterial) throws UserException {
        carportMapper.insertCarportWithoutShed(height, width, length, roofmaterial);
    }

    public Carport getCarportById(int carportId) throws UserException {
        return carportMapper.getCarportById(carportId);
    }

    public List<Dimensions> getAllDimensions() throws UserException {
        return carportMapper.getAllDimensions();
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
