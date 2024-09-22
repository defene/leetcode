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
        ListNode cur = dummy;
        boolean overflow = false;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }    
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (overflow) sum++;
            overflow = sum >= 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        if (overflow) cur.next = new ListNode(1);

        return dummy.next;
    }
}