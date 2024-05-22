
package model;
/**
 * Represents an order entity with attributes such as order ID, client ID, product ID, and quantity.
 *
 * <p>This class provides methods to access and manipulate order information.</p>
 *
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 * Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: [Enter initial version or date]
 */
public class Orders {

    private int orderId;
    private int clientId;
    private int productId;
    private int quantity;

    /**
     * Constructs a new Orders object with default values.
     */
    public Orders() {
    }

    /**
     * Constructs a new Orders object with the specified order ID, client ID, product ID, and quantity.
     *
     * @param orderId   The ID of the order.
     * @param clientId  The ID of the client placing the order.
     * @param productId The ID of the product being ordered.
     * @param quantity  The quantity of the product being ordered.
     */
    public Orders(int orderId, int clientId, int productId, int quantity) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    /**
     * Constructs a new Orders object with the specified client ID, product ID, and quantity.
     *
     * @param clientId  The ID of the client placing the order.
     * @param productId The ID of the product being ordered.
     * @param quantity  The quantity of the product being ordered.
     */
    public Orders(int clientId, int productId, int quantity) {
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    /**
     * Retrieves the order ID of the order.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the order ID of the order.
     *
     * @param orderId The order ID to set.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Retrieves the client ID associated with the order.
     *
     * @return The client ID.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Sets the client ID associated with the order.
     *
     * @param clientId The client ID to set.
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Retrieves the product ID associated with the order.
     *
     * @return The product ID.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the product ID associated with the order.
     *
     * @param productId The product ID to set.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Retrieves the quantity of the product ordered.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product ordered.
     *
     * @param quantity The quantity of the product to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
