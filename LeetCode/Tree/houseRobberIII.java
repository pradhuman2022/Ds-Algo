class Solution {
    /*
     i was pretty comfortable with solution.
    */
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int excludingRoot = rob(root.left) + rob(root.right);
        int includingRoot = root.val;
        if(root.left != null)
            includingRoot += rob(root.left.left) + rob(root.left.right);
        if(root.right != null)
            includingRoot += rob(root.right.left) + rob(root.right.right);
        return Math.max(includingRoot, excludingRoot);
    }
}
