class Solution {
    int postorder[];
    int inorder[];
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       this.postorder = postorder;
        this.inorder = inorder;
        return constructTree(0, postorder.length - 1, postorder.length - 1);
    }
    TreeNode constructTree(int start, int end, int indexOfRootInPostOrder) {
        if(start > end || indexOfRootInPostOrder < 0)
            return null;
        TreeNode rootNode = new TreeNode(postorder[indexOfRootInPostOrder]);
        int rootIndex = -1; 
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == postorder[indexOfRootInPostOrder]){
                rootIndex = i;
                break;
            }
        }
        TreeNode rightTree = constructTree(rootIndex + 1, end, indexOfRootInPostOrder - 1);
        TreeNode leftTree = constructTree(start, rootIndex - 1, indexOfRootInPostOrder - (end - rootIndex) - 1);
        rootNode.left = leftTree;
        rootNode.right = rightTree;
        return rootNode;
    }
}
