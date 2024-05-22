
package bll;

import dao.OrderDAO;
import model.Orders;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Business logic layer for managing order operations.
 */
public class OrderBLL {

    private OrderDAO orderDAO;

    /**
     * Constructs a new OrderBLL object.
     */
    public OrderBLL() {
        orderDAO = new OrderDAO();
    }

    /**
     * Retrieves all orders from the database and displays them in a JTable.
     *
     * @return A JTable containing all orders.
     */
    public JTable showAllOrders() {
        List<Orders> list = orderDAO.findAll();
        JTable table = orderDAO.viewAll(list);
        return table;
    }

    /**
     * Creates a new order and inserts it into the database.
     *
     * @param orders The order to be created.
     * @throws SQLException If an SQL exception occurs.
     */
    public void createOrder(Orders orders) throws SQLException {
        orderDAO.insert(orders);
    }
}
