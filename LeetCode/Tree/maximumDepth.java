class Solution {
    public int maxDepth(TreeNode root) {
        return getMaxDepthOfTree(root);
    }
    /*
        very Comfortable with implementation.
    */
    int getMaxDepthOfTree(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = getMaxDepthOfTree(root.left);
        int rightDepth = getMaxDepthOfTree(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
