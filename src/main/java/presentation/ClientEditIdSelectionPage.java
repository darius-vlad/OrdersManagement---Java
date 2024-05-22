package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Represents the graphical user interface for selecting a client ID for editing.
 *
 * <p>This class provides methods to display a window for entering a client ID to be edited,
 * capturing user input, and handling the selection operation.</p>
 *
 * @author [Your Name]
 * @version [Enter version or date]
 */
public class ClientEditIdSelectionPage {

    private JFrame frame;
    private JButton oKButton = new JButton("OK");
    private JLabel enterLabel = new JLabel("Please enter ID:");
    private JTextField idText = new JTextField(20);

    /**
     * Constructs a new ClientEditIdSelectionPage object and initializes the GUI components.
     */
    public ClientEditIdSelectionPage() {
        frame = new JFrame("EDIT ID SELECTION");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(300, 200);
        frame.add(oKButton);
        frame.add(enterLabel);
        frame.add(idText);
        oKButton.setBounds(100, 120, 100, 30);
        enterLabel.setBounds(20, 30, 100, 30);
        idText.setBounds(130, 30, 100, 30);
    }

    /**
     * Retrieves the ID entered by the user for editing.
     *
     * @return The ID entered by the user.
     */
    public int getInputId() {
        String inputText = idText.getText();
        int id = Integer.parseInt(inputText);
        return id;
    }

    /**
     * Disposes of the page, closing the window.
     */
    public void disposePage() {
        frame.dispose();
    }

    /**
     * Adds an ActionListener to the "OK" button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDoneActionListener(ActionListener e) {
        oKButton.addActionListener(e);
    }
}
