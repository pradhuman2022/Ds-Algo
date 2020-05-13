class Solution {
    
    int maxCount = 1;
    int currentCount = 1;
    ArrayList<Integer> list = new ArrayList<>();
    TreeNode previousNode = null;
    public int[] findMode(TreeNode root) {
        
        findCountOfNodesV1(root);
        int ans[] = new int[list.size()];
        int i = 0;
        for(int x: list)
            ans[i++] = x; 
         return ans;
    }
    void findCountOfNodesV1(TreeNode root) {
        if(root == null) {
            return;
        }
        findCountOfNodesV1(root.left);
        if(previousNode != null && root.val == previousNode.val)
            currentCount++;
        else
            currentCount = 1;
        
        if(currentCount == maxCount) 
            list.add(root.val);
        else if(currentCount > maxCount) {
            list = new ArrayList<>();
            list.add(root.val);
            maxCount = currentCount;
        }
        previousNode = root;
        inorder.add(root.val);
        findCountOfNodesV1(root.right);
    }
}
