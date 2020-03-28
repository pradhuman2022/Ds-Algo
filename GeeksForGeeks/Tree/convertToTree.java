class GFG
{
    static int current = 0;
    Node constructTree(int n, int pre[], char preLN[])
    {
	    //Add your code here.
	    return  buildTree(0, pre.length - 1, pre) ;
    }
    
    Node buildTree(int start, int end, int pre[]) {
        if(start >= pre.length || start > end)
            return null;
        
        Node node = new Node(pre[start]);
        if(start == end)
            return node ;
        start = start + 1 ; 
        int k;
        for(k = start ; k <= end && k < pre.length; k++) {
            if(pre[k] > node.data)
                break;
        }
        
        node.left = buildTree(start, k - 1, pre);
        node.right = buildTree(k, end, pre);
        return node;
    }
    
}
