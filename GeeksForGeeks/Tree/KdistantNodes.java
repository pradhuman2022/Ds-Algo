Given a binary tree, a target node in the binary tree,
and an integer value k, print all the nodes that are at distance k from the given target node. 
No parent pointers are available.
  k = 2 
  nodeValue = 3 ;
             4
        5          8
    7       3   10    9
    
    ans = 7, 4
    
    
            4,null
        5,4         8,4
    7,5    3,5   10,8   9,8
    
    class Pair{
        Node node;
        int dist;
        Pair(Node node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    
    HashMap<Node,Node> h;
    printKNodes(Node root,Node parent){
        if(root == null)
            return;
        h.put(root,parent);
        printKNodes(root.left,root);
        printKNodes(root.right,root);
    }
    
    HashMap<Node,Integer> vis;
    getKDistanceNodes(Node source){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(h.get(source),0));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            vis.put(temp.node,1);
            if(temp.dist == k){
                System.out.println(temp.val);
            }
            if(temp.left != null && !vis.containsKey(temp.left.node)) {
                q.add(new Pair(temp.left,temp.dist+1));
            }
            if(temp.right != null && !vis.containsKey(temp.right.node))
                q.add(new Pair(temp.right,temp.dist+1));
            
            if(h.get(temp) != null && !vis.containsKey(h.get(temp).node))
                q.add(new Pair(h.get(temp),temp.dist+1));
        }
    }
    
