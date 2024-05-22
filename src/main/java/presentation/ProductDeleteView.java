package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The ProductDeleteView class represents the graphical user interface (GUI) for deleting a product.
 * It provides a text field for entering the product ID to be deleted and a button to confirm the deletion.
 */
public class ProductDeleteView {

    private JLabel deleteLabel = new JLabel("Select product id to delete");
    private JTextField deleteText = new JTextField(20);
    private JButton doneButton = new JButton("Done");
    private JFrame frame;

    /**
     * Constructs a ProductDeleteView object.
     * Initializes the GUI components and sets up the frame.
     */
    public ProductDeleteView() {
        frame = new JFrame("DELETE PRODUCT");
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
     * Adds an ActionListener to the 'Done' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDoneListener(ActionListener e) {
        doneButton.addActionListener(e);
    }

    /**
     * Retrieves the input product ID from the text field.
     *
     * @return The product ID entered by the user.
     */
    public int getInputId() {
        String idText = deleteText.getText();
        int id = Integer.parseInt(idText);
        return id;
    }

    /**
     * Disposes of the frame when the operation is completed.
     */
    public void disposeFrame() {
        frame.dispose();
    }
}
