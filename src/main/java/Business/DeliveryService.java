package Business;

import DataLayer.CSVReader;
import DataLayer.Serializator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DeliveryService implements IDeliveryServiceProcessing{

    private ArrayList<MenuItem> menuItems;
    private ArrayList<Account> accounts;
    private Account loggedInAccount;

    public DeliveryService()
    {
        menuItems = new ArrayList<>();
        accounts = new ArrayList<>();
        loggedInAccount = null;
    }

    @Override
    public void importProducts() {
        menuItems = CSVReader.readData();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void importSerialisedProducts()
    {
        this.menuItems = new Serializator<MenuItem>().deserialize("Products");
    }

    public void importSerialisedAccounts()
    {
        this.accounts = new Serializator<Account>().deserialize("Accounts");
    }

    public void exportAccounts()
    {
        new Serializator<Account>().serialize(accounts,"Accounts");
    }

    public void exportProducts()
    {
        new Serializator<MenuItem>().serialize(menuItems,"Products");
    }

    @Override
    public void addProduct(MenuItem newItem) {
        menuItems.add(newItem);
    }

    @Override
    public void editProduct(Integer id ,String title, Float rating, Integer calories, Integer proteins, Integer fat, Integer sodium, Integer price) {
        MenuItem item = menuItems.get(id);
        item.setTitle(title);
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

    @Override
    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    @Override
    public void logIn(Account account) {
        loggedInAccount = account;
    }

    public Account getLoggedInAccount()
    {
        return loggedInAccount;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountWithEmail(String email)
    {
        for(Account account : accounts)
        {
            if(account.getEmail().equals(email))
                    return account;
        }
        return null;
    }

    @Override
    public void logOut() {
        loggedInAccount = null;
    }

    @Override
    public ArrayList<MenuItem> searchForTitle(ArrayList<MenuItem> items, String title) {
        return (ArrayList<MenuItem>) items.stream().filter(p -> p.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public ArrayList<MenuItem> searchForRating(ArrayList<MenuItem> items, Float rating) {
        return (ArrayList<MenuItem>) items.stream().filter(p -> p.getRating().equals(rating)).collect(Collectors.toList());
    }

    @Override
    public ArrayList<MenuItem> searchForCalories(ArrayList<MenuItem> items, Integer calories) {
        return (ArrayList<MenuItem>) items.stream().filter(p -> p.getCalories().equals(calories)).collect(Collectors.toList());
    }

    @Override
    public ArrayList<MenuItem> searchForProteins(ArrayList<MenuItem> items, Integer proteins) {
        return (ArrayList<MenuItem>) items.stream().filter(p -> p.getProteins().equals(proteins)).collect(Collectors.toList());
    }

    @Override
    public ArrayList<MenuItem> searchForFat(ArrayList<MenuItem> items, Integer fat) {
        return (ArrayList<MenuItem>) items.stream().filter(p -> p.getFat().equals(fat)).collect(Collectors.toList());
    }

    @Override
    public ArrayList<MenuItem> searchForSodium(ArrayList<MenuItem> items, Integer sodium) {
        return (ArrayList<MenuItem>) items.stream().filter(p -> p.getSodium().equals(sodium)).collect(Collectors.toList());
    }

    @Override
    public ArrayList<MenuItem> searchForPrice(ArrayList<MenuItem> items, Integer price) {
        return (ArrayList<MenuItem>) items.stream().filter(p -> p.getPrice().equals(price)).collect(Collectors.toList());
    }
}
