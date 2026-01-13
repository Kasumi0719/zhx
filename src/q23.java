import java.util.Comparator;
import java.util.PriorityQueue;

public class q23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (pq.size() != 0) {
            cur.next = pq.poll();
            cur = cur.next;
            pq.add(cur.next);
        }
        return dummy.next;
    }
}
