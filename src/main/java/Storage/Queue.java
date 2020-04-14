package Storage;

public class Queue {
    private static Node front, rear;
    private static int size;

    private static class Node {
        String key;
        Node next;
    }

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public static void enqueue(String key) {
        Node last_nnode = rear;
        rear = new Node();
        rear.key = key;
        rear.next = null;
        if (isEmpty()) {
            front = rear;
        } else {
            last_nnode.next = rear;
        }
        size++;
    }

    public static String dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            String key = front.key;
            front = front.next;
            size--;

            return key;
        }
    }

    private static boolean isEmpty() {
        return (size == 0);
    }

    public static int getSize() {
        return size;
    }
}