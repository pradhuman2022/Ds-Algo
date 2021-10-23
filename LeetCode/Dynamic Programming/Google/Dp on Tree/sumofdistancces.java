class Solution {
    
    int count[];
    int sumOfSubtree[];
    List<Set<Integer>> graph;
    int N;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.N = n;
        
        graph = new ArrayList<>();
        count = new int[N];
        sumOfSubtree = new int[N];
        
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++)
            graph.add(new HashSet<>());
        
        for (int e[]: edges)  {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        dfs1(0, -1);
        dfs2(0, -1);
        return sumOfSubtree;
    }
    
    public void dfs1(int node, int parent) { // 1(node) - 2(node) if we explore 1 then p = 1 and child 2 if we visit 2 then check its child and we will call p = 2 child = 2 (of 1)
        
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs1(child, node);
                sumOfSubtree[node] += sumOfSubtree[child] + count[child];
                count[node] += count[child];
            }
        }  
    }
    
    public void dfs2(int node, int parent) {
        
        for (int child: graph.get(node)) {
            if (child != parent) {
                sumOfSubtree[child] = sumOfSubtree[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
        }
    }
}
