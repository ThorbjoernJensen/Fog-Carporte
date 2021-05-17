package business.persistence;

import business.entities.Carport;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper {
    private Database database;

    public CarportMapper(Database database) {
        this.database = database;
    }


    public void insertCarportWithShed(int tlf, int height, int width, int length, int shedwidth, int shedlength, String roofmaterial) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO carport (tlf, height, width, length, shed_id, roof_id) VALUES (?,?,?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                int shedId = insertShed(shedwidth, shedlength);
                int roofId = insertRoof(roofmaterial);
                ps.setInt(1, tlf);
                ps.setInt(2, height);
                ps.setInt(3, width);
                ps.setInt(4, length);
                ps.setInt(5, shedId);
                ps.setInt(6, roofId);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public void insertCarportWithoutShed(int tlf, int height, int width, int length, String roofmaterial) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO carport (tlf, height, width, length, roof_id) VALUES (?,?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                int roofId = insertRoof(roofmaterial);
                ps.setInt(1, tlf);
                ps.setInt(2, height);
                ps.setInt(3, width);
                ps.setInt(4, length);
                ps.setInt(5, roofId);
                ps.executeUpdate();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }


    public int insertShed(int shedwidth, int shedlength) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO shed (width, length) VALUES (?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, shedwidth);
                ps.setInt(2, shedlength);
                ps.executeUpdate();

                ResultSet ids = ps.getGeneratedKeys();
                ids.next();

                return ids.getInt(1);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }


    public Carport getCarportById(int carportId) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM carport WHERE carport_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, carportId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int tlf = rs.getInt("tlf");
                    int roofId = rs.getInt("roof_id");
                    int height = rs.getInt("height");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int shedId = rs.getInt("shed_id");

                    return new Carport(carportId, tlf, roofId, height, length, width, shedId);
                }
                throw new UserException("Carporten findes ikke");


            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {

            throw new UserException(ex.getMessage());
        }
    }

    public int insertRoof(String materials) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO roof (materials) VALUES (?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, materials);
                ps.executeUpdate();

                ResultSet ids = ps.getGeneratedKeys();
                ids.next();

                return ids.getInt(1);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public List<Carport> getCarportByStatus(int status) throws UserException {
        List<Carport> carportList=new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM carport WHERE carport_status_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, status);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int carportId = rs.getInt("carport_id");
                    int roofId = rs.getInt("roof_id");
                    int height = rs.getInt("height");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int shedId = rs.getInt("shed_id");
                    int tlf = rs.getInt("tlf");
                    carportList.add(new Carport(carportId,roofId,height,length,width,shedId,tlf,status));
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {

            throw new UserException(ex.getMessage());
        }
        return carportList;
    }

}