struct Node {
    int key;
    int val;
    Node *next;
    Node *prev;
    Node(int key, int val) : key(key), val(val), next(nullptr), prev(nullptr) {}
};

class LRUCache {
private:
    int capacity;
    unordered_map<int, Node*> dic;
    Node* head;
    Node* tail;

public:
    LRUCache(int capacity) {
        this->capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        if (dic.find(key) == dic.end()) {
            return -1;
        }

        Node* cur = dic[key];
        remove(cur);
        add(cur);
        return cur->val;
    }
    
    void put(int key, int value) {
        if (dic.find(key) != dic.end()) {
            Node* oldNode = dic[key];
            remove(oldNode);
        } 
        
        Node* newNode = new Node(key, value);
        dic[key] = newNode;
        add(newNode);

        if (dic.size() > capacity) {
            Node* nodeToDelete = head->next;
            remove(nodeToDelete);
            dic.erase(nodeToDelete->key);
        }
    }

private:
    void add(Node *node) {
        Node *previousEnd = tail->prev;
        previousEnd->next = node;
        node->prev = previousEnd;
        node->next = tail;
        tail->prev = node;
    }

    void remove(Node *node) {
        node->prev->next = node->next;
        node->next->prev = node->prev;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */