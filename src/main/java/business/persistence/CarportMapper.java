package business.persistence;

import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

public class CarportMapper {
    private Database database;

    public CarportMapper(Database database) {
        this.database = database;
    }


    public void insertCarport(int height, int width, int length, int shedwidth, int shedlength) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO carport (height, width, length, shed_id) VALUES (?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                int shedId= insertShed(shedwidth, shedlength);
                ps.setInt(1, height);
                ps.setInt(2, width);
                ps.setInt(3, length);
                ps.setInt(4, shedId);


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
                int shedid = ids.getInt(1);
                return shedid;
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


