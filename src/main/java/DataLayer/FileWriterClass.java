package DataLayer;

import Business.MenuItem;
import Business.Order;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class FileWriterClass {


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

}
