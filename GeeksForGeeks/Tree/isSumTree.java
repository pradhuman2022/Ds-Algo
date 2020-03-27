class Tree
{
	boolean isSumTree(Node node)
	{
        // Your code here
        if(node == null)
            return true;
        
        int leftSum = findSum(node.left);
        int rightSum = findSum(node.right);
        
        if(node.data == leftSum + rightSum)
            return true;
            
        return false;
        
	}
	
    int findSum(Node node) {
        
        if(node == null)
            return 0;
        return node.data + findSum(node.left) + findSum(node.right) ;
    
    }
	
}
