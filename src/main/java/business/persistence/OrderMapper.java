package business.persistence;

import business.entities.Carport;
import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<Order> getAllOrders() throws UserException {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `order`";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int carportId = rs.getInt("carport_id");
                    double price = rs.getDouble("price");
                    int userId = rs.getInt("user_id");
                    int materialList = rs.getInt("material_list");
                    Timestamp orderDate = rs.getTimestamp("order_date");
                    int orderStatusId = rs.getInt("order_status_id");
                    orderList.add(new Order(orderId, carportId, price, userId, materialList, orderDate, orderStatusId));
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {

            throw new UserException(ex.getMessage());
        }
        return orderList;
    }

    public Order getOrderById(int orderId) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `order` WHERE order_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    int order_id = rs.getInt("order_id");
                    int carportId = rs.getInt("carport_id");
                    double price = rs.getDouble("price");
                    int userId = rs.getInt("user_id");
                    int materialList = rs.getInt("material_list");
                    Timestamp orderDate = rs.getTimestamp("order_date");
                    int orderStatusId = rs.getInt("order_status_id");
                    return new Order(order_id, carportId, price, userId, materialList, orderDate, orderStatusId);
                }
                throw new UserException("Ordren findes ikke for order_id = " + orderId);

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
    public int deleteOrder(int order_id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM `order` " +
                    "WHERE order_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                int rowaAffected = ps.executeUpdate();
                return rowaAffected;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public int updateOrder(Double price, int order_id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE `order` SET price = ? WHERE order_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setDouble(1, price);
                ps.setInt(2,order_id);
                int rowsInserted = ps.executeUpdate();
                return rowsInserted;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}


