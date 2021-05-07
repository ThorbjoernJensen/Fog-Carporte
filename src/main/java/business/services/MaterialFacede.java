package business.services;

import business.entities.StockInventory;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;
import business.persistence.MaterialMapper;

import java.util.List;

public class MaterialFacede {

    MaterialMapper materialMapper;

    public MaterialFacede(Database database) {
        materialMapper = new MaterialMapper(database);
    }


    public List<StockInventory> getAllMaterials() throws UserException {
        return materialMapper.getAllMaterials();
    }

}
