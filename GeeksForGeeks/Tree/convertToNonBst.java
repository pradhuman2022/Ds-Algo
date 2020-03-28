class GFG
{
    static int current = 0;
    Node constructTree(int n, int pre[], char preLN[])
    {
	    //Add your code here.
	    return  buildTree(pre, preLN) ;
	    nodeIndex = 0 ;
    }
    static int nodeIndex = 0 ;
    Node buildTree(int pre[], char preLN[]) {
        
        if(nodeIndex >= pre.length)
            return null;
            
        Node root = new Node(pre[nodeIndex]);
        
        if(preLN[nodeIndex++] == 'N') {
            root.left = buildTree(pre, preLN);
            root.right = buildTree(pre,preLN);
        }r
        return root;
    }
    
}
