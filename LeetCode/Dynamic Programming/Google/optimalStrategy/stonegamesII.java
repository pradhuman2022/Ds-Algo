class Solution {
    int N;
    int prefix[];
    int dp[][];
    public int stoneGameII(int[] piles) {
        
        this.N = piles.length;
        prefix = new int[N + 1];
        dp = new int[N + 1][N * 2 + 1];
        
        for (int d[] : dp)
            Arrays.fill(d, Integer.MAX_VALUE);
        
        for (int i = 1; i <= N; i++)
            prefix[i] = prefix[i - 1] + piles[i - 1];
        
        return f(1, 1);
    }
    
    int f(int i, int m) {
        
        if (i > N)
            return Integer.MAX_VALUE;
                
        if (i + (2 * m) - 1 >= N) 
            return prefix[N] - prefix[i - 1];
        
        if (dp[i][m] != Integer.MAX_VALUE)
            return dp[i][m];

        int ans = Integer.MAX_VALUE;
        
        for (int x = 1; x <= 2 * m; x++) {
        
            int new_m = Math.max(x, m);
            
            int minScoreByOpponent = f(i + x, new_m);
   
          // to visulize, just imagine this eq if alice got last chance and how score will be propogate, incase if you forget the logic... best of luck
            ans = Math.min(ans, minScoreByOpponent); //minimum score achived by opponent from (i + x to N)
        }
        
        return dp[i][m] = prefix[N] - prefix[i - 1] - ans;
    }
}
