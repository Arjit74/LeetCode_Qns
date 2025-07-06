import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] a) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode n : a) if (n != null) q.add(n);
        ListNode d = new ListNode(0), t = d;
        while (!q.isEmpty()) {
            ListNode n = q.poll();
            t.next = n;
            t = t.next;
            if (n.next != null) q.add(n.next);
        }
        return d.next;
    }
}
