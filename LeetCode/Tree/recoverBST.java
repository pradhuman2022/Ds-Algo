class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode previous = null; 
    public void recoverTree(TreeNode root) {
       findFirstSecond(root); 
       int temp = first.val ; 
       first.val = second.val; 
       second.val = temp; 
    }
    /*
        i wasn't able to even think about solution but solution looks pretty easy.
        basically BST ka inorder hota h jo sorted hota hai agr do number swap ho b gye to hmko
        hmko do pair milege jisme 
        i1 > i2 hoga to first node hoga wo first pair ka i1 hoga and second pair i3 > i4 mai se i4 hoga.
        hr bar previous pointer ko rkh ke check krlege bs.
    */
    void findFirstSecond(TreeNode root) {
        if(root == null)
            return ;
        
        findFirstSecond(root.left); 
        if(previous != null) {
            if(previous.val > root.val){
                if(first == null) 
                    first = previous;
                second = root;
            }
        }
        previous = root; 
        findFirstSecond(root.right); 
    }
}
