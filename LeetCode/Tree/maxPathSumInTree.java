class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }/*
        m sum ko add up ni kr para tha mtlb ki m decide ni kr para tha ki konsa part add krna h.
        hmare pass ootion h ki ya root ka value le ya to left ka lele ya right ka.
        or har bari calculate krege maximum sum kya.
    */
    int findMaxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        int leftSum = findMaxPathSum(root.left);
        int rightSum = findMaxPathSum(root.right);
        int totalSum = root.val + leftSum + rightSum; 
        int maxValue = Math.max(root.val, Math.max(leftSum, rightSum) + root.val);
        maxSum = Math.max(maxSum, Math.max(maxValue, totalSum));
        return maxValue;
    }
}
