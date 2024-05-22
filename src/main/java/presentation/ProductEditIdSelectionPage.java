package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The ProductEditIdSelectionPage class represents the graphical user interface (GUI) for selecting a product ID to edit.
 * It provides a text field for entering the product ID and a button to confirm the selection.
 */
public class ProductEditIdSelectionPage {

    private JFrame frame;
    private JButton oKButton = new JButton("OK");
    private JLabel enterLabel = new JLabel("Please enter PID:");
    private JTextField idText = new JTextField(20);

    /**
     * Constructs a ProductEditIdSelectionPage object.
     * Initializes the GUI components and sets up the frame.
     */
    public ProductEditIdSelectionPage() {
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
     * Retrieves the input product ID from the text field.
     *
     * @return The product ID entered by the user.
     */
    public int getInputId() {
        String inputText = idText.getText();
        int id = Integer.parseInt(inputText);
        return id;
    }

    /**
     * Disposes of the frame when the operation is completed.
     */
    public void disposePage() {
        frame.dispose();
    }

    /**
     * Adds an ActionListener to the 'OK' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDoneActionListener(ActionListener e) {
        oKButton.addActionListener(e);
    }
}
