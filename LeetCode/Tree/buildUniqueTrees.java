class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){            
            ArrayList<TreeNode> ansList = new ArrayList<TreeNode>(); 
            return ansList;
        }
        return buildUniqueTrees(1, n);         
    }
    
    public List<TreeNode> buildUniqueTrees(int start, int end) {
        
        if(start > end){
            List<TreeNode> ansList = new ArrayList<TreeNode>();
            ansList.add(null);
            return ansList;
        }
        /*
            muje logic pta tha but ye sare left subtree ko generate krke unke root store krne ka concept ni ara tha,
            muje lgra tha ki 2D array chaiye h store krne k liy.
            but same countBst ki trh krna h or ans m sare Trees k root bhejne hai bs.
        */
        List<TreeNode> ansList = new ArrayList<TreeNode>(); 
        for(int root = start; root <= end; root++) {
            List<TreeNode> leftSubTree = buildUniqueTrees(start, root - 1); 
            List<TreeNode> rightSubTree = buildUniqueTrees(root + 1, end); 
            for(int leftTreeSize = 0; leftTreeSize < leftSubTree.size(); leftTreeSize++) {
                TreeNode leftTree = leftSubTree.get(leftTreeSize); 
                for(int rightTreeSize = 0; rightTreeSize < rightSubTree.size(); rightTreeSize++) {
                    TreeNode rootNode = new TreeNode(root); 
                    rootNode.left = leftTree;
                    rootNode.right = rightSubTree.get(rightTreeSize);
                    ansList.add(rootNode);
                }
            }
        }
        return ansList; 
    }
}
