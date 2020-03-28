class Solution
{
    static long numTrees(int n)
    {
        int mod = (int)Math.pow(10, 9) + 7;
        // Your code goes here
        long dp[] = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = (dp[i] + (dp[i - j] * dp[j - 1]) % mod) % mod;
            }
        }
        return dp[n];
    }
}
