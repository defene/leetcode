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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if (list1 == nullptr) {
            return list2;
        }
        if (list2 == nullptr) {
            return list1;
        }

        ListNode* cur1 = list1;
        ListNode* cur2 = list2;
        ListNode dummy(0);
        ListNode* curMerge = &dummy;

        while (cur1 != nullptr && cur2 != nullptr) {
            if (cur1->val < cur2->val) {
                curMerge->next = cur1;
                cur1 = cur1->next;
            } else {
                curMerge->next = cur2;
                cur2 = cur2->next;                
            }
            
            curMerge = curMerge->next;
        }

        if (cur1 != nullptr) {
            curMerge->next = cur1;
        }
        if (cur2 != nullptr) {
            curMerge->next = cur2;
        }

        return dummy.next;
    }
};