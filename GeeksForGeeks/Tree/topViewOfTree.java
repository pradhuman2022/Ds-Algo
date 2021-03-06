class View
{
    // function should print the topView of the binary tree
    static void topView(Node root)
    {
        // add your code
        Queue<Pair> q = new LinkedList<Pair>();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        q.offer(new Pair(0, root));
        
        while(!q.isEmpty()) {
            Pair front = q.poll();
            int dist = front.dist; 
            if(map.getOrDefault(dist, -1) == -1)
                map.put(dist, front.root.data);
            if(front.root.left != null) 
                q.offer(new Pair(dist - 1, front.root.left));
            if(front.root.right != null) 
                q.offer(new Pair(dist + 1, front.root.right));
            }
            
            for (Map.Entry<Integer, Integer> m : map.entrySet()) 
                    System.out.print(m.getValue()+" ");
            
        }
    static class Pair{
        int dist;
        Node root;
        Pair(int dist, Node root) {
            this.dist = dist; 
            this.root = root;
        }
    }
}
