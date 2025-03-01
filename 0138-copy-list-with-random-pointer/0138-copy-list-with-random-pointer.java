/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        map.put(head, new Node(head.val));
        Node oriCur = head;
        Node cur = map.get(head);

        while (oriCur != null) {
            if (oriCur.next != null) {
                if (!map.containsKey(oriCur.next)) {
                    map.put(oriCur.next, new Node(oriCur.next.val));
                }
                cur.next = map.get(oriCur.next);
            }
            if (oriCur.random != null) {
                if (!map.containsKey(oriCur.random)) {
                    map.put(oriCur.random, new Node(oriCur.random.val));
                }
                cur.random = map.get(oriCur.random);
            }

            oriCur = oriCur.next;
            cur = cur.next;
        }

        return map.get(head);
    }
}