 class Solution {
    long maxProductOfSplittedTree = 1;
    int mod = (int)Math.pow(10,9) + 7;
    long totalSum = 0;
    
    public int maxProduct(TreeNode root) {
        totalSum = findTotalSum(root);
        findMaxProduct(root);   
        maxProductOfSplittedTree = maxProductOfSplittedTree % mod ;
        return (int)maxProductOfSplittedTree;
    }
    
    public long findMaxProduct(TreeNode root) {
        if(root == null)
            return 0;
        
        long leftSum = findMaxProduct(root.left) ;
        long rightSum = findMaxProduct(root.right);
        long parentSum = totalSum - (leftSum + rightSum + root.val);
        //split rightSubtree and root with leftSubtree
        long splitTree1 = ((long)(leftSum + root.val + parentSum)) * rightSum;
        
        //split leftSubtree and root with right Subtree
        long splitTree2 = ((long)(rightSum + root.val + parentSum)) * leftSum;
        
        //split parentTree(all nodes which are including in subtree of current node) and current subtree
        long splitTree3 = ((long)(rightSum + root.val + leftSum)) * parentSum;
        maxProductOfSplittedTree = Math.max(maxProductOfSplittedTree, Math.max(splitTree3, Math.max(splitTree1, splitTree2)));
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
