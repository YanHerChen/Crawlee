package Parser;

import Storage.*;

import java.util.ArrayList;

public class DataProcess {
    public static void handling() {
        String TName = Queue.dequeue();
        ArrayList<String> data = Data.getData(TName);
    }
}