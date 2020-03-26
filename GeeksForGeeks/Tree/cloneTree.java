class GfG{
    public static Tree cloneTree(Tree tree){
       // add code here.
       Tree clone = createClone(tree);
       assignRandom(tree, clone);
       restoreTreeLeftNode(tree, clone);
       return clone;
       
    }
    
    static Tree createClone(Tree root) {
        
        if(root == null)
            return null;
        
        Tree left = root.left;
        Tree cloneNode = new Tree(root.data);
        root.left = cloneNode;
        cloneNode.left = left;
        
        if(left != null)
            left.left = createClone(left);
        
        cloneNode.right = createClone(root.right);
        return cloneNode;
    }
    
    static void assignRandom(Tree root, Tree clone) {
        if(root == null)
            return; 
        if(root.random != null)
            clone.random = root.random.left;
        else
            clone.random = null;
        if(root.left != null && clone.left != null)
            assignRandom(clone.left, clone.left.left);
        assignRandom(root.right, clone.right);
    }
    
    static void restoreTreeLeftNode(Tree root, Tree clone) {
        if(root == null)
            return;
        
        Tree left = clone.left ;
        if(clone.left != null) {
            clone.left = clone.left.left;
            root.left = left;
        }else {
            root.left = null ;
        }
        
        restoreTreeLeftNode(root.left, clone.left) ;
        restoreTreeLeftNode(root.right, clone.right);
    }
}
