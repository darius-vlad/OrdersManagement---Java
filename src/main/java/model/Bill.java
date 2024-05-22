
package model;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents a bill record for a purchase.
 *
 * <p>A bill contains information about the client name, product quantity, product name, and total price.</p>
 *
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 * Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: [Enter initial version or date]
 */
public record Bill(int billId , String clientName, int productQuantity, String productName, int totalPrice) {


    public void createLogFile() {

        String fileName = "order_" + billId + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Order " + billId + " : ");
            writer.write(clientName + " bought ");
            writer.write( productQuantity + " of ");
            writer.write(  productName + " ");
            writer.write(" for the total price of " + totalPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
