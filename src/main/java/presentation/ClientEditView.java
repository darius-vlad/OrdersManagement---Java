package presentation;

import model.Client;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Represents the graphical user interface for editing client details.
 *
 * <p>This class provides methods to display a window for editing client information,
 * capturing user input, and handling the editing operation.</p>
 *
 * @author [Your Name]
 * @version [Enter version or date]
 */
public class ClientEditView {

    private Client client;
    private JFrame frame;
    private JLabel nameLabel = new JLabel("Name:");
    private JTextField nameText = new JTextField(20);
    private JLabel addressLabel = new JLabel("Address:");
    private JTextField addressText = new JTextField(20);
    private JLabel emailLabel = new JLabel("Email : ");
    private JTextField emailText = new JTextField(20);
    private JLabel ageLabel = new JLabel("Age : ");
    private JTextField ageText = new JTextField(20);
    private JButton doneButton = new JButton("OK");

    /**
     * Constructs a new ClientEditView object and initializes the GUI components.
     *
     * @param client The client object whose details are being edited.
     */
    public ClientEditView(Client client) {
        this.client = client;
        frame = new JFrame("CLIENT EDIT");
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
        frame.add(doneButton);
        nameText.setText(client.getName());
        addressText.setText(client.getAddress());
        emailText.setText(client.getEmail());
        ageText.setText(String.valueOf(client.getAge()));
        nameLabel.setBounds(50, 50, 100, 30);
        nameText.setBounds(200, 50, 120, 30);
        addressLabel.setBounds(50, 100, 100, 30);
        addressText.setBounds(200, 100, 120, 30);
        emailLabel.setBounds(50, 150, 100, 30);
        emailText.setBounds(200, 150, 120, 30);
        ageLabel.setBounds(50, 200, 100, 30);
        ageText.setBounds(200, 200, 120, 30);
        doneButton.setBounds(135, 300, 80, 30);
    }

    /**
     * Adds an ActionListener to the "OK" button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDoneActionListener(ActionListener e) {
        doneButton.addActionListener(e);
    }

    /**
     * Builds a new Client object based on the edited details.
     *
     * @return The Client object with updated details.
     */
    public Client buildClient() {
        String name = nameText.getText();
        String address = addressText.getText();
        String email = emailText.getText();
        String ageString = ageText.getText();
        int age = Integer.parseInt(ageString);
        int id = client.getId();
        Client c = new Client(id, name, address, email, age);
        return c;
    }

    /**
     * Disposes of the frame, closing the window.
     */
    public void disposeFrame() {
        frame.dispose();
    }
}
