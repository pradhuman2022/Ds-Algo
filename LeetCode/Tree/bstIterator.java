class BSTIterator {
    List<Integer> iterator; 
    public BSTIterator(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        this.iterator = inorderList;
    }
    
    /** @return the next smallest number */
    public int next() {
        if(this.iterator.size() == 0)
            return -1;
        else
        {
            int ans = this.iterator.get(0);
            this.iterator.remove(0);
            return ans;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
         if(this.iterator.size() == 0)
             return false;
         else
             return true;
        
    }
    void inorder(TreeNode root, List<Integer>inorderList){
        if(root == null)
            return;
        inorder(root.left, inorderList);
        inorderList.add(root.val);
        inorder(root.right, inorderList);
    }
}
