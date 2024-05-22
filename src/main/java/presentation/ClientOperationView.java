package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Provides a graphical user interface for selecting different client operations.
 * This view allows users to choose between adding, editing, deleting, and viewing client data.
 *
 * <p>The user can navigate back to the main page by clicking the "Main Page" button.</p>
 *
 * <p>The class defines buttons and labels for each operation and provides methods
 * to add ActionListener to handle user interactions.</p>
 *
 * @author [Your Name]
 * @version [Enter version or date]
 */
public class ClientOperationView {

    private JLabel textSign = new JLabel("Choose the operation you want to perform");
    private JButton addButton = new JButton("Add");
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");
    private JButton viewButton = new JButton("View");

    private JButton mainPageButton = new JButton("Main Page");

    private JFrame frame;

    /**
     * Constructs a new ClientOperationView object.
     * Initializes the graphical user interface components and sets their properties.
     */
    public ClientOperationView() {
        frame = new JFrame("CLIENT OPERATIONS");
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
     * Retrieves the JFrame associated with this view.
     *
     * @return The JFrame object.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Adds an ActionListener to the "Main Page" button.
     *
     * @param e The ActionListener to be added.
     */
    public void addHomePageListener(ActionListener e) {
        mainPageButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the "Add" button.
     *
     * @param e The ActionListener to be added.
     */
    public void addInsertListener(ActionListener e) {
        addButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the "Delete" button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDeleteListenre(ActionListener e) {
        deleteButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the "View" button.
     *
     * @param e The ActionListener to be added.
     */
    public void addViewListener(ActionListener e) {
        viewButton.addActionListener(e);
    }

    /**
     * Adds an ActionListener to the "Edit" button.
     *
     * @param e The ActionListener to be added.
     */
    public void addEditListener(ActionListener e) {
        editButton.addActionListener(e);
    }
}
