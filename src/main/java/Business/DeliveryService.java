package Business;

import DataLayer.CSVReader;
import DataLayer.Serializator;

import java.util.ArrayList;

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
}
