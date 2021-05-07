package business.persistence;

import business.entities.StockInventory;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialMapper {

    private Database database;

    public MaterialMapper(Database database) {
        this.database = database;
    }

    public List<StockInventory> getAllMaterials() throws UserException {

        List<StockInventory> stockInventories = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM material";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int materialId = rs.getInt("material_id");
                    String materialDescription = rs.getString("material_description");
                    String materialByLenght = rs.getString("material_lenght");
                    int quantity = rs.getInt("quantity");
                    int unitId = rs.getInt("unittype_id");
                    Double pricePrMtr = rs.getDouble("price");
                    String placementDescription = rs.getString("placemet_description");
                    stockInventories.add(new StockInventory(materialId, materialDescription, materialByLenght, quantity, unitId, pricePrMtr, placementDescription));
                }
                return stockInventories;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }




}
