package presentation;

import bll.ClientBLL;
import model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Controls the interaction between the presentation layer and the business logic layer
 * for client-related operations.
 *
 * <p>This class manages the user interface components associated with client operations,
 * such as insertion, deletion, and editing. It handles user input, communicates with
 * the business logic layer (ClientBLL), and updates the UI accordingly.</p>
 *
 * <p>Three inner classes are defined within this class, each implementing an ActionListener
 * interface to handle specific user actions for inserting, deleting, and editing clients.</p>
 *
 * @author [Your Name]
 * @version [Enter version or date]
 */
public class ClientOperationController {

    private ClientInsertView clientInsertView;
    private ClientDeleteView clientDeleteView;
    private ClientEditIdSelectionPage clientEditIdSelectionPage;
    private ClientEditView clientEditView;
    private ClientBLL clientBLL;

    /**
     * Constructs a new ClientOperationController object for client insertion operation.
     *
     * @param clientInsertView The ClientInsertView associated with this controller.
     * @param clientBLL        The ClientBLL instance for performing business logic operations.
     */
    public ClientOperationController(ClientInsertView clientInsertView, ClientBLL clientBLL) {
        this.clientInsertView = clientInsertView;
        this.clientBLL = clientBLL;
        clientInsertView.addDoneListener(new DoneInsertListener());
    }

    /**
     * Constructs a new ClientOperationController object for client deletion operation.
     *
     * @param clientDeleteView The ClientDeleteView associated with this controller.
     * @param clientBLL        The ClientBLL instance for performing business logic operations.
     */
    public ClientOperationController(ClientDeleteView clientDeleteView, ClientBLL clientBLL) {
        this.clientDeleteView = clientDeleteView;
        this.clientBLL = clientBLL;
        clientDeleteView.addDoneListener(new DoneDeleteListener());
    }

    /**
     * Constructs a new ClientOperationController object for client editing operation.
     *
     * @param clientEditIdSelectionPage The ClientEditIdSelectionPage associated with this controller.
     * @param clientBLL                 The ClientBLL instance for performing business logic operations.
     */
    public ClientOperationController(ClientEditIdSelectionPage clientEditIdSelectionPage, ClientBLL clientBLL) {
        this.clientEditIdSelectionPage = clientEditIdSelectionPage;
        this.clientBLL = clientBLL;
        clientEditIdSelectionPage.addDoneActionListener(new DoneEditIdSelectListener());
    }

    /**
     * ActionListener implementation for handling client insertion operation.
     */
    class DoneInsertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Client client = clientInsertView.buildClient();
                clientBLL.insertClient(client);
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null , "INVALID CLIENT");
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null, "Client has been created.");
            clientInsertView.disposeFrame();
        }
    }

    /**
     * ActionListener implementation for handling client deletion operation.
     */
    class DoneDeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = clientDeleteView.getInputId();
            try {
                Client client = clientBLL.findClientById(id);
                clientBLL.deleteClientById(id);
                JOptionPane.showMessageDialog(null, "Client with id " + id + " has been deleted ");
                clientDeleteView.disposeFrame();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Client with selected ID does not exist!");
            }
        }
    }

    /**
     * ActionListener implementation for handling client ID selection for editing operation.
     */
    class DoneEditIdSelectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = clientEditIdSelectionPage.getInputId();
                Client client = clientBLL.findClientById(id);
                clientEditIdSelectionPage.disposePage();
                clientEditView = new ClientEditView(client);
                clientEditView.addDoneActionListener(new DoneEditListener());
                clientEditIdSelectionPage.disposePage();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Selected ID does not exist");
            }
        }
    }

    /**
     * ActionListener implementation for handling client editing operation.
     */
    class DoneEditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Client client = clientEditView.buildClient();
            int id = client.getId();
            try {
                clientBLL.EditClientById(client, id);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null, "Client has been edited!");
            clientEditView.disposeFrame();
        }
    }
}
