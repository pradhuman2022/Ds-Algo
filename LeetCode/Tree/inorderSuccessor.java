public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        Stack<TreeNode> successor = new Stack<>();
        successor.push(null);
        findSuccessor(root, p, successor);
        return successor.peek();
    }
    /*
        first go to reverse direction then store all those values which are greater than current root
        value.
    */
    void findSuccessor(TreeNode root, TreeNode target, Stack<TreeNode> successor) {
        if(root == null)
            return;
        findSuccessor(root.right, target, successor);
        if(root.val <= target.val)
            return ;
        successor.push(root);
        findSuccessor(root.left, target, successor);
    }
}
