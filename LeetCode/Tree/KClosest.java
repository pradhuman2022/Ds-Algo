public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    double target ;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        Stack<Integer> leftToClosestValue = new Stack<>();
        Stack<Integer> rightToClosestValue = new Stack<>();
        this.target = target;
        fillLeftToClosestValue(leftToClosestValue, root);
        fillRightToClosestValue(rightToClosestValue, root);
        List<Integer> result = new ArrayList<Integer>();
        
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
    I came up with multiple approaches, but starting m blank tha ki kese logn m krege.
    stack m sari target se choti value and bdi value store kra List or bdi alg fr check krte jyge.
    */
    void fillLeftToClosestValue(Stack<Integer> leftToClosestValue, TreeNode root) {
        if(root == null)
            return  ;
        fillLeftToClosestValue(leftToClosestValue, root.left);
        if(root.val > target)
            return;
        leftToClosestValue.push(root.val);
        fillLeftToClosestValue(leftToClosestValue, root.right);
    }
    
    void fillRightToClosestValue(Stack<Integer> rightToClosestValue, TreeNode root) {
        if(root == null)
            return ;
        
        fillRightToClosestValue(rightToClosestValue, root.right);
        if(root.val <= target)
            return;
        rightToClosestValue.push(root.val);
        fillRightToClosestValue(rightToClosestValue, root.left);
    }
}
