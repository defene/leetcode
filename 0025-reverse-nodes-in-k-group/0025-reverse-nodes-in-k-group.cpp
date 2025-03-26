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
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* slow = head;
        ListNode* fast = head;

        ListNode dummy(0, head);
        ListNode* prev = &dummy;
        while (fast != nullptr && fast->next != nullptr) {
            for (int i = 0; i < k - 1; i++) {
                if (fast->next != nullptr) {
                    fast = fast->next;
                } else {
                    return dummy.next;
                }
            }

            ListNode* nextGroup = fast->next;
            fast->next = nullptr;
            ListNode* newCurGroupHead = reverseList(slow);
            prev->next = newCurGroupHead;
            slow->next = nextGroup;

            prev = slow;
            fast = slow->next;
            slow = slow->next;
        }

        return dummy.next;
    }

private:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        while (head != nullptr) {
            ListNode* next = head->next;
            head->next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
};