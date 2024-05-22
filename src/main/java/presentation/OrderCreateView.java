package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The OrderCreateView class represents the graphical user interface (GUI) for creating orders.
 * It provides fields for entering client ID, product ID, and quantity, along with a button to submit the order.
 * This class utilizes Swing components for building the interface.
 */
public class OrderCreateView {

    private JLabel productIdLabel = new JLabel("Product ID : ");
    private JLabel clientIDLabel  = new JLabel("Client ID : ");
    private JLabel quantityLabel = new JLabel("Quantity : ");

    private JTextField clientIdText = new JTextField(20);
    private JTextField productIdText = new JTextField(20);
    private JTextField quantityText = new JTextField(20);

    private JButton okButton = new JButton("DONE");

    private JFrame frame;

    /**
     * Constructs an OrderCreateView object.
     * Initializes the GUI components and sets up the frame.
     */
    public OrderCreateView() {
        // Frame setup
        frame = new JFrame("CREATE ORDER");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(400, 600);

        // Adding components to the frame
        frame.add(productIdLabel);
        frame.add(productIdText);
        frame.add(clientIDLabel);
        frame.add(clientIdText);
        frame.add(quantityLabel);
        frame.add(quantityText);
        frame.add(okButton);

        // Setting bounds for components
        clientIDLabel.setBounds(50, 50, 100, 30);
        clientIdText.setBounds(200, 50, 120, 30);
        productIdLabel.setBounds(50, 100, 100, 30);
        productIdText.setBounds(200, 100, 120, 30);
        quantityLabel.setBounds(50, 150, 100, 30);
        quantityText.setBounds(200, 150, 120, 30);
        okButton.setBounds(135, 300, 80, 30);
    }

    /**
     * Retrieves the input client ID from the text field.
     *
     * @return The client ID entered by the user.
     */
    public int getInputClientId() {
        String idString = clientIdText.getText();
        int id = Integer.parseInt(idString);
        return id;
    }

    /**
     * Retrieves the input product ID from the text field.
     *
     * @return The product ID entered by the user.
     */
    public int getInputProductId() {
        String pidString = productIdText.getText();
        int pid = Integer.parseInt(pidString);
        return pid;
    }

    /**
     * Retrieves the input quantity from the text field.
     *
     * @return The quantity entered by the user.
     */
    public int getInputQuantity() {
        String quantityString = quantityText.getText();
        int quantity = Integer.parseInt(quantityString);
        return quantity;
    }

    /**
     * Adds an ActionListener to the 'DONE' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDoneListener(ActionListener e) {
        okButton.addActionListener(e);
    }

    /**
     * Disposes of the frame when the operation is completed.
     */
    public void disposeFrame() {
        frame.dispose();
    }
}
