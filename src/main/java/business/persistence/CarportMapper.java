package business.persistence;

import business.entities.Carport;
import business.entities.materials.Dimensions;

import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper {
    private Database database;

    public CarportMapper(Database database) {
        this.database = database;
    }


    public void insertCarportWithShed(int userId, int height, int width, int length, int shedwidth, int shedlength, String roofmaterial) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO carport (user_id, height, width, length, shed_id, roof_id, carport_status_id) VALUES (?,?,?,?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                int shedId = insertShed(shedwidth, shedlength);
                int roofId = insertRoof(roofmaterial);
                ps.setInt(1, userId);
                ps.setInt(2, height);
                ps.setInt(3, width);
                ps.setInt(4, length);
                ps.setInt(5, shedId);
                ps.setInt(6, roofId);
                ps.setInt(7, 1);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public void insertCarportWithoutShed(int userId, int height, int width, int length, String roofmaterial) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO carport (user_id, height, width, length, roof_id, carport_status_id) VALUES (?,?,?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                int roofId = insertRoof(roofmaterial);
                ps.setInt(1, userId);
                ps.setInt(2, height);
                ps.setInt(3, width);
                ps.setInt(4, length);
                ps.setInt(5, roofId);
                ps.setInt(6, 1);
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
                    int userId = rs.getInt("user_id");
                    int roofId = rs.getInt("roof_id");
                    int height = rs.getInt("height");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int shedId = rs.getInt("shed_id");
                    int status = rs.getInt("carport_status_id");

                    return new Carport(carportId, roofId, height, length, width, shedId, userId, status);

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
        List<Carport> carportList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM carport WHERE carport_status_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, status);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carportId = rs.getInt("carport_id");
                    int roofId = rs.getInt("roof_id");
                    int height = rs.getInt("height");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int shedId = rs.getInt("shed_id");
                    int userId = rs.getInt("user_id");


                    carportList.add(new Carport(carportId, roofId, height, length, width, shedId, userId, status));
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {

            throw new UserException(ex.getMessage());
        }
        return carportList;
    }


    public int updateCarportStatus(int status, int carportId) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE carport SET carport_status_id = ? WHERE carport_id =?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, status);
                ps.setInt(2, carportId);
                int rowsInserted = ps.executeUpdate();
                return rowsInserted;

            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public List<Dimensions> getAllDimensions() throws UserException {
        List<Dimensions> dimensionsList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM dimensions";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int id = rs.getInt("id");
                    int height = rs.getInt("height");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    dimensionsList.add(new Dimensions(id, height, length, width));

                }
                return dimensionsList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }


    public List<Carport> getCarportByUser(int userId) throws UserException {
        List<Carport> userCarportList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM carport WHERE user_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carportId = rs.getInt("carport_id");
                    int roofId = rs.getInt("roof_id");
                    int height = rs.getInt("height");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int shedId = rs.getInt("shed_id");
                    userId = rs.getInt("user_id");
                    int status = rs.getInt("carport_status_id");

                    userCarportList.add(new Carport(carportId, roofId, height, length, width, shedId, userId, status));
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        return userCarportList;
    }

    public boolean deleteCarport(int carportId) throws UserException {
        boolean result = false;
        String sql = "delete from carport where carport_id = ?";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, carportId);
                ps.executeUpdate();
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
            }
            return result;
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
