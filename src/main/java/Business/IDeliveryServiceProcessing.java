package Business;

import java.util.ArrayList;

/**
 * Interface for the operations that the client and the administrator can do in the application
 */

public interface IDeliveryServiceProcessing {
    /**
     * Imports a set of products from a file, namely products.csv
     */
    void importProducts();

    /**
     * Adds a new product to the items from the menu.
     * @pre NewItem has to be not null
     * @param newItem The new item that will pe introduced
     */
    void addProduct(MenuItem newItem);

    /**
     * @pre The id must exist
     * @post The new item exists in the database
     * @param id
     * @param title
     * @param rating
     * @param calories
     * @param proteins
     * @param fat
     * @param sodium
     * @param price
     */
    void editProduct(Integer id, String title,Float rating, Integer calories, Integer proteins, Integer fat, Integer sodium, Integer price);

    /**
     * Deletes a product using it's title
     * @pre item with title exists in the database
     * @param title
     */
    void deleteProduct(String title);

    /**
     * Adds a new account into the database.
     * @pre account not null
     * @post the new account exists in the database
     * @param account
     */
    void addAccount(Account account);

    /**Log in with the client
     * @pre the account is not null
     * @post the logged in account updates
     * @param account
     */
    void logIn(Account account);

    /**
     * Logs out from the application
     * @post the logged in account updates
     */
    void logOut();
    ArrayList<MenuItem> searchForTitle(ArrayList<MenuItem> items, String title);
    ArrayList<MenuItem> searchForRating(ArrayList<MenuItem> items, Float rating);
    ArrayList<MenuItem> searchForCalories(ArrayList<MenuItem> items, Integer calories);
    ArrayList<MenuItem> searchForProteins(ArrayList<MenuItem> items, Integer proteins);
    ArrayList<MenuItem> searchForFat(ArrayList<MenuItem> items, Integer fat);
    ArrayList<MenuItem> searchForSodium(ArrayList<MenuItem> items, Integer sodium);
    ArrayList<MenuItem> searchForPrice(ArrayList<MenuItem> items, Integer price);

    /**
     * Generates a report with the orders performed between a start hour and an end our regardless the date
     * @param startHour
     * @param endHour
     */
    void generateReport1(Integer startHour, Integer endHour);

    /**
     * Generates a report with the products ordered more than a specified number of times so far
     * @param minNumber
     */
    void generateReport2(Integer minNumber);

    /**
     * Generates a report with the clients that have ordered more than a specified number of times
     * and the value of the order was higher than a specified amount.
     * @param minClients
     * @param valueHigher
     */
    void generateReport3(Integer minClients, Integer valueHigher);

    /**
     * Generates a report with the products ordered within a specified day with the number of times they have been ordered.
     * @param day
     */
    void generateReport4(Integer day);

    /**
     * Client creates a new order.
     */
    void createOrder();

}