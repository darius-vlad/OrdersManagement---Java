package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The ProductOperationView class represents the graphical user interface (GUI) for selecting product operations.
 * It provides options to add, edit, delete, and view products, along with a button to navigate to the main page.
 */
public class ProductOperationView {

    private JLabel textSign = new JLabel("Choose the operation you want to perform");
    private JButton addButton = new JButton("Add");
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");
    private JButton viewButton = new JButton("View");
    private JButton mainPageButton = new JButton("Main Page");
    private JFrame frame;

    /**
     * Constructs a ProductOperationView object.
     * Initializes the GUI components and sets up the frame.
     */
    public ProductOperationView() {
        frame = new JFrame("PRODUCT OPERATIONS");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Arial", Font.PLAIN, 20);
        frame.setLayout(null);
        frame.setVisible(false);
        frame.add(textSign);
        frame.add(addButton);
        frame.add(editButton);
        frame.add(deleteButton);
        frame.add(viewButton);
        frame.add(mainPageButton);
        textSign.setBounds(230, 50, 500, 30);
        textSign.setFont(font);
        addButton.setBounds(50, 250, 125, 50);
        editButton.setBounds(250, 250, 125, 50);
        deleteButton.setBounds(450, 250, 125, 50);
        viewButton.setBounds(650, 250, 125, 50);
        mainPageButton.setBounds(350, 475, 125, 50);
        mainPageButton.setBackground(Color.red);
    }

    /**
     * Retrieves the frame associated with this view.
     *
     * @return The JFrame object.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Adds an ActionListener to the 'Main Page' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addHomePageListener(ActionListener e) {
        mainPageButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the 'Add' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addInsertListener(ActionListener e) {
        addButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the 'Delete' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDeleteListenre(ActionListener e) {
        deleteButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the 'View' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addViewListener(ActionListener e) {
        viewButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the 'Edit' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addEditListener(ActionListener e) {
        editButton.addActionListener(e);
    }
}
