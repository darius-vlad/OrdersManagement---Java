
package dao;

import connection.ConnectionFactory;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Provides methods to perform CRUD operations on the Product table in the database.
 *
 * <p>This class extends the AbstractDAO class and implements methods specific to the Product table.</p>
 *
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 * Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */
public class ProductDAO extends AbstractDAO<Product> {

    /**
     * Deletes a product record by its ID.
     *
     * @param id The ID of the product to be deleted.
     */
    public void deleteByPid(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = super.createDeleteQuery("pid");

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:DeleteById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Updates a product record by its ID.
     *
     * @param product The updated product object.
     * @param id      The ID of the product to be updated.
     * @throws SQLException If an SQL exception occurs.
     */
    public void editByPid(Product product, int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = super.createUpdateQuery(product, "pid");
        System.out.println(query);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:updateByPid " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
