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
        if(deliveryService.getAccountWithEmail(email) != null)
        {
            deliveryService.logIn(email, password);
            clientGUI.getRegisterButton().setEnabled(false);
            clientGUI.getLoginButton().setEnabled(false);
            clientGUI.getPasswordTextArea().setEnabled(false);
            clientGUI.getEmailTextArea().setEnabled(false);
            clientGUI.getAccountLabel().setText(deliveryService.getLoggedInAccount().getEmail());
            clientGUI.getLogOut().setEnabled(true);
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Account does not exists!");
        }
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

        adminGUI.getImportButton().addActionListener(e -> tableManager.importDataIntoTable(adminGUI.getProductsTable()));
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
    }
}
