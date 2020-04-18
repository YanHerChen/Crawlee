package Frontier;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Frontier {
    private static AtomicInteger index;
    public static ArrayList<String> url = new ArrayList();
    public static ArrayList<String> filename = new ArrayList();

    Frontier() {
        setUrl();
    }

    private static void setUrl() {
        index = new AtomicInteger(0);
    }

    private static int increment() {
        return index.getAndIncrement();
    }

    public static void putUrl(String address) {
        url.add(address);
    }

    public static void putFileName(String name) {
        filename.add(name);
    }

    public static String nextUrl() {
        return url.get(increment());
    }

    public static String getName(int index) {
        return filename.get(index);
    }

    public static int getSize() {
        return url.size();
    }
}