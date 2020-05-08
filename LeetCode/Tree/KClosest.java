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
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    double target ;
    double minAbsDiff = Integer.MAX_VALUE;
    int secondValue = -1;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        Stack<Integer> leftToClosestValue = new Stack<>();
        Stack<Integer> rightToClosestValue = new Stack<>();
        this.target = target;
        getNumberClosestToK(root, target);
        fillLeftToClosestValue(leftToClosestValue, root);
        fillRightToClosestValue(rightToClosestValue, root);
        List<Integer> result = new ArrayList<Integer>();
        //result.add(secondValue);
        for(int i = 0 ; i < k; i++){
            if (leftToClosestValue.isEmpty()) {
                result.add(rightToClosestValue.pop());
            } else if (rightToClosestValue.isEmpty()) {
                result.add(leftToClosestValue.pop());
            } else if (Math.abs((double) leftToClosestValue.peek() - target) < Math.abs((double) rightToClosestValue.peek() - target)) {
                result.add(leftToClosestValue.pop());
            } else {
                result.add(rightToClosestValue.pop());
            }        
        }
        return result;
    }
    /*
        phle closest value nikal lo then uske successor ko stack m dalo or predecssor.
        fr k times chla do bs.
        LDR is in increasing order and RDL is in descresing order, so LDR krke predceessor le aaao
        or RDL krke successor.
    */
    void fillLeftToClosestValue(Stack<Integer> leftToClosestValue, TreeNode root) {
        if(root == null)
            return  ;
        fillLeftToClosestValue(leftToClosestValue, root.left);
        if(root.val > secondValue)
            return;
        leftToClosestValue.push(root.val);
        fillLeftToClosestValue(leftToClosestValue, root.right);
    }
    
    void fillRightToClosestValue(Stack<Integer> rightToClosestValue, TreeNode root) {
        if(root == null)
            return ;
        
        fillRightToClosestValue(rightToClosestValue, root.right);
        if(root.val <= secondValue)
            return;
        rightToClosestValue.push(root.val);
        fillRightToClosestValue(rightToClosestValue, root.left);
    }
        
      void getNumberClosestToK(TreeNode root, double target) {
        if(root == null)
            return ;
        if(root.val == target){
            secondValue = root.val;
            return ;
        }        
        if(minAbsDiff >= Math.abs(root.val - target)) {
            minAbsDiff = Math.abs(root.val - target);
            secondValue = root.val;
        }
        if(target < root.val)
            getNumberClosestToK(root.left, target);
        else
            getNumberClosestToK(root.right, target);
    }
}
