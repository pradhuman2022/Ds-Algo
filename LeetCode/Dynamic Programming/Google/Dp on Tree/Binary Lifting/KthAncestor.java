class TreeAncestor {

    int up[][];
    Map<Integer, List<Integer>> map;
    
    public TreeAncestor(int n, int[] parent) {
        up = new int[n + 1][17];    
        map = new HashMap<>();
        
        for (int i = 0; i < parent.length; i++) {
            List<Integer> child = map.getOrDefault(parent[i], new ArrayList<>());
            child.add(i);
            map.put(parent[i], child);
        }
        
        binaryLifting(0, -1);
    }
    
    public void binaryLifting(int source, int parent) {
        
        up[source][0] = parent;
        for (int i = 1; i <= 16; i++) {
            if (up[source][i - 1] != -1) {
                up[source][i] = up[up[source][i - 1]][i - 1];
            } else {
                up[source][i] = -1;
            }
        }
        
        for (int child: map.getOrDefault(source, new ArrayList<>()))
            if (child != parent)
                binaryLifting(child, source);
    }
    
    public int getKthAncestor(int node, int k) {
        
        if (node == -1 || k == 0)
            return node;
            
        for (int i = 16; i >= 0; i--) {
            if (k >= (1 << i)) {
                return getKthAncestor(up[node][i], k - (1 << i));
            }
        } 
        
        return -1;
    }
}
