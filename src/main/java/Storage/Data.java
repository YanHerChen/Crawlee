package Storage;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    private static HashMap data = new HashMap<String, ArrayList<String>>();

    public static void setData(String TName, ArrayList<String> website_data) {
        data.put(TName, data);
        Queue.enqueue(TName);
    }

    public static ArrayList<String> getData(String key) {
        if (data.get(key) == null)
            return null;
        else
            return (ArrayList<String>) data.get(key);
    }

    public static void remove(String TName) {
        data.remove(TName);
    }
}