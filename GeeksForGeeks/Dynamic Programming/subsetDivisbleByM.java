class Solution
{
    public int DivisibleByM(int [] nums, int m)
    {
        // Code here
        int dp[][] = new int[nums.length + 1][m + 1];
        
        for (int a[] : dp)
            Arrays.fill(a, -1);
        
        return Divisible(nums, m, nums.length, m, dp);
    }
    public int Divisible(int [] nums, int m, int i, int M, int dp[][])
    {
        // Code here
        
        if (m != 0 && i <= 0)
            return 0;
    
        if (m == 0)
            return 1;
        
        if (dp[i][m] != -1)
            return dp[i][m];
            
        int option1 = Divisible(nums, (nums[i - 1] + m) % M, i - 1, M, dp);
        int option2 = Divisible(nums, m, i - 1, M, dp);
        
        return dp[i][m] = Math.max(option1, option2);
    }
}
