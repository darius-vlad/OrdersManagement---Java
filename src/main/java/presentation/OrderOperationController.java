package presentation;

import bll.*;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * The OrderOperationController class handles the interaction between the OrderCreateView GUI and the business logic layer.
 * It listens for user actions, such as creating an order, and communicates with the BLL (Business Logic Layer) to perform the necessary operations.
 */
public class OrderOperationController {

    private OrderBLL orderBLL;
    private ClientBLL clientBLL;
    private ProductBLL productBLL;


    private BillBLL billBLL;
    private OrderCreateView orderCreateView;

    /**
     * Constructs an OrderOperationController object.
     *
     * @param orderCreateView The OrderCreateView instance representing the GUI for order creation.
     * @param orderBLL        The business logic layer for handling order-related operations.
     * @param productBLL      The business logic layer for handling product-related operations.
     * @param clientBLL       The business logic layer for handling client-related operations.
     * @param billBLL         The business logic layer for handling log-related operations.
     */
    public OrderOperationController(OrderCreateView orderCreateView, OrderBLL orderBLL, ProductBLL productBLL, ClientBLL clientBLL, BillBLL billBLL) {
        this.orderCreateView = orderCreateView;
        this.orderBLL = orderBLL;
        this.productBLL = productBLL;
        this.clientBLL = clientBLL;
        this.billBLL = billBLL;
        orderCreateView.addDoneListener(new DoneCreateListener());
    }

    /**
     * ActionListener implementation for handling the 'DONE' button click event.
     */
    class DoneCreateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Retrieving input data from the view
            int id = orderCreateView.getInputClientId();
            int pid = orderCreateView.getInputProductId();
            int quantity = orderCreateView.getInputQuantity();

            // Retrieving client and product information from BLL
            Client client = clientBLL.findClientById(id);
            Product product = productBLL.findProductByPid(pid);

            // Checking if requested quantity exceeds available stock
            if (quantity > product.getStock()) {
                JOptionPane.showMessageDialog(null, "Requested quantity is over the item stock");
            } else {
                // Creating order and updating product stock
                Orders orders = new Orders(id, pid, quantity);
                try {
                    orderBLL.createOrder(orders);
                    Product p2 = new Product(pid, product.getPrice(), product.getPname(), product.getStock() - quantity);
                    productBLL.editProductByPid(p2, pid);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                // Displaying order creation message and updating logs
                JOptionPane.showMessageDialog(null, "ORDER HAS BEEN CREATED!");
                orderCreateView.disposeFrame();
                int randomInteger = (int) (Math.random() * 100);
                Bill bill = new Bill(randomInteger, client.getName(), quantity, product.getPname(), quantity * product.getPrice());
                billBLL.insertBill(bill);
                bill.createLogFile();
            }
        }
    }
}

