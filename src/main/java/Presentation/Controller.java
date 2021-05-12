package Presentation;

import Business.BaseProduct;
import Business.DeliveryService;
import Business.MenuItem;
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
                deliveryService.editProduct(title,rating,calories,proteins,fat,sodium,price);
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


        adminGUI.getImportButton().addActionListener(e -> tableManager.importDataIntoTable(adminGUI.getProductsTable()));
        adminGUI.getAddButton().addActionListener((e -> addProductGUI.initialise()));
        addProductGUI.getAddButton().addActionListener(e -> addProduct());
        adminGUI.getDeleteButton().addActionListener(e->deleteSelectedProducts());
        adminGUI.getEditButton().addActionListener(e->editSelectedProducts());
    }
}
