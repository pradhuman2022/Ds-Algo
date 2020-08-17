class Solution {
    int parent[];
    
    public int find(int x) {
        if(parent[x] != x) 
            parent[x] = find(parent[x]);  
        return parent[x];
    }
    
    public void union(int par, int child) {
        int xset = find(par);
        int yset = find(child);
        parent[yset] = xset;
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        return getVertexHavingMultipleParents(edges);
    }
    /***
    * Muje ye smj aagya tha ki teen condition hogi
    * 1.sirf two edges
    * 2.sirf cycle
    *3.Ya dono to is case mai ye hai ki dono hai to ye bat confirm hai ki agar phle multiple
    * parent nikala ho fir cycle bhi toh iska mtlb hai ki hm union to krege ni mulitpleParent ka
    * to hmara jo first edge hoga wo removal edge hoga. same vice versa.
    */
    public int [] getVertexHavingMultipleParents(int edges[][]) {
        int N = edges.length;
        int ans[] = null;
        int cycle[] = null; 
        for (int i = 0; i < edges.length; i++) {
            int parentOfSrc = find(edges[i][0]);
            int parentOfDest = find(edges[i][1]);
        if(edges[i][1] != parentOfDest && parentOfDest != parentOfSrc)
                ans = edges[i];
            else if(parentOfDest == parentOfSrc)  
                cycle = edges[i];
            else
                union(parentOfSrc, parentOfDest);
        }
        if(ans == null)
            return cycle;
        
        if(cycle == null)
            return ans;
        
        int multipleParent[] = new int[2];
       for (int i = 0; i < N; i++) {
            if (edges[i][1] == ans[1])
                return edges[i];
        }
        cycle = null;
        ans = null;
        parent = null;
        return multipleParent;
    }

}
