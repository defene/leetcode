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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode oldTail = head;
        int count = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            count++;
        }
        oldTail.next = head;

        int actualK = count - (k % count) - 1;
        ListNode newTail = head;
        for (int i = 0; i < actualK; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}