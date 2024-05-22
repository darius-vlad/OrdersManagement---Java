package bll;

import dao.BillDAO;
import model.Bill;

/**
 * The BillBLL class serves as a business logic layer for managing bill-related operations.
 * It interacts with the BillDAO class to perform database operations.
 */
public class BillBLL {

    private BillDAO billDAO;

    /**
     * Constructs a new instance of BillBLL and initializes the BillDAO.
     */
    public BillBLL() {
        billDAO = new BillDAO();
    }

    /**
     * Inserts a bill into the database.
     *
     * @param bill The Bill object to be inserted into the database.
     */
    public void insertBill(Bill bill) {
        billDAO.insertBill(bill);
    }
}
