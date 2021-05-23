package Utilities;

import Business.DeliveryService;
import Business.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to manage tables from the GUI.
 */
public class TableManager {


    private DeliveryService deliveryService;
    public TableManager(DeliveryService deliveryService)
    {
        this.deliveryService = deliveryService;
    }

    /**
     * Inserts data into a table
     * @param table
     * @param data
     */
    public void insertDataIntoTable(JTable table, ArrayList<MenuItem> data)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (MenuItem menu: data)
        {
            List<String> row = new ArrayList<>();
            row.add(menu.getTitle());
            row.add(menu.getRating().toString());
            row.add(menu.getCalories().toString());
            row.add(menu.getProteins().toString());
            row.add(menu.getFat().toString());
            row.add(menu.getSodium().toString());
            row.add(menu.getPrice().toString());

            model.addRow(row.toArray());
        }
    }

    /**
     * Imports data from the deliveryService class to a table
     * @param table
     */

    public void importDataIntoTable(JTable table)
    {
        deliveryService.importProducts();
        ArrayList<MenuItem> data = deliveryService.getMenuItems();
        insertDataIntoTable(table,data);
    }

    /**
     * Updates a table with data from the deliveryService class.
     * @param table
     */
    public void updateTable(JTable table)
    {
        ArrayList<MenuItem> data = deliveryService.getMenuItems();
        insertDataIntoTable(table,data);
    }

}
