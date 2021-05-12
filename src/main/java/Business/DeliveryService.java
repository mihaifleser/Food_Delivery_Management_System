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
    public void addProduct(MenuItem newItem) {
        menuItems.add(newItem);
    }

    @Override
    public void editProduct(String title, Float rating, Integer calories, Integer proteins, Integer fat, Integer sodium, Integer price) {
        MenuItem item = getItemWithTitle(title);
        item.setRating(rating);
        item.setCalories(calories);
        item.setProteins(proteins);
        item.setFat(fat);
        item.setSodium(sodium);
        item.setPrice(price);
    }

    public MenuItem getItemWithTitle(String title)
    {
        for(MenuItem item: menuItems)
        {
            if(item.getTitle().equals(title))
                return item;
        }
        return null;
    }

    @Override
    public void deleteProduct(String title) {
        menuItems.remove(getItemWithTitle(title));
    }
}
