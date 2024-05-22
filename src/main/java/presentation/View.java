package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The View class represents the graphical user interface (GUI) for the main page of the online shop.
 * It provides options to navigate to different sections of the shop, such as clients, products, and orders.
 */
public class View {

    private JLabel welcomeSign = new JLabel("Welcome to our shop");
    private JButton clientButton = new JButton("Clients");
    private JButton productButton = new JButton("Products");
    private JButton ordersButton = new JButton("Orders");
    private JFrame frame;

    /**
     * Constructs a View object.
     * Initializes the GUI components and sets up the frame.
     */
    public View() {
        frame = new JFrame("ONLINE SHOP");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Arial", Font.PLAIN, 20);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(welcomeSign);
        frame.add(clientButton);
        frame.add(productButton);
        frame.add(ordersButton);
        welcomeSign.setBounds(325, 50, 200, 30);
        welcomeSign.setFont(font);
        clientButton.setBounds(50, 250, 150, 50);
        productButton.setBounds(350, 250, 150, 50);
        ordersButton.setBounds(650, 250, 150, 50);
    }

    /**
     * Adds an ActionListener to the 'Clients' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addClientListener(ActionListener e) {
        clientButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the 'Products' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addProductListener(ActionListener e) {
        productButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the 'Orders' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addOrderListener(ActionListener e) {
        ordersButton.addActionListener(e);
    }

    /**
     * Retrieves the frame associated with this view.
     *
     * @return The JFrame object.
     */
    public JFrame getFrame() {
        return frame;
    }
}
