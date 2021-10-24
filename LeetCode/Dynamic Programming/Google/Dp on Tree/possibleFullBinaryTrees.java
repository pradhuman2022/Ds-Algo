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
    
    HashMap<Integer, List<TreeNode>> dp = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int n) {
        
        if (dp.containsKey(n))
            return dp.get(n);
        
        List<TreeNode> ans = new ArrayList<>();
        
        if (n == 1) {
            ans.add(new TreeNode(0));
        } else if (n % 2 == 1) {
            for (int x = 1; x < n - 1; x++) {
               List<TreeNode> leftSubtree = allPossibleFBT(x);
               List<TreeNode> rightSubtree = allPossibleFBT(n - 1 - x);
                
                for (TreeNode left: leftSubtree)  {
                    for (TreeNode right: rightSubtree) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
        }
        dp.put(n, ans);
        
        return dp.get(n);  
    }
}
