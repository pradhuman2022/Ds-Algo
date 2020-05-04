class Solution {
    int target;
    public boolean hasPathSum(TreeNode root, int sum) {
        target = sum;
        if(root == null)
            return false;
        return hasPathSum(root.val, root);
    }/*
     mene ek glti ki wo ye thi ki mene check ni kiya tha ki kb true return krna hai
     hm tb hi return kr payege true jb sum equal ho target ke and leaf node sath mai.
    */
    public boolean hasPathSum(int currentSum, TreeNode root) {
        if(root == null && currentSum != target)
            return false;
        if(root != null && root.right == null && root.left == null && currentSum == target)
            return true; 
        boolean option1 = false ;
        if(root.left != null)
            option1 = hasPathSum(currentSum + root.left.val, root.left);
        boolean option2 = false;
        if(root.right != null)
            option2 = hasPathSum(currentSum + root.right.val, root.right);
        return option1 || option2 ;   
        }
}
