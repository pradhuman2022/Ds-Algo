class Tree
{

	public static Node deleteNode(Node root, int value)
	{
		// code here.
		if(root == null)
		    return null; 
		
		if(root.data > value)
		    root.left = deleteNode(root.left, value);
		else if(root.data < value)
		    root.right = deleteNode(root.right, value);
	    else {
            if(root.left == null)
                return root.right ;
            else if(root.right == null)
                return root.left; 
            
            root.data = findMinValue(root.right) ; 
            root.right = deleteNode(root.right, root.data);
	    }
	    return root;
		
	}
	static int findMinValue(Node root) {
	    int minv = root.data;
	    while (root.left != null) 
        { 
            minv = root.left.data; 
            root = root.left; 
        }
        return minv;
	}
	
}	
