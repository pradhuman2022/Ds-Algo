class Solution {
    
    long dp[][];
    int mod = (int)Math.pow(10, 9) + 7;
    public int rearrangeSticks(int n, int k) {
        dp = new long[n + 1][k + 1];
        
        for (long d[]: dp)
            Arrays.fill(d, -1);
        
        return (int)f(n, k);
    }
    
    public long f(int n, int k) {
        
        if (k == 0 || k > n)
            return 0;
        
        if (n <= 2)
            return 1;
        
        if (dp[n][k] != -1)
            return dp[n][k];
        
        long ans = 0;
        
        ans = f(n - 1, k - 1) % mod;
        
        ans = (ans + ((n - 1) * f(n - 1, k))) % mod;
        
        return dp[n][k] = ans;
    }
}
