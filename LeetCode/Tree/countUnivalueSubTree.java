/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    int countUnviValTree = 0;
    public int countUnivalSubtrees(TreeNode root) {
        // write your code here
        isTreeUnivalued(root);
        return countUnviValTree;
    }
    /*
        phle to muje question smj ni aya then mne ek solution dekha tha then fr thoda
        khud se logic build krke code kia. 
        bs left or right se agr equal hai root ki value , then isLeftTreeUnivalued and isRightTreeUnivalued
        ko update krna pdega ni to usko aise hi chor dege. or else mai left m jake ke count krlenge.
    */
    public boolean isTreeUnivalued(TreeNode root) {
        
        if(root == null)
            return true;

        boolean isLeftTreeUnivalued = false;
        if(root.left != null) {
            if(root.left.val == root.val)
                isLeftTreeUnivalued = isTreeUnivalued(root.left); 
            else
                isTreeUnivalued(root.left);
        }else {
            isLeftTreeUnivalued = true;
        }
        boolean isRightTreeUnivalued = false;
        
        if(root.right != null) {
            if(root.right.val == root.val)
                isRightTreeUnivalued = isTreeUnivalued(root.right);
            else
                isTreeUnivalued(root.right);
        }else {
            isRightTreeUnivalued = true; 
        }
        
        if(isLeftTreeUnivalued && isRightTreeUnivalued)
            countUnviValTree++; 
        
        return isLeftTreeUnivalued && isRightTreeUnivalued;
    }
    
    
}
