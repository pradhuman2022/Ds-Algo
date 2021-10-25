class Solution {
    long dp[][];
    int nums[];
    
    public boolean PredictTheWinner(int[] nums) {
        dp = new long[nums.length][nums.length];
        this.nums = nums;
        
        int sum = 0;
        
        for (int s : nums)
            sum += s;
        
        for (long d[] : dp)
            Arrays.fill(d, Integer.MAX_VALUE);
        
        long ourScore = maxScore(0, nums.length - 1);
        long opponentScore = sum - ourScore;
        
        if (ourScore >= opponentScore)
            return true;
        
        return false;
    }
    
    public long maxScore(int i, int j) {
        
        if (i > j || i >= nums.length || j < 0)
            return Integer.MAX_VALUE;
        
        if (i == j)
            return nums[i];
        
        if (i + 1 == j)
            return Math.max(nums[i], nums[j]);
        
        
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        
        long common = maxScore(i + 1, j - 1);
        long option1 = nums[i] + Math.min(maxScore(i + 2, j), common);
        long option2 = nums[j] + Math.min(maxScore(i, j - 2), common);
        
        return dp[i][j] = (long)Math.max(option1, option2);
    }
}
