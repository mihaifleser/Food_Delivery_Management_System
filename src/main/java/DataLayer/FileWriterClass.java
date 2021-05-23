package DataLayer;

import Business.MenuItem;
import Business.Order;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Writes data in specific files.
 */

public class FileWriterClass {

    /**
     * Method for transforming an order to a string.
     * @param order
     * @param items
     * @return
     */
    public static String orderToString(Order order, ArrayList<MenuItem> items)
    {
        String output = "Order: " + order.getOrderId() + "\n" +
                "Client: " + order.getClientId() + "\n" +
                "Date: " + order.getDate().getTime().toString() + "\n" +
                "items: " + "\n";
        for(MenuItem menuItem: items)
        {
            output = output + menuItem.getTitle() + "\n";
        }

        output = output + "For a total of: \n";
        output = output + order.getTotalPrice();


        return output;
    }

    /**
     * Method for writing an order in a txt file.
     * @param order
     * @param items
     */

    public static void writeOrder(Order order, ArrayList<MenuItem> items)
    {
        try {
            FileWriter myWriter = new FileWriter("AllOrders/" + "order" + order.getOrderId() + ".txt");
            myWriter.write(FileWriterClass.orderToString(order,items));
            myWriter.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method for writing report 1 performed by the Administrator
     * @param orders
     */
    public static void writeReport1(ArrayList<Order> orders)
    {
        try {
            String output = "";
            for(Order order : orders)
            {
                output = output + order.getOrderId() + ", " + order.getDate().getTime().toString() + " \n ";
            }
            FileWriter myWriter = new FileWriter("Reports/" + "report1.txt");
            myWriter.write(output);
            myWriter.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method for writing report 2 performed by the Administrator
     * @param occurence
     */
    public static void writeReport2(HashMap<MenuItem, Integer> occurence)
    {
        try {
            String output = "";
            for(MenuItem menuItem : occurence.keySet())
            {
                output = output + menuItem.getTitle() + ": " + occurence.get(menuItem)+" \n";
            }
            FileWriter myWriter = new FileWriter("Reports/" + "report2.txt");
            myWriter.write(output);
            myWriter.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method for writing report 3 performed by the Administrator
     * @param occurence
     */
    public static void writeReport3(HashMap<String, Integer> occurence)
    {
        try {
            String output = "";
            for(String account : occurence.keySet())
            {
                output = output + account + ": " + occurence.get(account)+" \n";
            }
            FileWriter myWriter = new FileWriter("Reports/" + "report3.txt");
            myWriter.write(output);
            myWriter.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method for writing report 4 performed by the Administrator
     * @param occurence
     */

    public static void writeReport4(HashMap<MenuItem, Integer> occurence)
    {
        try {
            String output = "";
            for(MenuItem menuItem : occurence.keySet())
            {
                output = output + menuItem.getTitle() + ": " + occurence.get(menuItem)+" \n";
            }
            FileWriter myWriter = new FileWriter("Reports/" + "report4.txt");
            myWriter.write(output);
            myWriter.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
