class Solution {
    TreeNode prevNode = null;
    public TreeNode bstToGst(TreeNode root) {
        BstToGst(root);
        return root;
    }
    /*
        I was comfortable with solution and made by own. 
        using reversed inorder.
    */
    void BstToGst(TreeNode root) {
        if(root == null)
            return ;
        bstToGst(root.right);
        if(prevNode != null)
            root.val = root.val + prevNode.val;
        prevNode = root;
        bstToGst(root.left);
    } 
}
