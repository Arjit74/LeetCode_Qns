/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
    1 find tail and find length
    2 link to head and make a loop
    3 moving k units to right is same as moving len-k units to left.
    4 detach tail
     */
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head, q = head;
        if(k == 0 || head == null || head.next == null) return head;
        int len = 1; 
        while(p.next!=null){
            p = p.next;
            len++;
        }
        // p will be at tail, loop now
        p.next = head;

        k%=len;
        // moving k to the right is same as moving len-k to the left
        k = len-k;
        p = head; q = head;
        // q will hold the node previous to p
        while(k-- > 0) {
            q = p;
            p = p.next;
        }
        // return head, and unlink loop
        q.next = null;
        return p;
    }
}