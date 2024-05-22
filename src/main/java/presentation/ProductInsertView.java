package presentation;

import model.Product;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The ProductInsertView class represents the graphical user interface (GUI) for inserting a new product into the system.
 * It provides fields for entering the name, price, and stock of the product, along with a button to confirm the insertion.
 */
public class ProductInsertView {

    private JLabel priceLabel = new JLabel("Price : ");
    private JLabel nameLabel = new JLabel("Name : ");
    private JLabel stockLabel = new JLabel("Stock : ");
    private JTextField priceText = new JTextField(20);
    private JTextField nameText = new JTextField(20);
    private JTextField stockText = new JTextField(20);
    private JButton okButton = new JButton("DONE");
    private JFrame frame;

    /**
     * Constructs a ProductInsertView object.
     * Initializes the GUI components and sets up the frame.
     */
    public ProductInsertView() {
        frame = new JFrame("PRODUCT INSERT");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(400, 600);
        frame.add(nameLabel);
        frame.add(nameText);
        frame.add(priceLabel);
        frame.add(priceText);
        frame.add(stockLabel);
        frame.add(stockText);
        frame.add(okButton);
        nameLabel.setBounds(50, 50, 100, 30);
        nameText.setBounds(200, 50, 120, 30);
        priceLabel.setBounds(50, 100, 100, 30);
        priceText.setBounds(200, 100, 120, 30);
        stockLabel.setBounds(50, 150, 100, 30);
        stockText.setBounds(200, 150, 120, 30);
        okButton.setBounds(135, 300, 80, 30);
    }

    /**
     * Creates and returns a new Product object with the details entered by the user.
     *
     * @return The created Product object.
     */
    public Product createProduct() {
        String name = nameText.getText();
        String priceString = priceText.getText();
        String stockString = stockText.getText();
        int price = Integer.parseInt(priceString);
        int stock = Integer.parseInt(stockString);
        Product p = new Product(price, name, stock);
        return p;
    }

    /**
     * Disposes of the frame when the operation is completed.
     */
    public void disposeFrame() {
        frame.dispose();
    }

    /**
     * Adds an ActionListener to the 'DONE' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDoneActionListener(ActionListener e) {
        okButton.addActionListener(e);
    }
}
