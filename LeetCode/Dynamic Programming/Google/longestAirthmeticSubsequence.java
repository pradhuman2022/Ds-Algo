class Solution {
    int nums[];
     int dp[][];
     boolean visited[][];
      public int longestArithSeqLength(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length][1001];
      
        visited = new boolean[nums.length][1001];
          
        for (int d[]: dp)
            Arrays.fill(d, 1);
              
        f(nums.length - 1, 0);
        return ans;
    }

    int ans = 1;
    public int f(int n, int diff) {
      
        if(n < 0)
            return 0;
        
        if (visited[n][diff])
            return dp[n][diff];
        
        visited[n][diff] = true;
        for (int i = 0 ; i < n; i++) {
            int diff1 = (nums[n] - nums[i]) + 500;
            dp[n][diff1] = Math.max(dp[n][diff1], 1 + f(i, diff1));
            ans = Math.max(ans, dp[n][diff1]);
        }
        
        return dp[n][diff];
    }
}
