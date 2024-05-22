
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides methods for creating and managing database connections.
 *
 * <p>This class handles the creation of database connections and provides methods for closing them
 * safely. It also defines constants for the database driver, URL, username, and password.</p>
 *
 * @author Technical University of Cluj-Napoca, Romania Distributed Systems Research Laboratory
 * @since Apr 03, 2017
 * @source http://theopentutorials.com/tutorials/java/jdbc/jdbc-mysql-create-database-example/
 */
public class ConnectionFactory {

    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/online_shop_db";
    private static final String USER = "root";
    private static final String PASS = "parola_tp_2024";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Constructs a new ConnectionFactory object.
     */
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a database connection.
     *
     * @return The created database connection.
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Gets a database connection.
     *
     * @return The database connection.
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Closes a database connection.
     *
     * @param connection The connection to be closed.
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occurred while trying to close the connection");
            }
        }
    }

    /**
     * Closes a statement.
     *
     * @param statement The statement to be closed.
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occurred while trying to close the statement");
            }
        }
    }

    /**
     * Closes a ResultSet.
     *
     * @param resultSet The ResultSet to be closed.
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occurred while trying to close the ResultSet");
            }
        }
    }
}
