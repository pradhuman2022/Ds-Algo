class Solution {
    List<Integer> inorderList = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);    
        return inorderList.get(k - 1);
    }
    /*
        I was able to come up with solution.
    */
    void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }
    
}
