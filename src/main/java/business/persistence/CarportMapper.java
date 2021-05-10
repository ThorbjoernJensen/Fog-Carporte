package business.persistence;

import business.entities.Carport;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

public class CarportMapper {
    private Database database;

    public CarportMapper(Database database) {
        this.database = database;
    }


    public void insertCarportWithShed(int height, int width, int length, int shedwidth, int shedlength, String roofmaterial) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO carport (height, width, length, shed_id, roof_id) VALUES (?,?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                int shedId = insertShed(shedwidth, shedlength);
                int roofId = insertRoof(roofmaterial);
                ps.setInt(1, height);
                ps.setInt(2, width);
                ps.setInt(3, length);
                ps.setInt(4, shedId);
                ps.setInt(5, roofId);
                ps.executeUpdate();

//                ResultSet ids = ps.getGeneratedKeys();
//                ids.next();
//                int id = ids.getInt(1);
//                user.setId(id);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public void insertCarportWithoutShed(int height, int width, int length, String roofmaterial) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO carport (height, width, length, roof_id) VALUES (?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                int roofId = insertRoof(roofmaterial);
                ps.setInt(1, height);
                ps.setInt(2, width);
                ps.setInt(3, length);
                ps.setInt(4, roofId);
                ps.executeUpdate();

//                ResultSet ids = ps.getGeneratedKeys();
//                ids.next();
//                int id = ids.getInt(1);
//                user.setId(id);
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
                    int roofId = rs.getInt("roof_id");
                    int height = rs.getInt("height");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int shedId = rs.getInt("shed_id");

                    return new Carport(carportId, roofId, height, length, width, shedId);
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


}


//    public void createUser(User user) throws UserException
//    {
//        try (Connection connection = database.connect())
//        {
//            String sql = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
//
//            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
//            {
//                ps.setString(1, user.getEmail());
//                ps.setString(2, user.getPassword());
//                ps.setString(3, user.getRole());
//                ps.executeUpdate();
//                ResultSet ids = ps.getGeneratedKeys();
//                ids.next();
//                int id = ids.getInt(1);
//                user.setId(id);
//            }
//            catch (SQLException ex)
//            {
//                throw new UserException(ex.getMessage());
//            }
//        }
//        catch (SQLException ex)
//        {
//            throw new UserException(ex.getMessage());
//        }
//    }
//
//    public User login(String email, String password) throws UserException
//    {
//        try (Connection connection = database.connect())
//        {
//            String sql = "SELECT id, role FROM users WHERE email=? AND password=?";
//
//            try (PreparedStatement ps = connection.prepareStatement(sql))
//            {
//                ps.setString(1, email);
//                ps.setString(2, password);
//                ResultSet rs = ps.executeQuery();
//                if (rs.next())
//                {
//                    String role = rs.getString("role");
//                    int id = rs.getInt("id");
//                    User user = new User(email, password, role);
//                    user.setId(id);
//                    return user;
//                } else
//                {
//                    throw new UserException("Could not validate user");
//                }
//            }
//            catch (SQLException ex)
//            {
//                throw new UserException(ex.getMessage());
//            }
//        }
//        catch (SQLException ex)
//        {
//            throw new UserException("Connection to database could not be established");
//        }
//    }


