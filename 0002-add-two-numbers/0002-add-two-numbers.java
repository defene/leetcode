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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode sumCur = dummy;
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;

        boolean prev = false;
        while (l1Cur != null || l2Cur != null) {
            int cur = prev ? 1 : 0;
            prev = false;

            if (l1Cur != null) {
                cur += l1Cur.val;
                l1Cur = l1Cur.next;
            }

            if (l2Cur != null) {
                cur += l2Cur.val;
                l2Cur = l2Cur.next;
            }

            if (cur >= 10) {
                prev = true;
                cur %= 10;
            }
            ListNode node = new ListNode(cur);
            sumCur.next = node;
            sumCur = sumCur.next;
        }

        if (prev) {
            ListNode node = new ListNode(1);
            sumCur.next = node;
            sumCur = sumCur.next;            
        }

        return dummy.next;
    }
}