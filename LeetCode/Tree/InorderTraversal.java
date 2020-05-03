/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> list ;//= new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        inorderOfTree(root);
        return list;
    }
    void inorderOfTree(TreeNode root) {
        if(root == null)
            return ;
        inorderOfTree(root.left);
        list.add(root.val);
        inorderOfTree(root.right);
    }
}
