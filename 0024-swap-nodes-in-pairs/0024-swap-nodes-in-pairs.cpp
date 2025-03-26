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
    ListNode* swapPairs(ListNode* head) {
        ListNode dummy(0, head);
        ListNode* prev = &dummy; 
        while (head != nullptr && head->next != nullptr) {
            ListNode *next = head->next;
            
            head->next = head->next->next;
            next->next = head;
            prev->next = next;
            
            prev = head;
            head = head->next;
        }

        return dummy.next;
    }
};