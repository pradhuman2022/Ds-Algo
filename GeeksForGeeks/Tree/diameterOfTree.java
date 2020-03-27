class Tree {
    /* Complete the function to get diameter of a binary tree */
    int diameter(Node root) {
        // Your code here
        Pair p = new Pair();
        return diameterUtil(root, p);
        
    }
    
    int diameterUtil(Node root, Pair current) {
        if(root == null) {
            current.h = 0;
            return 0;
        }
        Pair l = new Pair();
        Pair r = new Pair();
        int ld = diameterUtil(root.left, l);
        int rd = diameterUtil(root.right, r);
        current.h = Math.max(l.h, r.h) + 1;
        
        return Math.max(l.h + r.h + 1, Math.max(ld, rd));
        
    }
    static class Pair {
        int h;
    }
}
