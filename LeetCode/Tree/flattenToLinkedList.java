class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
   /*
    1.khud se hogya question bs hmko previous maintain krke rkhna tha but mne ek glti ki jb previous k right ko current se
    swap krre the toh prev ka right change hora tha jo ni hona chaiye.
    2.or left ka null ni krra tha mai ye glti thi.
   */
   public void flattenTree(TreeNode root) {
       if(root == null)
           return;
       TreeNode left = root.left;
       TreeNode right = root.right;
       if(prev != null){
           prev.right = root;
           prev.left = null;
       }
       prev = root;
       flattenTree(left);
       flattenTree(right);
   }
}
