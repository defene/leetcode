/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* cur1 = l1;
        ListNode* cur2 = l2;
        ListNode dummy(0);
        ListNode* curSum = &dummy;

        bool tenFlag = false;
        while (cur1 != nullptr || cur2 != nullptr) {
            int curVal = tenFlag ? 1 : 0;
            tenFlag = false;

            if (cur1 != nullptr) {
                curVal += cur1->val;
                cur1 = cur1->next;
            }

            if (cur2 != nullptr) {
                curVal += cur2->val;
                cur2 = cur2->next;
            }    

            ListNode* curNode = new ListNode(curVal % 10);
            tenFlag = (curVal / 10 == 1);
            curSum->next = curNode;
            curSum = curSum->next;        
        }

        if (tenFlag) {
            ListNode* curNode = new ListNode(1);
            curSum->next = curNode;
            curSum = curSum->next;              
        }

        return dummy.next;
    }
};