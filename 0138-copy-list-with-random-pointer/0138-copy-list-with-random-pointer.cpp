/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (head == nullptr) {
            return head;
        }
        
        unordered_map<Node*, Node*> map;
        Node* copyHead = new Node(head->val);
        map[head] = copyHead;

        Node* cur = copyHead;
        while (head != nullptr) {
            if (head->next != nullptr) {
                if (map.find(head->next) == map.end()) {
                    Node* newNode = new Node(head->next->val);
                    map[head->next] = newNode;
                }
                cur->next = map[head->next];
            }
            if (head->random != nullptr) {
                if (map.find(head->random) == map.end()) {
                    Node* newNode = new Node(head->random->val);
                    map[head->random] = newNode;
                }
                cur->random = map[head->random];
            }

            cur = cur->next;
            head = head->next;
        }

        return copyHead;
    }
};