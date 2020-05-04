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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 != null && t2 == null || t1 == null && t2 != null )
                return false; 
            if(t1 == null && t2 == null)
                continue; 
            if(t1.val != t2.val)
                return false; 
            q.add(t1.left);
            q.add(t2.right); 
            q.add(t1.right); 
            q.add(t2.left); 
        }
       return true;  
    }
}