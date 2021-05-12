package Presentation;

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
    private DeliveryService deliveryService;
    private TableManager tableManager;
    public Controller()
    {
        deliveryService = new DeliveryService();
        tableManager = new TableManager(deliveryService);
    }

    public void start()
    {
        adminGUI.initialise();
        clientGUI.initialise();
        employeeGUI.initialise();


        adminGUI.getImportButton().addActionListener(e -> tableManager.importDataIntoTable(adminGUI.getProductsTable()));
    }
}
