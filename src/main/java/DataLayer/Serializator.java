package DataLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Class used to serialize and deserialize data.
 * @param <T>
 * @param <V>
 */
public class Serializator <T, V>{

    /**
     * Serialises an array
     * @param array
     * @param type
     */

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

    /**
     * Deserialises an array
     * @param type
     * @return
     */

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

    /**
     * Deserialises a Hash Map
     * @param type
     * @return
     */
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

    /**
     * Serialises a hash map.
     * @param hashMap
     * @param type
     */
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
