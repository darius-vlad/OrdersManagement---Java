package presentation;

import model.Client;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Represents the graphical user interface for inserting new client details.
 *
 * <p>This class provides methods to display a window for entering client information,
 * capturing user input, and handling the insertion operation.</p>
 *
 * @author [Your Name]
 * @version [Enter version or date]
 */
public class ClientInsertView {

    private JLabel nameLabel = new JLabel("Name : ");
    private JLabel ageLabel  = new JLabel("Age : ");
    private JLabel addressLabel = new JLabel("Address : ");
    private JLabel emailLabel = new JLabel("Email : ");
    private JTextField nameText = new JTextField(20);
    private JTextField ageText = new JTextField(20);
    private JTextField addressText = new JTextField(20);
    private JTextField emailText = new JTextField(20);
    private JButton okButton = new JButton("DONE");
    private JFrame frame;

    /**
     * Constructs a new ClientInsertView object and initializes the GUI components.
     */
    public ClientInsertView() {
        frame = new JFrame("CLIENT INSERT");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(400, 600);
        frame.add(nameLabel);
        frame.add(nameText);
        frame.add(addressLabel);
        frame.add(addressText);
        frame.add(emailLabel);
        frame.add(emailText);
        frame.add(ageLabel);
        frame.add(ageText);
        frame.add(okButton);
        nameLabel.setBounds(50, 50, 100, 30);
        nameText.setBounds(200, 50, 120, 30);
        addressLabel.setBounds(50, 100, 100, 30);
        addressText.setBounds(200, 100, 120, 30);
        emailLabel.setBounds(50, 150, 100, 30);
        emailText.setBounds(200, 150, 120, 30);
        ageLabel.setBounds(50, 200, 100, 30);
        ageText.setBounds(200, 200, 120, 30);
        okButton.setBounds(135, 300, 80, 30);
    }

    /**
     * Builds a new Client object based on the entered details.
     *
     * @return The Client object with entered details.
     */
    public Client buildClient() {
        String name = nameText.getText();
        String address = addressText.getText();
        String email = emailText.getText();
        String ageString = ageText.getText();
        int age = Integer.parseInt(ageString);
        Client c = new Client(name, address, email, age);
        return c;
    }

    /**
     * Adds an ActionListener to the "DONE" button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDoneListener(ActionListener e) {
        okButton.addActionListener(e);
    }

    /**
     * Disposes of the frame, closing the window.
     */
    public void disposeFrame() {
        frame.dispose();
    }

    /**
     * Sets the visibility of the frame to true.
     */
    public void setFrameTrue() {
        frame.setVisible(true);
    }
}
