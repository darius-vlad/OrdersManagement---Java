package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Represents the graphical user interface for deleting a client.
 *
 * <p>The class provides methods to display a window for selecting a client ID to delete,
 * capturing user input, and handling the deletion operation.</p>
 *
 * @author [Your Name]
 * @version [Enter version or date]
 */
public class ClientDeleteView {
    private JLabel deleteLabel = new JLabel("Select client id to delete");
    private JTextField deleteText = new JTextField(20);
    private JButton doneButton = new JButton("Done");
    private JFrame frame;

    /**
     * Constructs a new ClientDeleteView object and initializes the GUI components.
     */
    public ClientDeleteView() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.add(deleteLabel);
        frame.add(deleteText);
        frame.add(doneButton);
        deleteLabel.setBounds(30, 50, 150, 30);
        deleteText.setBounds(200, 50, 100, 30);
        doneButton.setBounds(135, 200, 80, 40);
    }

    /**
     * Adds an ActionListener to the "Done" button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDoneListener(ActionListener e) {
        doneButton.addActionListener(e);
    }

    /**
     * Retrieves the ID entered by the user for deletion.
     *
     * @return The ID entered by the user.
     */
    public int getInputId() {
        String idText = deleteText.getText();
        int id = Integer.parseInt(idText);
        return id;
    }

    /**
     * Sets the visibility of the frame to true.
     */
    public void setFrameTrue() {
        frame.setVisible(true);
    }

    /**
     * Disposes of the frame, closing the window.
     */
    public void disposeFrame() {
        frame.dispose();
    }
}
