class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        List<List<Integer>> ansList = new ArrayList<>();
        boolean leftToRight = false;
        if(root == null) {
            return ansList;
        }
        /*
          m is question mai question queue krra tha and mujse leftToRight flag shi ni hora tha.
          hm do stack ko use krege jisme currentlevel hoga agr leftToRight false h to nextLevel hm log ko 
          right to left rkhna pdega or true to left to right.
        */
        ArrayList<Integer> list = new ArrayList<>(); 
        currentLevel.push(root);
        while(!currentLevel.isEmpty()){
            TreeNode node = currentLevel.pop();
            list.add(node.val); 
            if(!leftToRight){
                if(node.left != null)
                    nextLevel.push(node.left);
                if(node.right != null)
                    nextLevel.push(node.right);
            }else{
                if(node.right != null)
                    nextLevel.push(node.right);
                 if(node.left != null)
                    nextLevel.push(node.left);
            }
            if(currentLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new Stack<>();
                leftToRight = !leftToRight;
                ansList.add(list);
                list = new ArrayList<>();
            }
        }
        currentLevel = null;
        nextLevel = null;
        return ansList;
    }
    
}
