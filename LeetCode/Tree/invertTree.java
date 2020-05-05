class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;
        
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
    
}
