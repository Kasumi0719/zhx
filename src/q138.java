import java.util.HashMap;
import java.util.Map;

public class q138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    Map<Node, Node> record = new HashMap<>();
    public Node copyRandomList(Node head) {
        Node newHead = new Node(head.val);
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.next == null){
                newHead.next = null;
            }
            Node newNode = new Node(temp.next.val);
            newHead.next = newNode;
            newHead = newHead.next;
            record .put(temp, newNode);
        }
        for (Node temp = head; temp != null; temp = temp.next) {
            record.get(temp).random = record.get(temp.random);
        }
        return record.get(head);
    }
}
