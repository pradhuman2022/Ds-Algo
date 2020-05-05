class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, TreeNode> map =  new HashMap<>();
        map.put(0, root);
        Queue<NodeInfo> qu = new LinkedList<>();
        List<Integer>ans = new ArrayList<>();
        qu.offer(new NodeInfo(0, root));
        if(root == null)
            return ans;
        while(!qu.isEmpty()){
            NodeInfo nodeVal = qu.poll();
            TreeNode node = nodeVal.node;
            TreeNode lastVisitedNode = null;
            if(node.left != null){
                lastVisitedNode = node.left;
                qu.offer(new NodeInfo(nodeVal.level + 1, node.left));
            }
            if(node.right != null){
                lastVisitedNode = node.right;
                qu.offer(new NodeInfo(nodeVal.level + 1, node.right));
            }
            if(lastVisitedNode != null)
                map.put(nodeVal.level + 1, lastVisitedNode);
        }
        
        for(Map.Entry<Integer, TreeNode> m : map.entrySet()) {
            ans.add(m.getValue().val);
        }
        qu = null;  
        map = null;
        return ans;
    }
    class NodeInfo{
        int level;
        TreeNode node; 
        NodeInfo(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }
}
