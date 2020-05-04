class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        currentLevel.add(root);
        if(root == null)
            return ansList;
        while(!currentLevel.isEmpty()){
            TreeNode node = currentLevel.poll();
            list.add(node.val);
            if(node.left != null)
                nextLevel.add(node.left);
            if(node.right != null)
                nextLevel.add(node.right);
            
            if(currentLevel.isEmpty()){
                currentLevel = nextLevel; 
                nextLevel = new LinkedList<>();
                ansList.add(list);
                list = new ArrayList<>();
            }
        }
        Collections.reverse(ansList);
        return ansList;
    }
}
