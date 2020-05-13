class Solution {
    /*
        mai b bfs souch rha tha but mne soucha ki depth nikal ke bfs lgate rho.
        but iski jrurt ni thi, ab chutiyap krne ki adat jo h kya kr skte hai.
    */
    public int findBottomLeftValue(TreeNode root) {
        int lastLeftMostNode = -1;
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel;
        currentLevel.add(root);
        
        while(!currentLevel.isEmpty()) {
            lastLeftMostNode = currentLevel.peek().val;
            nextLevel = new LinkedList<>();
            while(!currentLevel.isEmpty()) {
                TreeNode node = currentLevel.poll();
                if(node.left != null)
                    nextLevel.add(node.left);
                if(node.right != null)
                    nextLevel.add(node.right);
            }
            currentLevel = nextLevel;
        }
        return lastLeftMostNode;
    }
}
