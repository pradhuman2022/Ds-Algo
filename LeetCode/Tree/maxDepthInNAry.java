/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int maxDepth = 0;
    public int maxDepth(Node root) {
       // dfs(1, root);
        return bfs(root);
    }
    
    private void dfs(int currentDepth, Node root) {
        
        if(root == null) {
            return;
        }
        
        if(root.children == null || root.children.size() == 0) {
            maxDepth = Math.max(maxDepth, currentDepth);
        }
        
        for (Node childNode: root.children) {
            dfs(currentDepth + 1, childNode);
        }
    }
    
    private int bfs(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int currentLevel = 0;
        if(root == null)
            return currentLevel;
        
        while(!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = q.poll();  
                for (Node childNode: currentNode.children) {
                    q.add(childNode);
                }
            }
            currentLevel++; 
        } 
        return currentLevel;
    }
}
