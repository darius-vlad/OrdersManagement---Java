package presentation;

import bll.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The Controller class serves as the main controller for the application, coordinating interactions between
 * the user interface views and the business logic layers. It handles user actions such as selecting different
 * operations for clients, products, and orders. This class also instantiates the necessary controllers for
 * specific operations.
 * <p>
 * The Controller class contains ActionListener implementations for each action, such as inserting, deleting,
 * viewing, and editing clients and products, as well as creating orders. It communicates with the business logic
 * layers (ClientBLL, ProductBLL, OrderBLL, and LogBLL) to perform various operations.
 * </p>
 * <p>
 * This class initializes the main page view, client operation view, product operation view, order view, and BLL instances.
 * It adds action listeners to handle user interactions and instantiate the necessary controllers for each operation.
 * </p>
 * <p>
 * The Controller class contains inner classes implementing ActionListener interfaces for various actions, such as
 * displaying client, product, and order views, performing insert, delete, edit, and view operations for clients
 * and products, and creating orders.
 * </p>
 *
 * @author [Your Name]
 * @version [Enter version or date]
 */

public class Controller {
    private View mainPage;
    private ClientOperationView clientPage;

    private ProductOperationView productPage;

    private ClientBLL clientBLL;
    private ProductBLL productBLL;

    private OrderBLL orderBLL;

   private BillBLL billBLL;

    private ClientInsertView insertView;

    private ClientDeleteView deleteView;

    private ClientEditIdSelectionPage clientEditIdSelectionPage;
    private ProductOperationController productOperationController;

    private ProductDeleteView productDeleteView;

    private OrderView orderView;
    private OrderCreateView orderCreateView;
    private ProductEditIdSelectionPage productEditIdSelectionPage;

    private ClientOperationController clientOperationController;

    private OrderOperationController orderOperationController;


    /**
     * Constructs a new Controller object with the specified parameters. Initializes the main view,
     * client view, product view, order view, and BLL instances. Adds action listeners to handle user interactions
     * and instantiate the necessary controllers for each operation.
     *
     * @param mainPage    The main page view.
     * @param clientPage  The client operation view.
     * @param productPage The product operation view.
     * @param orderView   The order view.
     * @param clientBLL   The client business logic layer.
     * @param productBLL  The product business logic layer.
     * @param orderBLL    The order business logic layer.
     * @param billBLL      The log business logic layer.
     */

    public Controller(View mainPage, ClientOperationView clientPage, ProductOperationView productPage, OrderView orderView, ClientBLL clientBLL, ProductBLL productBLL, OrderBLL orderBLL, BillBLL billBLL) {
        this.mainPage = mainPage;
        this.clientPage = clientPage;
        this.productPage = productPage;
        this.clientBLL = clientBLL;
        this.productBLL = productBLL;
        this.orderView = orderView;
        this.orderBLL = orderBLL;
        this.billBLL = billBLL;


        mainPage.addClientListener(new ClientListener());
        mainPage.addProductListener(new ProductPageListener());
        mainPage.addOrderListener(new OrderPageListener());


        clientPage.addHomePageListener(new HomePageListener());
        clientPage.addInsertListener(new ClientInsertListener());
        clientPage.addViewListener(new ClientViewAllListener());
        clientPage.addDeleteListenre(new ClientDeleteListener());
        clientPage.addEditListener(new ClientEditListener());


        productPage.addHomePageListener(new HomePageListener());
        productPage.addInsertListener(new ProductInsertListener());
        productPage.addViewListener(new ProductViewAllListener());
        productPage.addDeleteListenre(new ProductDeleteListener());
        productPage.addEditListener(new ProductEditListener());

        orderView.addMainPageListener(new HomePageListener());
        orderView.addShowAllListener(new OrderViewAllListener());
        orderView.addCreateListener(new OrderCreateListener());
    }

    /**
     * ActionListener implementation for handling user actions to navigate to the client page.
     */
    class ClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientPage.getFrame().setVisible(true);
            mainPage.getFrame().setVisible(false);
        }
    }

    /**
     * ActionListener implementation for handling user actions to navigate back to the main page.
     */
    class HomePageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPage.getFrame().setVisible(true);
            clientPage.getFrame().setVisible(false);
            productPage.getFrame().setVisible(false);
            orderView.getFrame().setVisible(false);
        }
    }

    /**
     * ActionListener implementation for handling user actions to navigate to the product page.
     */
    class ProductPageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productPage.getFrame().setVisible(true);
            mainPage.getFrame().setVisible(false);
        }
    }

    /**
     * ActionListener implementation for handling user actions to navigate to the order page.
     */
    class OrderPageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            orderView.getFrame().setVisible(true);
            mainPage.getFrame().setVisible(false);
        }
    }

    /**
     * This section of the Controller class contains several ActionListener inner classes,
     * each responsible for handling different user actions and interacting with the business logic layers.
     */
    class ClientViewAllListener implements ActionListener {
        /**
         * Invoked when the "View All Clients" button is clicked.
         * Displays a table showing all clients.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create and display a JFrame to show the client table
            JFrame tableFrame = new JFrame("CLIENT TABLE");
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tableFrame.setSize(600, 800);
            tableFrame.setVisible(true);

            // Retrieve and display all clients in a JTable
            JTable table = clientBLL.showAllClients();
            tableFrame.add(table);
        }
    }

    /**
     * ActionListener inner class responsible for handling client insertion.
     */
    class ClientInsertListener implements ActionListener {
        /**
         * Invoked when the "Insert Client" button is clicked.
         * Opens a view to insert a new client and initializes the controller for client operations.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new view for inserting a client
            insertView = new ClientInsertView();
            // Initialize the controller for client operations with the insert view and client BLL
            clientOperationController = new ClientOperationController(insertView, clientBLL);
        }
    }

    /**
     * ActionListener inner class responsible for handling the deletion of a client.
     */
    class ClientDeleteListener implements ActionListener {
        /**
         * Invoked when the "Delete Client" button is clicked.
         * Opens a view for deleting a client and initializes the controller for client operations.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new view for deleting a client
            deleteView = new ClientDeleteView();
            // Initialize the controller for client operations with the delete view and client BLL
            clientOperationController = new ClientOperationController(deleteView, clientBLL);
        }
    }

    /**
     * ActionListener inner class responsible for handling client editing.
     */
    class ClientEditListener implements ActionListener {
        /**
         * Invoked when the "Edit Client" button is clicked.
         * Opens a view for selecting a client to edit and initializes the controller for client operations.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new view for selecting a client to edit
            clientEditIdSelectionPage = new ClientEditIdSelectionPage();
            // Initialize the controller for client operations with the edit view and client BLL
            clientOperationController = new ClientOperationController(clientEditIdSelectionPage, clientBLL);
        }
    }

    /**
     * ActionListener inner class responsible for handling product insertion.
     */
    class ProductInsertListener implements ActionListener {
        /**
         * Invoked when the "Insert Product" button is clicked.
         * Opens a view for inserting a new product and initializes the controller for product operations.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new view for inserting a product
            ProductInsertView productInsertView = new ProductInsertView();
            // Initialize the controller for product operations with the insert view and product BLL
            productOperationController = new ProductOperationController(productInsertView, productBLL);
        }
    }

    /**
     * ActionListener inner class responsible for displaying all products.
     */
    class ProductViewAllListener implements ActionListener {
        /**
         * Invoked when the "View All Products" button is clicked.
         * Opens a new frame displaying a table of all products.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new frame to display the product table
            JFrame tableFrame = new JFrame("PRODUCT TABLE");
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tableFrame.setSize(600, 800);
            tableFrame.setVisible(true);

            // Retrieve all products from the product business logic layer
            JTable table = productBLL.showAllProducts();

            // Add the product table to the frame
            tableFrame.add(table);
        }
    }

    /**
     * ActionListener inner class responsible for handling product deletion.
     */
    class ProductDeleteListener implements ActionListener {
        /**
         * Invoked when the "Delete Product" button is clicked.
         * Opens a view for deleting a product and initializes the controller for product operations.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new view for deleting a product
            productDeleteView = new ProductDeleteView();
            // Initialize the controller for product operations with the delete view and product BLL
            productOperationController = new ProductOperationController(productDeleteView, productBLL);
        }
    }

    /**
     * ActionListener inner class responsible for handling product editing.
     */
    class ProductEditListener implements ActionListener {
        /**
         * Invoked when the "Edit Product" button is clicked.
         * Opens a view for selecting a product to edit and initializes the controller for product operations.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new view for selecting a product to edit
            productEditIdSelectionPage = new ProductEditIdSelectionPage();
            // Initialize the controller for product operations with the edit view and product BLL
            productOperationController = new ProductOperationController(productEditIdSelectionPage, productBLL);
        }
    }

    /**
     * ActionListener inner class responsible for displaying all orders.
     */
    class OrderViewAllListener implements ActionListener {
        /**
         * Invoked when the "View All Orders" button is clicked.
         * Opens a new frame displaying a table of all orders.
         * If no orders are available, displays a message dialog.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new frame to display the order table
            JFrame tableFrame = new JFrame("ORDER TABLE");
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tableFrame.setSize(600, 800);
            tableFrame.setVisible(true);
            try {
                // Retrieve all orders from the order business logic layer
                JTable table = orderBLL.showAllOrders();
                // Add the order table to the frame
                tableFrame.add(table);
            } catch (Exception ex) {
                // Display a message dialog if no orders are available
                JOptionPane.showMessageDialog(null, "NOTHING TO SEE HERE. TRY TO ADD SOMETHING FIRST!");
            }
        }
    }

    /**
     * ActionListener inner class responsible for handling order creation.
     */
    class OrderCreateListener implements ActionListener {
        /**
         * Invoked when the "Create Order" button is clicked.
         * Opens a view for creating a new order and initializes the controller for order operations.
         *
         * @param e The action event.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new view for creating an order
            orderCreateView = new OrderCreateView();
            // Initialize the controller for order operations with the create view, order BLL, product BLL, client BLL, and log BLL
            orderOperationController = new OrderOperationController(orderCreateView, orderBLL, productBLL, clientBLL, billBLL);
        }
    }
}
