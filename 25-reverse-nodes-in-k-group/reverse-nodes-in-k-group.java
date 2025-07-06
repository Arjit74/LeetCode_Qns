class Solution {
    public ListNode reverseKGroup(ListNode h, int k) {
        ListNode d = new ListNode(0);
        d.next = h;
        ListNode g = d, e = d;

        while (true) {
            int i = 0;
            while (i < k && e != null) {
                e = e.next;
                i++;
            }
            if (e == null) break;

            ListNode s = g.next, n = e.next;
            e.next = null;

            g.next = rev(s);
            s.next = n;

            g = s;
            e = s;
        }
        return d.next;
    }

    ListNode rev(ListNode h) {
        ListNode p = null;
        while (h != null) {
            ListNode t = h.next;
            h.next = p;
            p = h;
            h = t;
        }
        return p;
    }
}
