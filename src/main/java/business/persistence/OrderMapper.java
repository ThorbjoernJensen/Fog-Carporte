package business.persistence;

import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
import java.time.LocalDateTime;

public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;

    }

    public Order carportToOrder(Order order) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `order` (carport_id, price, user_id, material_list, order_date, order_status_id ) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1,order.getCarportId());
                ps.setDouble(2, order.getPrice());
                ps.setInt(3, order.getUserId());
                ps.setInt(4, 55);
                ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(6, order.getOrderStatusId());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                order.setOrderId(id);
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }
        return order;
    }


    public void setOrderPrice(double price, int orderId) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "UPDATE `order` SET price = ? WHERE order_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setDouble(1, price);
                ps.setInt(2, orderId);
                ps.executeUpdate();


            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }



}


