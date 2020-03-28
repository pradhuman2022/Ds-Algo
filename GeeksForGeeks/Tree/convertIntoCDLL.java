class Tree
{ 
    Node head ;
    Node last ;
    Node bTreeToClist(Node root)
    {
        //your code here
        TreeToDLL(root);
        Node curr = head; 
        while(curr.right != null)
            curr = curr.right;
        curr.right = head;
        head.left = curr;
        return head;
    }
    public void TreeToDLL(Node root) {
         
        if(root == null)
            return ;
            
        TreeToDLL(root.right);
        if(head != null)
            head.left = root;
        root.right = head ;
        head = root;
        TreeToDLL(root.left);
    }
    
}
    
