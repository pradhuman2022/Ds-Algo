public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: new root
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        return upsideDownTree(root);
    }
    /*
        Tree ko clockwise rotate krna hai bs leftmost ko root bna do or root ka right h leftmost ka 
        left and root ko leftmost ka right bna do bs, recursively krrke le ayege sare 
        left substrees m
    
    */
    public TreeNode upsideDownTree(TreeNode root) {
        // write your code here
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        
        TreeNode flippedNode = upsideDownTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return flippedNode;
    }
}
