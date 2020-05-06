class Solution {
    /*
      m ye to souch para tha agr left or right se jo recent node aara h to wo ans hoga, but
      krna ye cahiye tha ki sbi node p jake dekho ki left m ya right m dono me se dono aara hai 
      toh current node lca hoga or usko return krdege. 
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null)
            return null;
        if(root.val == node1.val || root.val == node2.val)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        if(left != null && right != null)
            return root;
        
        if(left == null)
            return right; 
        return left;
    }
}
