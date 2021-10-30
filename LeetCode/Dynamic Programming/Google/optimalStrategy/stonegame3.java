class Solution {
    int prefix[];
    int dp[];
    
    public String stoneGameIII(int[] stoneValue) {
        prefix = new int[stoneValue.length + 1];
        
        for (int i = 1; i <= stoneValue.length; i++)
            prefix[i] = prefix[i - 1] + stoneValue[i - 1];
        
        dp = new int[prefix.length + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        int aliceScore = f(1);
        
        return prefix[prefix.length - 1] - aliceScore > aliceScore ? "Bob" : prefix[prefix.length - 1] - aliceScore == aliceScore ? "Tie" : "Alice" ;
    }
    
    int f(int i) {
        
        if (i > prefix.length)
            return 0;
        
        if (i == prefix.length - 1)
            return prefix[prefix.length - 1] - prefix[i - 1];
        
        if (dp[i] != Integer.MAX_VALUE)
            return dp[i];
        
      //-----score of opponents ---
        int option1 = f(i + 1);
        int option2 = f(i + 2);
        int option3 = f(i + 3);
        
      
        return dp[i] = prefix[prefix.length - 1] - prefix[i - 1] - Math.min(option1, Math.min(option2, option3)); // calculation our score by minus total stones - opponent score.
    }
    
}
