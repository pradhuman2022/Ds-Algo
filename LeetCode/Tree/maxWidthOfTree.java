class Solution {
    /*
        muje leftMost and rightmost wala logic ni aya tha, 
        so muje left k liy 2*i or right ke liy 2 * i + 1
        krna hai. jisse next level ko 0, 1, 2, 3...N ke 
        order mai rkh ke width calculate kr paye.
        sbi level pr left most node or rightmost node 
        ki position nikal lo or distacne 
        r - l + 1 se calc krke maxWidth se compare krte rho.
    */
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int maxWidth = 1;
        Deque<Pair> currentLevel = new LinkedList<>();
        Deque<Pair> nextLevel = new LinkedList<>();
        currentLevel.add(new Pair(0, root, 0));
        int currentDepth = 0; 
        int leftMost = 0; 
        while(!currentLevel.isEmpty()) {
            Pair p = currentLevel.poll();
            TreeNode rootNode = p.root;
            if(rootNode != null) {
                nextLevel.add(new Pair(p.position * 2, rootNode.left, p.depth + 1));
                nextLevel.add(new Pair((p.position * 2) + 1, rootNode.right, p.depth + 1));
                
                if(currentDepth != p.depth) {
                    leftMost = p.position; 
                    currentDepth = p.depth;
                }
                maxWidth = Math.max(maxWidth, p.position - leftMost  + 1);
            }
            if(currentLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }
        return maxWidth;
    }
    class Pair{
        int position; 
        TreeNode root;
        int depth;
        Pair(int position, TreeNode root, int depth) {
            this.position = position;
            this.root = root;
            this.depth = depth;
        }
    }
   
}
