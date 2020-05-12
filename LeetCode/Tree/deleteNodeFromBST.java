class Solution {
    /*
     i know the logic and way ki kese delete  krna hai
     or left ni h to right ko swap krna hai
     ye ni kr paya. exaclty mne deleteNode ki definition ni bnayi
     
    */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val > key)
            root.left = deleteNode(root.left, key);
        else if(root.val < key)
            root.right = deleteNode(root.right, key);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            int successor = findSuccessor(root.right);
            root.val = successor;
            root.right = deleteNode(root.right, successor);
        }
        return root;
    }
    int findSuccessor(TreeNode root) {
        
        if(root.left != null)
            return findSuccessor(root.left);
        return root.val;
    }
    
}
