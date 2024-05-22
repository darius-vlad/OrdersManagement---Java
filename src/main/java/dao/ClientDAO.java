
package dao;

import connection.ConnectionFactory;
import model.Client;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Provides methods to perform CRUD operations on the Client table in the database.
 *
 * <p>This class extends the AbstractDAO class and implements client-specific methods for deleting
 * and updating client records.</p>
 *
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 * Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */
public class ClientDAO extends AbstractDAO<Client> {

    // uses basic CRUD methods from superclass

    // TODO: create only client specific queries

    /**
     * Deletes a client record by its ID.
     *
     * @param id The ID of the client to be deleted.
     */
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = super.createDeleteQuery("id");

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:DeleteById " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Updates a client record by its ID.
     *
     * @param client The updated client object.
     * @param id     The ID of the client to be updated.
     * @throws SQLException If an SQL exception occurs.
     */
    public void editById(Client client, int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = super.createUpdateQuery(client, "id");
        System.out.println(query);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:updateById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

}
