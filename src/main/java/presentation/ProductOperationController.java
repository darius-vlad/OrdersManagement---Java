package presentation;

import bll.ProductBLL;
import model.Client;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * The ProductOperationController class acts as a controller for managing product-related operations in the presentation layer.
 * It handles the interaction between the GUI components and the ProductBLL (Business Logic Layer) for inserting, editing, and deleting products.
 */
public class ProductOperationController {

    private ProductInsertView productInsertView;
    private ProductEditView productEditView;
    private ProductDeleteView productDeleteView;
    private ProductEditIdSelectionPage productEditIdSelectionPage;
    private ProductBLL productBLL;

    /**
     * Constructs a ProductOperationController object for inserting products.
     *
     * @param productInsertView The ProductInsertView instance representing the GUI for inserting products.
     * @param productBLL        The ProductBLL instance for handling product-related operations.
     */
    public ProductOperationController(ProductInsertView productInsertView, ProductBLL productBLL) {
        this.productInsertView = productInsertView;
        this.productBLL = productBLL;
        productInsertView.addDoneActionListener(new DoneInsertListener());
    }

    /**
     * Constructs a ProductOperationController object for deleting products.
     *
     * @param productDeleteView The ProductDeleteView instance representing the GUI for deleting products.
     * @param productBLL        The ProductBLL instance for handling product-related operations.
     */
    public ProductOperationController(ProductDeleteView productDeleteView, ProductBLL productBLL) {
        this.productDeleteView = productDeleteView;
        this.productBLL = productBLL;
        productDeleteView.addDoneListener(new DoneDeleteListener());
    }

    /**
     * Constructs a ProductOperationController object for selecting a product ID for editing.
     *
     * @param productEditIdSelectionPage The ProductEditIdSelectionPage instance representing the GUI for selecting a product ID for editing.
     * @param productBLL                 The ProductBLL instance for handling product-related operations.
     */
    public ProductOperationController(ProductEditIdSelectionPage productEditIdSelectionPage, ProductBLL productBLL) {
        this.productEditIdSelectionPage = productEditIdSelectionPage;
        this.productBLL = productBLL;
        productEditIdSelectionPage.addDoneActionListener(new DoneEditIdSelectListener());
    }

    /**
     * ActionListener implementation for handling product insertion.
     */
    class DoneInsertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product p = productInsertView.createProduct();
            try {
                productBLL.insertProduct(p);
                productInsertView.disposeFrame();
                JOptionPane.showMessageDialog(null, "Product has been created.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null , ex.getMessage());
            }


        }
    }

    /**
     * ActionListener implementation for selecting a product ID for editing.
     */
    class DoneEditIdSelectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = productEditIdSelectionPage.getInputId();
                Product product = productBLL.findProductByPid(id);
                productEditIdSelectionPage.disposePage();
                productEditView = new ProductEditView(product);
                productEditView.addDoneActionListener(new DoneEditListener());
                productEditIdSelectionPage.disposePage();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Selected PID does not exist");
            }
        }
    }

    /**
     * ActionListener implementation for editing a product.
     */
    class DoneEditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product product = productEditView.createProduct();
            int pid = product.getPid();
            try {
                productBLL.editProductByPid(product, pid);
                JOptionPane.showMessageDialog(null, "Product has been edited!");
                productEditView.disposeFrame();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null , ex.getMessage());

            }

        }
    }

    /**
     * ActionListener implementation for deleting a product.
     */
    class DoneDeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = productDeleteView.getInputId();
                Product p = productBLL.findProductByPid(id);
                productBLL.deleteProduct(id);
                JOptionPane.showMessageDialog(null, "Product with pid " + String.valueOf(id) + " has been deleted ");
                productDeleteView.disposeFrame();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Product with selected PID does not exist!");
            }
        }
    }
}
