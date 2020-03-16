class Tree
{
    int height(Node node) 
    {
         // Your code here
         if(node == null)
            return 0; 
         
         int leftHeight = height(node.left);
         int rightHeight = height(node.right); 
         
         return Math.max(leftHeight, rightHeight) + 1 ; 
    }   
}
