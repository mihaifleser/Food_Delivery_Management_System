package Business;

public interface IDeliveryServiceProcessing {

    void importProducts();
    void addProduct(MenuItem newItem);
    void editProduct(Integer id, String title,Float rating, Integer calories, Integer proteins, Integer fat, Integer sodium, Integer price);
    void deleteProduct(String title);
    void addAccount(Account account);
    void logIn(String email, String password);
    void logOut();
}