package Business;

import DataLayer.CSVReader;
import DataLayer.FileWriterClass;
import DataLayer.Serializator;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing{

    private ArrayList<MenuItem> menuItems;
    private ArrayList<Account> accounts;
    private Account loggedInAccount;
    private ArrayList<MenuItem> currentItemsInOrder;
    private HashMap<Order, ArrayList<MenuItem>> allOrders;

    public DeliveryService()
    {
        menuItems = new ArrayList<>();
        accounts = new ArrayList<>();
        currentItemsInOrder = new ArrayList<>();
        allOrders = new HashMap<>();
        loggedInAccount = null;
    }

    @Override
    public void createOrder() {
        Integer price = 0;
        for(MenuItem item: currentItemsInOrder)
            price += item.getPrice();
        Order order = new Order(allOrders.size(),loggedInAccount.getEmail(), (GregorianCalendar) Calendar.getInstance(), price);

        FileWriterClass.writeOrder(order,currentItemsInOrder);
        setChanged();
        notifyObservers(FileWriterClass.orderToString(order, currentItemsInOrder));
        allOrders.put(order,new ArrayList<>(currentItemsInOrder));
        currentItemsInOrder.clear();


    }

    public void addItemInOrder(MenuItem item)
    {
        currentItemsInOrder.add(item);
    }

    public void removeItemFromOrder()
    {
        currentItemsInOrder.remove(currentItemsInOrder.size() - 1);
    }

    public String itemsFromOrderToString()
    {
        String output = "";
        for(MenuItem item: currentItemsInOrder)
        {
            output = output + item.getTitle() + "\n";
        }
        return output;
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
        this.menuItems = new Serializator<MenuItem, Object>().deserialize("Products");
    }

    public void importSerialisedAccounts()
    {
        this.accounts = new Serializator<Account, Object>().deserialize("Accounts");
    }

    public void importSerialisedOrders()
    {
        this.allOrders = new Serializator<Order, MenuItem>().deserializeHashMap("Orders");
    }

    public void exportSerialisedOrders()
    {
        new Serializator<Order, MenuItem>().serializeHashMap(allOrders, "Orders");
    }

    public void exportAccounts()
    {
        new Serializator<Account, Object>().serialize(accounts,"Accounts");
    }

    public void exportProducts()
    {
        new Serializator<MenuItem, Object>().serialize(menuItems,"Products");
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

    @Override
    public void generateReport1(Integer startHour, Integer endHour) {

        ArrayList<Order>localOrders =(ArrayList) allOrders.keySet().stream().filter(o->o.getDate().get(Calendar.HOUR_OF_DAY) <= endHour). collect(Collectors.toList());
        localOrders =(ArrayList) localOrders.stream().filter(o->o.getDate().get(Calendar.HOUR_OF_DAY) >= startHour). collect(Collectors.toList());
        FileWriterClass.writeReport1(localOrders);
    }

    @Override
    public void generateReport2(Integer minNumber)
    {
        HashMap<MenuItem, Integer> occurence = new HashMap<>();
        HashSet<MenuItem> products = new HashSet<>();
        for(Order order: allOrders.keySet())
        {
            for(MenuItem menuItem: allOrders.get(order))
            {
                products.add(menuItem);
            }
        }
        for(MenuItem menuItem: products)
        {
            occurence.put(menuItem, 0);
        }
        for(Order order: allOrders.keySet())
        {
            for(MenuItem menuItem: allOrders.get(order))
            {
                occurence.put(menuItem, occurence.get(menuItem) + 1);
            }
        }

        HashMap<MenuItem, Integer> finalResult = new HashMap<>();
        occurence.entrySet().stream().filter(entry->entry.getValue() > minNumber).forEach(entry-> finalResult.put(entry.getKey(), entry.getValue()));
        FileWriterClass.writeReport2(finalResult);

    }

    @Override
    public void generateReport3(Integer minClients, Integer valueHigher) {
        HashMap<String, Integer> occurence = new HashMap<>();
        HashSet<String> accounts = new HashSet<>();

        for(Order order: allOrders.keySet())
        {
            accounts.add(order.getClientId());
        }
        for(String account: accounts)
        {
            occurence.put(account, 0);
        }
        for(Order order: allOrders.keySet())
        {
            if(order.getTotalPrice() > valueHigher)
                occurence.put(order.getClientId(), occurence.get(order.getClientId()) + 1);
        }

        HashMap<String, Integer> finalResult = new HashMap<>();
        occurence.entrySet().stream().filter(entry->entry.getValue() > minClients).forEach(entry-> finalResult.put(entry.getKey(), entry.getValue()));
        FileWriterClass.writeReport3(finalResult);


    }

    @Override
    public void generateReport4(Integer day) {
        HashMap<MenuItem, Integer> occurence = new HashMap<>();
        HashSet<MenuItem> products = new HashSet<>();

        ArrayList<Order>localOrders =(ArrayList) allOrders.keySet().stream().filter(o->o.getDate().get(Calendar.DAY_OF_MONTH) == day). collect(Collectors.toList());

        for(Order order: localOrders)
        {
            for(MenuItem menuItem: allOrders.get(order))
            {
                products.add(menuItem);
            }
        }
        for(MenuItem menuItem: products)
        {
            occurence.put(menuItem, 0);
        }
        for(Order order: localOrders)
        {
            for(MenuItem menuItem: allOrders.get(order))
            {
                occurence.put(menuItem, occurence.get(menuItem) + 1);
            }
        }

        FileWriterClass.writeReport4(occurence);
    }
}
