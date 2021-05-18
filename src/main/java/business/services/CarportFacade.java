package business.services;


import business.entities.Carport;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;

import java.util.List;

public class CarportFacade {
    CarportMapper carportMapper;

    public CarportFacade(Database database) {
        carportMapper = new CarportMapper(database);
    }


    public void insertCarportWithShed(int userId, int height, int width, int length, int shedwidth, int shedlength, String roofmaterial) throws UserException {
        carportMapper.insertCarportWithShed(userId, height, width, length, shedwidth, shedlength, roofmaterial);
    }

    public void insertCarportWithoutShed(int userId, int height, int width, int length, String roofmaterial) throws UserException {
        carportMapper.insertCarportWithoutShed(userId, height, width, length, roofmaterial);
    }

    public Carport getCarportById(int carportId) throws UserException {
        return carportMapper.getCarportById(carportId);
    }

    public List<Carport> getCarportByStatusId(int status) throws UserException {
        return carportMapper.getCarportByStatus(status);
    }

    public void updateCarportStatus(int status, int carportId) throws UserException {
        carportMapper.updateCarportStatus(status,carportId);
    }



}
