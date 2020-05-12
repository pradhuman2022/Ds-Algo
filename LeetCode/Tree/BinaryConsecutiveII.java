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
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    int longestConsecutiveSequence = 1;
    public int longestConsecutive2(TreeNode root) {
        // write your code here
        findLongestSequence(root);
        return longestConsecutiveSequence;
    }
    Pair findLongestSequence(TreeNode root) {
        if(root == null)
            return new Pair(0, 0); 
        
        /*
            mai increment and decrement ka ni kr para tha bs sare nodes pr us element ko include krke
            lengthOfIncreasingOrder and lengthOfDecreasingOrder nikalne hai.
            hr node pr do condition bnegi
            lengthOfDecreasingOrder -x- lengthOfIncreasingOrder
            lengthOfIncreasingOrder -x- lengthOfDecreasingOrder
            lengthOfDecreasingOrder -x- 0
            lengthOfIncreasingOrder -x- 0
        */
        Pair leftSeq = findLongestSequence(root.left);
        Pair rightSeq = findLongestSequence(root.right);
        int lengthOfIncreasingOrder = 1;
        int lengthOfDecreasingOrder = 1; 
        //lengthOfIncreasingOrder
        if(root.left != null && root.val - root.left.val == 1) {
            lengthOfIncreasingOrder = Math.max(lengthOfIncreasingOrder, leftSeq.lengthOfIncreasingOrder + 1);
        //lengthOfDecreasingOrder
        }else if(root.left != null && root.val - root.left.val == -1) {
           lengthOfDecreasingOrder = Math.max(lengthOfDecreasingOrder, leftSeq.lengthOfDecreasingOrder + 1);
        }
        
        if(root.right != null && root.val - root.right.val == 1) {
            lengthOfIncreasingOrder = Math.max(lengthOfIncreasingOrder, rightSeq.lengthOfIncreasingOrder + 1);
        }else if(root.right != null && root.val - root.right.val == -1) {
            lengthOfDecreasingOrder = Math.max(lengthOfDecreasingOrder, rightSeq.lengthOfDecreasingOrder + 1);
        }
        longestConsecutiveSequence = Math.max(longestConsecutiveSequence, lengthOfIncreasingOrder + lengthOfDecreasingOrder - 1);
        Pair p = new Pair(lengthOfIncreasingOrder, lengthOfDecreasingOrder);
        return p;
    }
    class Pair{
        int lengthOfIncreasingOrder;
        int lengthOfDecreasingOrder;
        Pair(int lengthOfIncreasingOrder, int lengthOfDecreasingOrder){
            this.lengthOfDecreasingOrder = lengthOfDecreasingOrder;
            this.lengthOfIncreasingOrder = lengthOfIncreasingOrder;
        }
    }
    
}
