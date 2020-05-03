class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root == null) 
            return ansList;
        Queue<TreeNode> temp; 
        while(!q.isEmpty()) {
            temp = new LinkedList<TreeNode>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(!q.isEmpty()) {
                TreeNode node = q.poll();
                list.add(node.val); 
                if(node.left != null)
                    temp.add(node.left);
                if(node.right != null)
                    temp.add(node.right);
            }
            ansList.add(list);
            q = temp; 
        }
        return ansList;
    }
}
