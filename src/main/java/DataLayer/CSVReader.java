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

public class CSVReader {

    public static ArrayList<MenuItem> readData()
    {
        List<MenuItem> initialResult = new ArrayList<>();
        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader("products.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String row = "";
        boolean firstTime = true;
        while (true) {
            try {
                if (((row = csvReader.readLine()) == null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] data = row.split(",");
            if(firstTime)
            {
                firstTime = false;
                continue;
            }
            MenuItem newItem = new BaseProduct(data[0],Float.valueOf(data[1]),Integer.valueOf(data[2]),Integer.valueOf(data[3]), Integer.valueOf(data[4]),
                    Integer.valueOf(data[5]), Integer.valueOf(data[6]));
            initialResult.add(newItem);
            // do something with the data
        }
        try {
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<MenuItem> withoutDupes = initialResult.stream()
                .distinct()
                .collect(Collectors.toList());

        ArrayList<MenuItem> finalResult = new ArrayList<>(withoutDupes);
        return finalResult;

    }
}
