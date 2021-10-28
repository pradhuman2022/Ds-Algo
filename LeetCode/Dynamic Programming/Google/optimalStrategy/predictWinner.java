class Solution {
    
    /**
    Basically, opponent will play optimally right, so
    just imagine if we(playe1) have range i ... j then we can choose i or j,
    
    f(i, j) -> represents maximum score we can achive from i to j with our turn....
    //------------------------------------
    lets choose i then, 
    opponent will have choice i + 1 .... j , hence
    if opponent i + 1 then we will have choice i + 2 ... j  or if opponent choose j then we will have i + 1 ..... j - 1 choice ....
    So opponent will move in such a way that we will get minimum choose, 
    
    maximum score if we choose i then -> min(f(i + 2, j), f(i + 1, j - 1))
    we are doing minimum because opponent may i + 1 or j between i + 1 to j range, so that we should get minimum score.
    
    //-------------------------------------
    
     lets choose j then, 
     opponent will have choice i .... j - 1 , hence
     if opponent choose i then we will have choice (i + 1 ... j - 1)  or if opponent        choose j - 1 then we will have (i ..... j - 2) choice ....
     So opponent will move in such a way that we will get minimum choose, 
    
    maximum score if we choose j then -> min(f(i, j - 2), f(i + 1, j - 1))
    we are doing minimum because opponent may i or j - 1 between i to j - 1 range, so       that we should get minimum score.
    
    Bonus Note: In optimal strategy game, don't think about turns, just find out maxmium possible score and rest will be score for player2.
    
    since both will play optimally, just rememeber opponent is smart enough to force you to choose minimum values. So always use minimum score 
    which you will after move of opponent and add it to currentScore.
    **/
    
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
