class Solution {
    int mod = (int)Math.pow(10, 9) + 7;
    public int knightDialer(int n) {
        int graph[][] = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        
        int dp[][] = new int[n + 1][10];
        
        for (int d[]: dp)
            Arrays.fill(d, -1);
     
        int ans = 0;
        for (int i = 0; i <= 9; i++)
            ans = (ans + dp(n - 1 , i, dp, graph)) % mod;
        
        return ans;
    }
    
    public int dp(int n, int source, int dp[][], int graph[][]) {
        
        if (n == 0)
            return 1;
        
        if (dp[n][source] != -1)
            return dp[n][source];
        
        int distintWays = 0;
        for (int neighbour: graph[source]) { // 10 * n
            distintWays = (distintWays + dp(n - 1, neighbour, dp, graph)) % mod;
        }
        
        dp[n][source] = distintWays;
        
        return dp[n][source];
    }
}
