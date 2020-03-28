class Tree {
    
    public static boolean isIdentical(Node T, Node S) {
        
        if(T == null && S == null)
            return true;
        if(T == null || S == null)
            return false;
        return (T.data == S.data) && isIdentical(T.left, S.left) && isIdentical(T.right, S.right);
    }

    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if(S == null)
            return true;
            
        if(T == null)
            return false;
            
        if(isIdentical(T, S))
            return true;
        return isSubtree(T.left, S) || isSubtree(T.right, S) ;
    }
}
