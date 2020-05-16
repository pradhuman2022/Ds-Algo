public class Solution {
    boolean isPossibleToPartition = false;
    int mod = (int)Math.pow(10,9) + 7;
    long totalSum = 0;

    public boolean checkEqualTree(TreeNode root) {
        totalSum = findTotalSum(root);
        canPartition(root);   
        return  isPossibleToPartition;
    }

    public long canPartition(TreeNode root) {
        if(root == null)
            return 0;

        long leftSum = canPartition(root.left) ;
        long rightSum = canPartition(root.right);
        long parentSum = totalSum - (leftSum + rightSum + root.val);
        //split rightSubtree and root with leftSubtree
        
        boolean splitLeftTree = false;
        boolean splitRightTree = false;
        if(leftSum + root.val + parentSum == rightSum)
            splitRightTree = true;

        //split leftSubtree and root with right Subtree
        if(rightSum + root.val + parentSum == leftSum)
             splitLeftTree =  true;

        isPossibleToPartition = splitRightTree || splitLeftTree;
        
        return root.val + leftSum + rightSum;
    }

    public long findTotalSum(TreeNode root) {
        if(root == null)
            return 0;
        long leftSum = findTotalSum(root.left);
        long rightSum = findTotalSum(root.right);
        return root.val + leftSum + rightSum;
    }
}
