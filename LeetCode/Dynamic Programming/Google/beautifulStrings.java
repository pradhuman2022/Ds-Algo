class Solution {
    public int countArrangement(int n) {
        int dp[][] = new int[16][65534];
        
        for (int d[]: dp)
            Arrays.fill(d, -1);
        
        return count(n, 1, 0, dp);
    }
    
    public int count(int n , int value, int mask, int dp[][]) {
        
        if (value == n + 1)
            return 1;
        
        if (dp[value][mask] != -1)
            return dp[value][mask];
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if ((mask & (1 << i)) == 0 && (value % i == 0 || i % value == 0))
                ans += count(n, value + 1, mask | (1 << i), dp);
        }
        return dp[value][mask] = ans;
    }
}
