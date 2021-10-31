class Solution {
    int nums[];
    int dp[][];
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        
        this.nums = new int[n];
        System.arraycopy(nums, 0, this.nums, 1, n - 2);
        this.nums[0] = 1;
        this.nums[n - 1] = 1;
        dp = new int[n][n];
        
        return f(1, n - 2);
    }
    
    int f(int i, int j) {
        
        if (j - i < 0)
            return 0;
        
        if (dp[i][j] > 0)
            return dp[i][j];
        
        int ans = 0;
        for (int x = i; x <= j; x++) {
            int gain = nums[i - 1] * nums[x] * nums[j + 1];
            int burst = f (i , x - 1) +  f(x + 1, j);
            ans = Math.max(gain + burst, ans);
        }
        
        return dp[i][j] = ans;
    }
}
