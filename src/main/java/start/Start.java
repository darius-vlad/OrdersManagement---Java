package start;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.*;
import model.Bill;
import model.Client;
import presentation.*;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) throws SQLException {

        ClientBLL clientBll = new ClientBLL();
        ProductBLL productBLL = new ProductBLL();
        OrderBLL orderBLL = new OrderBLL();
        BillBLL billBLL = new BillBLL();
        View screen = new View();
        ClientOperationView clientView = new ClientOperationView();
        ProductOperationView productView = new ProductOperationView();
        OrderView orderView = new OrderView();
        Controller controller = new Controller(screen , clientView , productView,orderView, clientBll , productBLL , orderBLL , billBLL);




    }

}
