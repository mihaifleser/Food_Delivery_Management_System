package Business;

public interface IDeliveryServiceProcessing {

    void importProducts();
    void addProduct(MenuItem newItem);
    void editProduct(String title,Float rating, Integer calories, Integer proteins, Integer fat, Integer sodium, Integer price);
    void deleteProduct(String title);

}