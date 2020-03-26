class Tree
{
    void leftView(Node root)
    {
      // Your code here
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.offer(new TreeNode(0, root));
      Map<Integer,Node> map = new HashMap<Integer, Node>();
      map.put(0, root);
      
      while(!q.isEmpty()) {
          TreeNode front = q.poll();
          int l = front.level;
          
          Node leftSightNode = null ;
          if(front == null || front.root == null)
            continue; 
            
          if(front.root.right != null) {
              q.offer(new TreeNode(front.level + 1, front.root.right));
              leftSightNode = front.root.right;
          }
          if(front.root.left != null) {
              q.offer(new TreeNode(front.level + 1, front.root.left));
              leftSightNode = front.root.left;
          }
          map.put(l + 1, leftSightNode);
      }
        String ans = "";
        for (Map.Entry<Integer,Node> entry : map.entrySet()) 
            if(entry.getValue() != null)
                ans = ans +" "+entry.getValue().data;
        System.out.print(ans.trim());
      
    }
    
    static class TreeNode{
        int level;
        Node root;
        TreeNode(int level, Node root) {
            this.level = level;
            this.root = root;
        }
    }
}
