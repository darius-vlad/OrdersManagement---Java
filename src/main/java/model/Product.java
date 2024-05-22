
package model;
/**
 * Represents a product entity with attributes such as product ID, price, name, and stock.
 *
 * <p>This class provides methods to access and manipulate product information.</p>
 *
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 * Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: [Enter initial version or date]
 */
public class Product {
    private int pid;
    private int price;
    private String pname;
    private int stock;

    /**
     * Constructs a new Product object with default values.
     */
    public Product() {
    }

    /**
     * Constructs a new Product object with the specified product ID, price, name, and stock.
     *
     * @param pid   The ID of the product.
     * @param price The price of the product.
     * @param pname The name of the product.
     * @param stock The stock quantity of the product.
     */
    public Product(int pid, int price, String pname, int stock) {
        this.pid = pid;
        this.price = price;
        this.pname = pname;
        this.stock = stock;
    }

    /**
     * Constructs a new Product object with the specified price, name, and stock.
     *
     * @param price The price of the product.
     * @param pname The name of the product.
     * @param stock The stock quantity of the product.
     */
    public Product(int price, String pname, int stock) {
        this.price = price;
        this.pname = pname;
        this.stock = stock;
    }

    /**
     * Retrieves the product ID.
     *
     * @return The product ID.
     */
    public int getPid() {
        return pid;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return The price of the product.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getPname() {
        return pname;
    }

    /**
     * Retrieves the stock quantity of the product.
     *
     * @return The stock quantity of the product.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the product ID.
     *
     * @param pid The product ID to set.
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price of the product to set.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Sets the name of the product.
     *
     * @param pname The name of the product to set.
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * Sets the stock quantity of the product.
     *
     * @param stock The stock quantity of the product to set.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return A string representation of the product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", price=" + price +
                ", pname='" + pname + '\'' +
                ", stock=" + stock +
                '}';
    }
}
