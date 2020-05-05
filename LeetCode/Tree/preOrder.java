class Solution {
    List<Integer> ansList = new ArrayList<>(); 
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return ansList;
    }
    public void preOrder(TreeNode root){
        if(root == null)
            return ;
        ansList.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
