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
    public boolean isValidBST(TreeNode root) {
       return isBST(root).isBST;  
    }
    /*
     I was quite comfortable for writing code for it, was able to think edge cases. but code doesnt pass in one shot.
    */
    public dummyNode isBST(TreeNode root) {
        if(root == null) {
            dummyNode newNode = new dummyNode();
            newNode.isBST = true;
            newNode.max = Long.MIN_VALUE;
            newNode.min = Long.MAX_VALUE; 
            return newNode;
        }
        dummyNode left = isBST(root.left);
        dummyNode right = isBST(root.right);
       
        dummyNode newNode = new dummyNode();
        if(left.max < root.val && right.min > root.val) {
            if(left.isBST && right.isBST)
                newNode.isBST = true; 
        }
        newNode.max = Math.max(root.val, Math.max(right.max, left.max)); 
        newNode.min = Math.min(root.val, Math.min(left.min, right.min));
        return newNode; 
    }
    class dummyNode {
        long max, min;
        boolean isBST ;
    }
}
