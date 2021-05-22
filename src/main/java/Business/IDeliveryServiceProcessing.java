package Business;

import java.util.ArrayList;

public interface IDeliveryServiceProcessing {

    void importProducts();
    void addProduct(MenuItem newItem);
    void editProduct(Integer id, String title,Float rating, Integer calories, Integer proteins, Integer fat, Integer sodium, Integer price);
    void deleteProduct(String title);
    void addAccount(Account account);
    void logIn(Account account);
    void logOut();
    ArrayList<MenuItem> searchForTitle(ArrayList<MenuItem> items, String title);
    ArrayList<MenuItem> searchForRating(ArrayList<MenuItem> items, Float rating);
    ArrayList<MenuItem> searchForCalories(ArrayList<MenuItem> items, Integer calories);
    ArrayList<MenuItem> searchForProteins(ArrayList<MenuItem> items, Integer proteins);
    ArrayList<MenuItem> searchForFat(ArrayList<MenuItem> items, Integer fat);
    ArrayList<MenuItem> searchForSodium(ArrayList<MenuItem> items, Integer sodium);
    ArrayList<MenuItem> searchForPrice(ArrayList<MenuItem> items, Integer price);

    void generateReport1(Integer startHour, Integer endHour);
    void generateReport2(Integer minNumber);

    void createOrder();

}