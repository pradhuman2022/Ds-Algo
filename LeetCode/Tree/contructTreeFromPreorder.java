class Solution {
    int preorder[];
    int inorder[];
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return constructTree(0, preorder.length - 1, 0);
    }
    /*
     mai ye solution souch ni paya kyuki bhul gya tha ki preorder or inorder se kese bnate hai
     tree lol, koi ni but easy h, krna h ki start se end tk ka tree build krna hai,
     or hr bat root ka index lekr chlna pdega ki next root kya hoga preorder array mai.
     or hr barstart or end ki window ka tree build krte rhge.
    */
    TreeNode constructTree(int start, int end, int indexOfRootInPreOrder) {
        if(start > end || indexOfRootInPreOrder >= preorder.length)
            return null;
        TreeNode rootNode = new TreeNode(preorder[indexOfRootInPreOrder]);
        int rootIndex = -1; 
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[indexOfRootInPreOrder]){
                rootIndex = i;
                break;
            }
        }
        TreeNode leftTree = constructTree(start, rootIndex - 1, indexOfRootInPreOrder + 1);
        TreeNode rightTree = constructTree(rootIndex + 1, end, indexOfRootInPreOrder + rootIndex - start + 1);
        rootNode.left = leftTree;
        rootNode.right = rightTree;
        return rootNode;
    }
}
