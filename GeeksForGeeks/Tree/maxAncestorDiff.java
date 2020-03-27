class Solution {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiff1(root,root.val, root.val);
        return res; 
    }
    
    public void maxAncestorDiff1(TreeNode root, int min , int max) {
        if(root == null)
            return  ;
        res = Math.max(res, Math.abs(root.val - min)); 
        res = Math.max(res, Math.abs(root.val - max));
        maxAncestorDiff1(root.left, Math.min(min, root.val), Math.max(max, root.val));
        maxAncestorDiff1(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
}
