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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode lessList = new ListNode(0);
        ListNode biggerList = new ListNode(0);

        ListNode lcur = lessList;
        ListNode bcur = biggerList;

        while (head != null) {
            if (head.val < x) {
                lcur.next = head;
                lcur = lcur.next;
            } else {
                bcur.next = head;
                bcur = bcur.next;
            }

            head = head.next;
        } 

        ListNode newHead;
        if (lessList.next != null) {
            newHead = lessList.next;
            lcur.next = biggerList.next;
            bcur.next = null;
        } else {
            newHead = biggerList.next;
            bcur.next = null;
        }

        return newHead;
    }
}