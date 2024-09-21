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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;
        for (int i = 1; i < left; i++) {
            prev = cur;
            cur = cur.next;
        }

        int i = 0;
        ListNode con = prev;
        ListNode save = cur;
        while (i < right - left + 1) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        
        save.next = cur;
        return head;
    }
}