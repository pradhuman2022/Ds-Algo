class Solution {
    public int integerBreak(int n) {
        
        int dp[] = new int[n + 1] ; 
       /* dp[2] = 1 ;
        for(int i = 3 ; i <= n ;i++)
        {
            int max = Integer.MIN_VALUE;
            
            for(int j = i - 1; j >= 2 ; j--){
                max = Math.max(max, Math.max(j * dp[i - j], j * (i - j)));
            }
            dp[i] = max ;
        }
        
        return dp[n];
        */
        for(int i = 0 ; i <= n ; i++)
            dp[i] = -1 ; 
       dp[2] = 1 ;
       dp[0] = dp[1] = 0;
       integerBreak(n, dp) ; 
        for(int x : dp)
            System.out.println(x);
        return dp[n];
    }
    public int integerBreak(int n, int dp[]){
        if(n == 0 || n == 1)
          return 0;
        if(n == 2)
          return 1 ; 
        if(dp[n] != -1)
          return dp[n] ; 
        
        int max = Integer.MIN_VALUE ; 
        
        for(int i = 1 ; i < n ; i++)
         max = Math.max(max, Math.max(i * integerBreak(n - i, dp), (n - i) * i)) ; 
        
        return dp[n] = max ;
    }
}
