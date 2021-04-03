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
        
        return copyList(head);
    }
   HashMap<Node, Node> map = new HashMap<>();
    
    Node copyList(Node head) {
        
        if(head == null)
            return null;
        
        if(map.containsKey(head)) {
            return map.get(head);    
        }
        
        Node copy = new Node(head.val);
        map.put(head, copy);
        
        //Just think about copying as tree and to check whether a node is created or not, then use head value as key.
        copy.next = copyList(head.next);
        copy.random = copyList(head.random);
        
        return copy;
    }
}
