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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fast = head;
        ListNode prevFast = null;
        ListNode prevSlow = null;
        boolean flag = false;

        while (fast != null) {
            ListNode slow = fast;
            for (int i = 0; i < k; i++) {
                if (fast == null) {
                    flag = true;
                    break;
                }
                prevFast = fast;
                fast = fast.next;
            }
            prevFast.next = null;
            if (prevSlow == null) head = flag ? slow : reverse(slow);
            else prevSlow.next = flag ? slow : reverse(slow);
            prevSlow = slow;
        }

        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}