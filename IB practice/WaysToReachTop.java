public class Solution {
    public int climbStairs(int A) {
        
        int dp[] = new int[A + 1] ;
        for(int i = 0 ; i < A + 1 ; i++)
         dp[i] = -1 ; 
        return waysToReachTop(A, dp) ;
    }
    
    public int waysToReachTop(int A, int dp[])
    {
          if(A == 0)
            return 1 ; 
           if(A < 0)
            return  0 ;
           if(dp[A] != -1)
             return dp[A]; 
          int ans = waysToReachTop(A - 1, dp) + waysToReachTop(A - 2, dp) ;
          return dp[A] = ans ;
    }
}
