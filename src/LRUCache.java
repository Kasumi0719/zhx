import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head;
    Node tail;
    int capacity = 0;
    Map<Integer, Node> record = new HashMap<>();
    class Node{
        Node prev;
        Node next;
        int value;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (record.containsKey(key)){
            Node node = record.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = tail;
            tail = node;
            return node.value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        Node node = new Node();
        node.value = value;
        record.put(key, node);
        capacity -= 1;
        if (head == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        if (capacity < 0) {
            Node nextNode = head.next;
            record.remove(head.value);
            nextNode.prev = null;
            head.next = null;
            head = nextNode;
            capacity += 1;
        }
        return ;
    }
}
