/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         connectNodes(root);
        return root;
    }
    public void connectNodes(Node root){
        
        if(root == null)
            return;
        /*we have root, suppose root is at whatever level is already connected,
          then we need to fill our from root.left to root---->rightMostNode
        */
        Node prev = null;
        Node current = root;
        Node leftMostNode = null;
        while(current != null) {
        //we know for one there could be atmost 2nodes
            
            if(prev != null){
                if(current.left != null)
                    prev.next = current.left;
                else if(current.right != null)
                    prev.next = current.right;
            } 
            
            if(current.left != null) {
                if(current.right != null) {
                    current.left.next = current.right; 
                    prev = current.right;
                }else{
                    prev = current.left;
                }
            }else if(current.right != null){
                prev = current.right;
            }
        current = current.next; 
        }
        leftMostNode = getLeftMostNode(root);
        connectNodes(leftMostNode);
    }
    
    Node getLeftMostNode(Node current) {
        Node nextRight = current; 
        while(nextRight != null){
            if(nextRight.left != null)
                return nextRight.left;
            if(nextRight.right != null)
                return nextRight.right;
            nextRight = nextRight.next;
        }
        return null;
    }
    
}
