package presentation;

import model.Client;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The ProductEditView class represents the graphical user interface (GUI) for editing a product's details.
 * It provides fields for updating the name, price, and stock of the product, along with a button to confirm the changes.
 */
public class ProductEditView {

    private Product product;
    private JFrame frame;
    private JLabel nameLabel = new JLabel("Name:");
    private JTextField nameText = new JTextField(20);
    private JLabel priceLabel = new JLabel("Price:");
    private JTextField priceText = new JTextField(20);
    private JLabel stockLabel = new JLabel("Stock : ");
    private JTextField stockText = new JTextField(20);
    private JButton doneButton = new JButton("OK");

    /**
     * Constructs a ProductEditView object.
     * Initializes the GUI components and sets up the frame.
     *
     * @param product The product object to be edited.
     */
    public ProductEditView(Product product) {
        this.product = product;
        frame = new JFrame("PRODUCT EDIT");
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
        frame.add(doneButton);
        nameText.setText(product.getPname());
        priceText.setText(String.valueOf(product.getPrice()));
        stockText.setText(String.valueOf(product.getStock()));
        nameLabel.setBounds(50, 50, 100, 30);
        nameText.setBounds(200, 50, 120, 30);
        priceLabel.setBounds(50, 100, 100, 30);
        priceText.setBounds(200, 100, 120, 30);
        stockLabel.setBounds(50, 150, 100, 30);
        stockText.setBounds(200, 150, 120, 30);
        doneButton.setBounds(135, 300, 80, 30);
    }

    /**
     * Adds an ActionListener to the 'OK' button.
     *
     * @param e The ActionListener to be added.
     */
    public void addDoneActionListener(ActionListener e) {
        doneButton.addActionListener(e);
    }

    /**
     * Disposes of the frame when the operation is completed.
     */
    public void disposeFrame() {
        frame.dispose();
    }

    /**
     * Creates and returns a new Product object with the updated details entered by the user.
     *
     * @return The updated Product object.
     */
    public Product createProduct() {
        String name = nameText.getText();
        String priceString = priceText.getText();
        String stockString = stockText.getText();
        int price = Integer.parseInt(priceString);
        int stock = Integer.parseInt(stockString);
        int pid = product.getPid();
        Product p = new Product(pid, price, name, stock);
        return p;
    }
}
