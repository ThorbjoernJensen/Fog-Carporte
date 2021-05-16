package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;

public class UserMapper {
    private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

    //Denne funktion virker ikke på nuværende, mangler passende navne
    public void createUser(User user) throws UserException {
        try (Connection connection = database.connect()) {
            String sqlZip = "INSERT INTO zip (zip, city) VALUES (?,?)";
            try (PreparedStatement ps1 = connection.prepareStatement(sqlZip, Statement.RETURN_GENERATED_KEYS)) {
                ps1.setString(1, user.getZip());
                ps1.setString(2, user.getAddress());
                ps1.executeUpdate();
            }
            String sql = "INSERT INTO user (name, email, tlf, password, role, address, zip) VALUES (?, ?, ?, ?, ?,?,? )";
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setInt(3, user.getTlf());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getRole());
                ps.setString(6, user.getAddress());
                ps.setString(7, user.getZip());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setUserId(id);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT user_id, role FROM user WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    int userId = rs.getInt("user_id");
                    User user = new User(email, password, role);
                    user.setUserId(userId);
                    return user;
                } else {
                    throw new UserException("Could not validate user");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

}
