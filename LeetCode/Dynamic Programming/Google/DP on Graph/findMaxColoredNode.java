class Solution {
    Map<Integer, List<Integer>> graph;
    int dp[][];
    int visited[];
    boolean isCyclic;
    String colors;
    public int largestPathValue(String colors, int[][] edges) {
        
        visited = new int[colors.length()];
        Arrays.fill(visited, -1);
        this.isCyclic = false;
        this.colors = colors;
        graph = new HashMap<>();
        
        for (int i = 0; i < colors.length(); i++)
            graph.put(i, new ArrayList<>());
        
        dp = new int[colors.length()][26];
        
        for (int d[]: dp)
            Arrays.fill(d, -1);
        
        for (int e[]: edges) {
            List<Integer> adjNodes = graph.getOrDefault(e[0], new ArrayList<>());
            adjNodes.add(e[1]);
            graph.put(e[0], adjNodes);
        }
        
        int ans = 0;
        
        for (int i = 0; i < colors.length(); i++) {
            for (int j = 0; j < 26; j++)  {
                if(dp[i][j] != -1)
                   ans = Math.max(ans, dp[i][j]);
                else
                    ans = Math.max(ans, dfs(i, j));
                
                if (isCyclic)
                    return -1;
            }
            
        }
        
        return ans;
    }
    
    public int dfs(int node, int color) {
        
        if(visited[node] == 0) {
            isCyclic = true;
            return 0;
        }
        
        if (dp[node][color] != -1)
            return dp[node][color]; 
        
        visited[node] = 0;
        int ans = 0;
        for (int child: graph.get(node)){
            ans = Math.max(ans, dfs(child, color));
        }
        ans += colors.charAt(node) - 'a' == color ? 1 : 0;
        
        visited[node] = 1;
        return dp[node][color] = ans;
    }
}
