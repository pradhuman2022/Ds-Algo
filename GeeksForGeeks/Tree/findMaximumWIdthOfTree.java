 public int getMaxWidth(TreeNode root) {
        int heightOfTree = findHeightOfTree(root);
        int maxWidth = 0 ;
        for(int h = 1; h <= heightOfTree; h++) {
            int countOfNodesAtH = getNodesAtLevel(root, h);
            maxWidth = Math.max(countOfNodesAtH, maxWidth);
        }
        return maxWidth;
    }
    public int getNodesAtLevel(TreeNode root, int level) {
        if(root == null)
            return 0; 
        if(level == 1)
            return 1; 
        else if(level > 1)
            return getNodesAtLevel(root.left, level - 1) + getNodesAtLevel(root.right, level - 1);
        return 0; 
    }
    
    public int findHeightOfTree(TreeNode root) {
        if(root == null)
            return 0; 
        
        int leftHeight = findHeightOfTree(root.left);
        int rightHeight = findHeightOfTree(root.right);
        
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
