package DataLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Serializator <T, V>{

    public void serialize(ArrayList<T> array, String type)
    {
        try {
            FileOutputStream file = new FileOutputStream("ProgramData/" + type + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(array);
            out.close();
            file.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<T> deserialize(String type)
    {
        ArrayList<T> result = new ArrayList<>();
        try
        {
            FileInputStream file = new FileInputStream("ProgramData/" + type + ".txt");
            ObjectInputStream in = new ObjectInputStream (file);
            result = (ArrayList<T>) in.readObject (); // Method for deserialization of object
            in.close();
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public HashMap<T,ArrayList<V>> deserializeHashMap(String type)
    {
        HashMap<T, ArrayList<V>> result = new HashMap<>();
        try
        {
            FileInputStream file = new FileInputStream("ProgramData/" + type + ".txt");
            ObjectInputStream in = new ObjectInputStream (file);
            result = (HashMap<T, ArrayList<V>>) in.readObject (); // Method for deserialization of object
            in.close();
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public void serializeHashMap(HashMap<T, ArrayList<V>> hashMap, String type)
    {
        try {
            FileOutputStream file = new FileOutputStream("ProgramData/" + type + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(hashMap);
            out.close();
            file.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
