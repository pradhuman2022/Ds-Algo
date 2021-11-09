class Solution {
    Map<Integer, List<Integer>> graph;
    int low[];
    int disc[];
    int parent[];
    boolean visited[];
    
    List<List<Integer>> res;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        graph = new HashMap<>(); 
        res = new ArrayList<>();
        low = new int[n];
        visited = new boolean[n];
        parent = new int[n];
        disc = new int[n];
        
        for (int i = 0; i < connections.size(); i++) {
            
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            
            List<Integer> uList = graph.getOrDefault(u, new ArrayList<>());
            uList.add(v);
            graph.put(u, uList);
            
            List<Integer> vList = graph.getOrDefault(v, new ArrayList<>());
            vList.add(u);
            graph.put(v, vList);
        }
        
        parent[0] = -1;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(i);
        }
        
        return res;
    }
    
    int time = 0;
    
    void dfs(int u) {
        low[u] = disc[u] = ++time;
        visited[u] = true;
        int count = 0;
        
        for (int v: graph.getOrDefault(u, new ArrayList<>())) {
            if (parent[u] == v) {
                continue;
            } else if (visited[v] == true) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                parent[v] = u;
                dfs(v);
    
                if (low[v] > disc[u]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(u);
                    bridge.add(v);
                    res.add(bridge);
                }
            
                low[u] = Math.min(low[u], low[v]);
            }
        }
    } 
}
