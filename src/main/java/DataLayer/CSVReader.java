package DataLayer;

import Business.BaseProduct;
import Business.MenuItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Reads data from the CSV file.
 */

public class CSVReader {


    public static ArrayList<MenuItem> readData()
    {
        List<MenuItem> initialResult = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("products.csv")))
        {
            initialResult = reader.lines().skip(1).map(line -> line.split(",")).map(data -> new BaseProduct(
                    data[0],
                    Float.parseFloat(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]),
                    Integer.parseInt(data[4]),
                    Integer.parseInt(data[5]),
                    Integer.parseInt(data[6])
            )).collect(Collectors.toList());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        List<MenuItem> withoutDupes = initialResult.stream()
                .distinct()
                .collect(Collectors.toList());

        ArrayList<MenuItem> finalResult = new ArrayList<>(withoutDupes);
        return finalResult;

    }
}
