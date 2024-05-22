
package bll;

import dao.ProductDAO;
import model.Product;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Business logic layer for managing product operations.
 */
public class ProductBLL {

    private ProductDAO productDAO;

    /**
     * Constructs a new ProductBLL object.
     */
    public ProductBLL() {
        productDAO = new ProductDAO();
    }

    /**
     * Finds a product by its ID.
     *
     * @param id The ID of the product to find.
     * @return The product with the specified ID.
     * @throws NoSuchElementException If the product with the specified ID does not exist.
     */
    public Product findProductByPid(int id) {
        String field = "pid";
        int pid = id;
        Product p = productDAO.findById(pid, field);
        if (p == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return p;
    }

    /**
     * Retrieves all products from the database and displays them in a JTable.
     *
     * @return A JTable containing all products.
     */
    public JTable showAllProducts() {
        List<Product> list = productDAO.findAll();
        JTable table = productDAO.viewAll(list);
        return table;
    }

    /**
     * Inserts a new product into the database.
     *
     * @param p The product to be inserted.
     * @throws SQLException If an SQL exception occurs.
     */
    public void insertProduct(Product p) throws SQLException {
        if (p.getStock() < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        productDAO.insert(p);
    }

    /**
     * Deletes a product from the database by its ID.
     *
     * @param pid The ID of the product to be deleted.
     */
    public void deleteProduct(int pid) {
        productDAO.deleteByPid(pid);
    }

    /**
     * Edits a product in the database by its ID.
     *
     * @param p   The updated product information.
     * @param pid The ID of the product to be edited.
     * @throws SQLException If an SQL exception occurs.
     */
    public void editProductByPid(Product p, int pid) throws SQLException {
        if (p.getStock() < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        productDAO.editByPid(p, pid);

    }
}
