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
        if(head == null)
            return null ;
        
        putCopiedNodeInBetween(head);
        connectWithRandomPointer(head);
        Node headOfCopiedNode = splitList(head);
        return headOfCopiedNode;
    }
       
    void putCopiedNodeInBetween(Node head) {
        if(head == null)
            return ;
        
        Node copyOfCurrentNode = new Node(head.val);
        Node nextOfHead = head.next;
        head.next = copyOfCurrentNode;
        copyOfCurrentNode.next = nextOfHead;
        putCopiedNodeInBetween(nextOfHead);
    }
    
    void connectWithRandomPointer(Node head) {
        if(head == null)
            return;
        
        Node copiedNode = head.next; 
        
        if(head.random != null)
            copiedNode.random = head.random.next;
        connectWithRandomPointer(head.next.next);
    } 
    
    Node splitList(Node head) {
    
        Node headList = head.next;
        Node currentNode = head.next;
        head.next = currentNode.next;
        
        while(currentNode.next != null) {
            Node nextCopiedNode = currentNode.next.next;
            currentNode.next.next = currentNode.next.next.next;
            currentNode.next = nextCopiedNode;
            currentNode = currentNode.next;
        }
        
       return headList;  
    }
}
