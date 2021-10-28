class Solution {
    int dp[][][];
    int prefix[];
    int K;
    boolean visited[][][];
    
    public int mergeStones(int[] stones, int k) {
        int N = stones.length;
        
        if ((N - 1) % (k - 1) != 0)
            return -1;
        
        dp = new int[N + 1][N + 1][k + 1];
        visited = new boolean[N + 1][N + 1][k + 1];
        prefix = new int[N + 1];
        K = k;
        
        for (int i = 1; i <= N; i++)
            prefix[i] = prefix[i - 1] + stones[i - 1];
        
        for (int d[][]: dp)
            for(int d1[]: d)
                Arrays.fill(d1, Integer.MAX_VALUE);
        
        
        return f(1, stones.length, 1);
    }
    
    int f(int i, int j, int k) {
        
        if (visited[i][j][k])
            return dp[i][j][k];
        
        if (i == j) {
            if (k == 1)
                return 0;
            else
                return Integer.MAX_VALUE;
        }
        
        visited[i][j][k] = true;
        if (k == 1) {
            int mergeK = f(i, j, K);
             
            if (mergeK != Integer.MAX_VALUE)
                return dp[i][j][k] = mergeK + (prefix[j] - prefix[i - 1]);
            else
                return Integer.MAX_VALUE;
            
        } else {
            for (int x = i; x < j; x++) {
                int leftPart = f(i, x, 1);
                int rightPart = f(x + 1, j, k - 1);
                
                if (leftPart != Integer.MAX_VALUE && rightPart != Integer.MAX_VALUE)
                    dp[i][j][k] = Math.min(dp[i][j][k], leftPart + rightPart);
            }
            return dp[i][j][k];
        }  
    }
}
