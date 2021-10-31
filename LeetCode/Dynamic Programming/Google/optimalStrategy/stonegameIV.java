class Solution {
    boolean dp[];
    boolean visited[];
    public boolean winnerSquareGame(int n) {
        dp = new boolean[n + 1];
        visited = new boolean[n + 1];
        
        return f(n);
    }
    
    boolean f(int n) {
        
        if(visited[n])
            return dp[n];
        
        visited[n] = true;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (!f(n - (i * i))) {
                return dp[n] = true;
            }  
        }
        
        return dp[n] = false;
    }
}
