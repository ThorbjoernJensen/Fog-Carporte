package business.persistence;

import business.entities.Carport;
import business.exceptions.UserException;

import java.sql.*;
import java.time.LocalDateTime;

public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }


    public void carportToOrder(int carportId, int userId, double price, int orderstatus) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `order` (carport_id, price, user_id, material_list, order_date, order_status_id ) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, carportId);
                ps.setDouble(2, price);
                ps.setInt(3, userId);
                ps.setInt(4, 55);
                ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(6, orderstatus);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }
    }
}


