package Business;

import DataLayer.CSVReader;

import java.util.ArrayList;

public class DeliveryService implements IDeliveryServiceProcessing{

    private ArrayList<MenuItem> menuItems;

    public DeliveryService()
    {
        menuItems = new ArrayList<>();
    }




    @Override
    public void importProducts() {
        menuItems = CSVReader.readData();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public void addProduct() {

    }

    @Override
    public void editProduct() {

    }

    @Override
    public void deleteProduct() {

    }
}
