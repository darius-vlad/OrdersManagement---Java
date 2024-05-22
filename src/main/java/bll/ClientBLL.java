package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.EmailValidator;
import bll.validators.ClientAgeValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

import javax.swing.*;

/**
 * The ClientBLL class represents the business logic layer for managing clients.
 * It provides methods to perform various operations such as finding clients by ID,
 * inserting, deleting, and editing clients, as well as displaying all clients.
 */
public class ClientBLL {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    /**
     * Constructs a new ClientBLL object.
     * Initializes the list of validators and creates a ClientDAO instance.
     */
    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new ClientAgeValidator());

        clientDAO = new ClientDAO();
    }

    /**
     * Finds a client by ID.
     *
     * @param id The ID of the client to find.
     * @return The found Client object.
     * @throws NoSuchElementException If the client with the specified ID is not found.
     */
    public Client findClientById(int id) {
        String field = "id";
        Client st = clientDAO.findById(id, field);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * Inserts a new client into the database.
     *
     * @param client The client to insert.
     * @throws SQLException If an SQL exception occurs.
     */
    public void insertClient(Client client) throws SQLException {
        validators.get(0).validate(client);
        validators.get(1).validate(client);
        clientDAO.insert(client);
    }

    /**
     * Retrieves all clients from the database and displays them in a JTable.
     *
     * @return A JTable containing all clients.
     */
    public JTable showAllClients() {
        List<Client> list = clientDAO.findAll();
        JTable table = clientDAO.viewAll(list);
        return table;
    }

    /**
     * Deletes a client from the database by ID.
     *
     * @param id The ID of the client to delete.
     */
    public void deleteClientById(int id) {
        clientDAO.deleteById(id);
    }

    /**
     * Edits a client in the database by ID.
     *
     * @param client The updated client object.
     * @param id     The ID of the client to edit.
     * @throws SQLException If an SQL exception occurs.
     */
    public void EditClientById(Client client, int id) throws SQLException {
        validators.get(0).validate(client);
        validators.get(1).validate(client);
        clientDAO.editById(client, id);
    }


}
