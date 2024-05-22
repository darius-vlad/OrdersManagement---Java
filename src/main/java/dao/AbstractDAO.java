
package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Provides generic methods for performing CRUD operations on database tables.
 *
 * <p>This class implements generic methods for creating, reading, updating, and deleting records
 * from database tables. It uses reflection to map database table columns to Java object fields
 * and vice versa.</p>
 *
 * @param <T> The type of object managed by the DAO.
 * @Author Technical University of Cluj-Napoca, Romania Distributed Systems Research Laboratory
 * @Since Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    /**
     * Constructs a new AbstractDAO object.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Creates a SELECT query to retrieve a record by a specified field value.
     *
     * @param field The field to use in the WHERE clause.
     * @return The generated SELECT query.
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Creates a DELETE query to delete a record by a specified field value.
     *
     * @param field The field to use in the WHERE clause.
     * @return The generated DELETE query.
     */
    public String createDeleteQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Creates a SELECT query to retrieve all records from the database table.
     *
     * @return The generated SELECT query.
     */
    private String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * Creates an INSERT query to insert a new record into the database table.
     *
     * @param t The object to be inserted.
     * @return The generated INSERT query.
     */
    public String createInsertQuery(T t) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(t.getClass().getSimpleName());
        sb.append(" (");
        int firstField = 1;

        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (firstField == 1)
                firstField = 0;
            else {
                field.setAccessible(true);
                sb.append(field.getName()).append(",");
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append(") VALUES (");


        for (Field field : fields) {
            if (firstField == 0)
                firstField = 1;
            else {
                try {
                    field.setAccessible(true);
                    Object value = field.get(t);
                    if (value instanceof String) {
                        sb.append("'").append(value).append("',");
                    } else {
                        sb.append(value).append(",");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append(")");

        return sb.toString();
    }

    /**
     * Retrieves all records from the database table.
     *
     * @return A list containing all records.
     */
    public List<T> findAll() {

        List<T> list = new ArrayList<T>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            list = createObjects(resultSet);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return list;
    }

    /**
     * Retrieves a record from the database table by its ID.
     *
     * @param id    The ID of the record to retrieve.
     * @param field The field to use in the WHERE clause.
     * @return The retrieved record.
     */
    public T findById(int id, String field) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(field);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Creates objects from the ResultSet obtained from a SELECT query.
     *
     * @param resultSet The ResultSet containing the query results.
     * @return A list of objects created from the ResultSet.
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Inserts a record into the database table.
     *
     * @param t The record to be inserted.
     * @return The inserted record.
     * @throws SQLException If an SQL exception occurs.
     */
    public T insert(T t) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery(t);
        System.out.println(query);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:Insert " + e.getMessage());
            throw e;
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return t;
    }

    /**
     * Creates an UPDATE query to update a record in the database table.
     *
     * @param t              The updated record.
     * @param parameterField The field to use in the WHERE clause.
     * @return The generated UPDATE query.
     */
    public String createUpdateQuery(T t, String parameterField) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(t.getClass().getSimpleName()).append(" ");
        sb.append(" SET ");

        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;

            try {
                value = field.get(t);
                sb.append(field.getName()).append(" = ");

                if (value instanceof String) {
                    sb.append("'").append(value).append("'");
                } else {
                    sb.append(value);
                }

                sb.append(", ");

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }

        sb.append(" WHERE ").append(parameterField).append(" = ?");

        return sb.toString();
    }

    /**
     * Creates a JTable from a list of objects.
     *
     * @param list The list of objects.
     * @return The JTable containing the data from the list.
     */
    public JTable viewAll(List<T> list) {

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        T element = list.get(0);

        for (Field field : element.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            tableModel.addColumn(field.getName());
        }

        for (T item : list) {
            Object[] rowData = new Object[tableModel.getColumnCount()];
            int columnIndex = 0;
            for (Field field : item.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(item);
                    rowData[columnIndex++] = value;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            tableModel.addRow(rowData);
        }

        String[] columnNames = new String[tableModel.getColumnCount()];
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            columnNames[i] = tableModel.getColumnName(i);
        }
        tableModel.insertRow(0, columnNames);

        return table;
    }

}
