package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The OrderView class represents the graphical user interface (GUI) for managing orders.
 * It provides options to create new orders, view existing orders, and navigate back to the main page.
 */
public class OrderView {

    private JLabel orderText = new JLabel("Here you can see or create orders");
    private JButton createButton = new JButton("Create order");
    private JButton viewButton = new JButton("View orders");
    private JButton homeButton = new JButton("Main page");
    private JFrame frame;

    /**
     * Constructs an OrderView object.
     * Initializes the GUI components and sets up the frame.
     */
    public OrderView() {
        frame = new JFrame("ORDERS");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Arial", Font.PLAIN, 20);
        frame.setLayout(null);
        frame.add(orderText);
        frame.add(createButton);
        frame.add(viewButton);
        frame.add(homeButton);
        homeButton.setBounds(350, 475, 125, 50);
        homeButton.setBackground(Color.red);
        orderText.setBounds(250, 50, 500, 30);
        orderText.setFont(font);
        createButton.setBounds(50, 250, 200, 100);
        viewButton.setBounds(600, 250, 200, 100);
        frame.setVisible(false);
    }

    /**
     * Retrieves the frame associated with this OrderView.
     *
     * @return The frame containing the order-related GUI components.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Adds an ActionListener to the 'Main page' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addMainPageListener(ActionListener e) {
        homeButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the 'View orders' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addShowAllListener(ActionListener e) {
        viewButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the 'Create order' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addCreateListener(ActionListener e) {
        createButton.addActionListener(e);
    }
}
