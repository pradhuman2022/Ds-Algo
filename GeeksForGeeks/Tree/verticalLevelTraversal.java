class BinaryTree
{
    static void verticalOrder(Node root)
    {
        // add your code here
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0, root));
        
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
        while(!q.isEmpty()) {
            Pair front = q.poll();
            int dist = front.dist;
            ArrayList <Integer> list = map.getOrDefault(dist, new ArrayList<Integer>());
            list.add(front.root.data);
            map.put(dist, list);
            if(front.root.left != null) 
                q.offer(new Pair(dist - 1, front.root.left));
            
            if(front.root.right != null) 
                q.offer(new Pair(dist + 1, front.root.right));
        }
        
        for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()) {
            for (Integer nodeValue : m.getValue())
                System.out.print(nodeValue+" ");
        }
       
        
    }
    static class Pair{
        int dist;
        Node root;
        Pair(int d, Node root) {
            this.dist = d;
            this.root = root;
        }
    }
}
