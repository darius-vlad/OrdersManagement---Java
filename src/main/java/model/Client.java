
package model;
/**
 * Represents a client entity with attributes such as ID, name, address, email, and age.
 *
 * <p>This class provides methods to access and manipulate client information.</p>
 *
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 * Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: [Enter initial version or date]
 */
public class Client {
    private int id;
    private String name;
    private String address;
    private String email;
    private int age;

    /**
     * Constructs a new client with default values.
     */
    public Client() {
    }

    /**
     * Constructs a new client with the specified ID, name, address, email, and age.
     *
     * @param id      The ID of the client.
     * @param name    The name of the client.
     * @param address The address of the client.
     * @param email   The email of the client.
     * @param age     The age of the client.
     */
    public Client(int id, String name, String address, String email, int age) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    /**
     * Constructs a new client with the specified name, address, email, and age.
     *
     * @param name    The name of the client.
     * @param address The address of the client.
     * @param email   The email of the client.
     * @param age     The age of the client.
     */
    public Client(String name, String address, String email, int age) {
        super();
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    /**
     * Retrieves the ID of the client.
     *
     * @return The ID of the client.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the client.
     *
     * @param id The ID of the client.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the client.
     *
     * @return The name of the client.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the client.
     *
     * @param name The name of the client.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the address of the client.
     *
     * @return The address of the client.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the client.
     *
     * @param address The address of the client.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the age of the client.
     *
     * @return The age of the client.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the client.
     *
     * @param age The age of the client.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Retrieves the email of the client.
     *
     * @return The email of the client.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the client.
     *
     * @param email The email of the client.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the client object.
     *
     * @return A string representation of the client object.
     */
    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", age=" + age
                + "]";
    }
}
