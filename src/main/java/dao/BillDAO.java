package dao;

import connection.ConnectionFactory;
import model.Bill;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The BillDAO class provides methods for interacting with the database
 * to perform CRUD (Create, Read, Update, Delete) operations related to bills.
 */
public class BillDAO {

    /**
     * Constructs an SQL INSERT query string based on the provided Bill object.
     *
     * @param bill The Bill object containing the data to be inserted into the database.
     * @return The SQL INSERT query string.
     */
    public String createinsertBillToTable(Bill bill) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO log (orderid, clientName, productQuantity, productName, totalPrice)");
        sb.append("VALUES (");
        sb.append(bill.billId()).append(" , ").append(" '").append(bill.clientName()).append("' ").append(" , ");
        sb.append(bill.productQuantity()).append(" , ").append(" '").append(bill.productName()).append("' ").append(" , ");
        sb.append(bill.totalPrice()).append(" ) ");
        return sb.toString();
    }

    /**
     * Inserts a Bill object into the database.
     *
     * @param bill The Bill object to be inserted into the database.
     */
    public void insertBill(Bill bill) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createinsertBillToTable(bill);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Display an error message dialog if an SQL exception occurs
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            // Close the PreparedStatement and Connection objects to release resources
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
