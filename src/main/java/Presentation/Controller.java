package Presentation;

import Business.*;
import Utilities.TableManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class Controller {

    private AdminGUI adminGUI = new AdminGUI();
    private ClientGUI clientGUI = new ClientGUI();
    private EmployeeGUI employeeGUI = new EmployeeGUI();
    private AddProductGUI addProductGUI = new AddProductGUI();
    private DeliveryService deliveryService;
    private TableManager tableManager;
    public Controller()
    {
        deliveryService = new DeliveryService();
        tableManager = new TableManager(deliveryService);
    }


    private void addProduct()
    {
        try
        {
            String title = addProductGUI.getTitle();
            Float rating = Float.valueOf(addProductGUI.getRating());
            Integer calories = Integer.valueOf(addProductGUI.getCalories());
            Integer proteins = Integer.valueOf(addProductGUI.getProteins());
            Integer fat = Integer.valueOf(addProductGUI.getFat());
            Integer sodium = Integer.valueOf(addProductGUI.getSodium());
            Integer price = Integer.valueOf(addProductGUI.getPrice());

            if(deliveryService.getItemWithTitle(title) == null)
            {
                MenuItem newItem = new BaseProduct(title,rating,calories,proteins,fat,sodium,price);
                deliveryService.addProduct(newItem);

                tableManager.updateTable(adminGUI.getProductsTable());
                tableManager.updateTable(clientGUI.getProductsTable());
            }
            else
                JOptionPane.showMessageDialog(new JFrame(), "Product already present!");

        }catch (Exception exception)
        {
            JOptionPane.showMessageDialog(new JFrame(), "ERROR: You Must insert proper data!");
        }

    }

    private void deleteSelectedProducts()
    {
        try {
            int[] rows = adminGUI.getProductsTable().getSelectedRows();
            int col = 0;
            for(int a: rows)
            {
                String title = adminGUI.getProductsTable().getModel().getValueAt(a, col).toString();
                deliveryService.deleteProduct(title);
            }
            tableManager.updateTable(adminGUI.getProductsTable());
            tableManager.updateTable(clientGUI.getProductsTable());

        }catch (Exception exception)
        {
            JOptionPane.showMessageDialog(new JFrame(), "ERROR: You Must select something to delete");
        }
    }

    private void composeNewMenu()
    {
            int[] rows = adminGUI.getProductsTable().getSelectedRows();
            int col = 0;
            String title = adminGUI.getNewMenuTitle();
            if(deliveryService.getItemWithTitle(title) == null)
            {
                CompositeProduct newMenu = new CompositeProduct(title);
                for(int a: rows)
                {
                    String productTitle = adminGUI.getProductsTable().getModel().getValueAt(a, 0).toString();
                    Float rating =Float.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 1).toString());
                    Integer calories = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 2).toString());
                    Integer proteins = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 3).toString());
                    Integer fat = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 4).toString());
                    Integer sodium = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 5).toString());
                    Integer price = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 6).toString());
                    newMenu.addMenuProduct(new BaseProduct(productTitle,rating,calories,proteins,fat,sodium,price));
                }
                deliveryService.addProduct(newMenu);
                tableManager.updateTable(adminGUI.getProductsTable());
                tableManager.updateTable(clientGUI.getProductsTable());
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "Product already present!");
            }

    }

    private void registerAccount()
    {
        String email = clientGUI.getUserEmail();
        String password = clientGUI.getUserPassword();

        if(deliveryService.getAccountWithEmail(email) != null)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Account already exists!");
        }
        else
        {
            deliveryService.addAccount(new Account(email,password));
            JOptionPane.showMessageDialog(new JFrame(), "Account created!");
        }
    }

    private void logIn()
    {
        String email = clientGUI.getUserEmail();
        String password = clientGUI.getUserPassword();
        Account foundAccount = deliveryService.getAccountWithEmail(email);
        if(foundAccount != null)
        {
            if(deliveryService.getAccountWithEmail(email).getPassword().compareTo(password) == 0)
            {
                deliveryService.logIn(foundAccount);
                clientGUI.getRegisterButton().setEnabled(false);
                clientGUI.getLoginButton().setEnabled(false);
                clientGUI.getPasswordTextArea().setEnabled(false);
                clientGUI.getEmailTextArea().setEnabled(false);
                clientGUI.getAccountLabel().setText(deliveryService.getLoggedInAccount().getEmail());
                clientGUI.getLogOut().setEnabled(true);
            }
           else
                JOptionPane.showMessageDialog(new JFrame(), "Wrong Password!");
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Account does not exists!");
        }
    }

    private void search()
    {
        String title = clientGUI.getSearchedTitle();
        String rating = clientGUI.getSearchedRating();
        String calories = clientGUI.getSearchedCalories();
        String proteins = clientGUI.getSearchedProteins();
        String fat = clientGUI.getSearchedFat();
        String sodium = clientGUI.getSearchedSodium();
        String price = clientGUI.getSearchedPrice();

        System.out.println(rating);

        ArrayList<MenuItem> items = deliveryService.getMenuItems();

        if(title.compareTo("") != 0)
            items = deliveryService.searchForTitle(items,title);
        if(rating.compareTo("") != 0)
            items = deliveryService.searchForRating(items,Float.valueOf(rating));
        if(calories.compareTo("") != 0)
            items = deliveryService.searchForCalories(items,Integer.valueOf(calories));
        if(proteins.compareTo("") != 0)
            items = deliveryService.searchForProteins(items,Integer.valueOf(proteins));
        if(fat.compareTo("") != 0)
            items = deliveryService.searchForFat(items,Integer.valueOf(fat));
        if(sodium.compareTo("") != 0)
            items = deliveryService.searchForSodium(items,Integer.valueOf(sodium));
        if(price.compareTo("") != 0)
            items = deliveryService.searchForPrice(items,Integer.valueOf(price));

        tableManager.insertDataIntoTable(clientGUI.getProductsTable(),items);

    }

    private void logOut()
    {
        deliveryService.logOut();
        clientGUI.getRegisterButton().setEnabled(true);
        clientGUI.getLoginButton().setEnabled(true);
        clientGUI.getPasswordTextArea().setEnabled(true);
        clientGUI.getEmailTextArea().setEnabled(true);
        clientGUI.getAccountLabel().setText("");
        clientGUI.getLogOut().setEnabled(false);
    }

    private void ImportFromCSV()
    {
        tableManager.importDataIntoTable(adminGUI.getProductsTable());
        tableManager.updateTable(clientGUI.getProductsTable());

    }

    private void editSelectedProducts()
    {
        try {
            int[] rows = adminGUI.getProductsTable().getSelectedRows();
            for(int a: rows)
            {
                String title = adminGUI.getProductsTable().getModel().getValueAt(a, 0).toString();
                Float rating =Float.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 1).toString());
                Integer calories = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 2).toString());;
                Integer proteins = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 3).toString());;
                Integer fat = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 4).toString());;
                Integer sodium = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 5).toString());;
                Integer price = Integer.valueOf(adminGUI.getProductsTable().getModel().getValueAt(a, 6).toString());;
                deliveryService.editProduct(a, title,rating,calories,proteins,fat,sodium,price);
            }
            tableManager.updateTable(adminGUI.getProductsTable());
            tableManager.updateTable(clientGUI.getProductsTable());

        }catch (Exception exception)
        {
            JOptionPane.showMessageDialog(new JFrame(), "ERROR: You Must insert proper data!");
        }
    }


    public void start()
    {
        adminGUI.initialise();
        clientGUI.initialise();
        employeeGUI.initialise();
        deliveryService.importSerialisedProducts();
        deliveryService.importSerialisedAccounts();
        tableManager.updateTable(adminGUI.getProductsTable());
        tableManager.updateTable(clientGUI.getProductsTable());

        adminGUI.getImportButton().addActionListener(e -> ImportFromCSV());
        adminGUI.getFrame().addWindowListener(new java.awt.event.WindowAdapter()
        {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                deliveryService.exportAccounts();
                deliveryService.exportProducts();
            }
        });
        adminGUI.getAddButton().addActionListener((e -> addProductGUI.initialise()));
        addProductGUI.getAddButton().addActionListener(e -> addProduct());
        adminGUI.getDeleteButton().addActionListener(e->deleteSelectedProducts());
        adminGUI.getEditButton().addActionListener(e->editSelectedProducts());
        adminGUI.getComposeButton().addActionListener(e-> composeNewMenu());
        clientGUI.getRegisterButton().addActionListener(e-> registerAccount());
        clientGUI.getLoginButton().addActionListener(e->logIn());
        clientGUI.getLogOut().addActionListener(e -> logOut());
        clientGUI.getSearchButton().addActionListener(e-> search());
    }
}
