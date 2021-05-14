package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String name, String email, String password, String address, String zip) throws UserException
    {
        User user = new User(name, email, password, "customer", address, zip);
        userMapper.createUser(user);
        return user;
    }

}
