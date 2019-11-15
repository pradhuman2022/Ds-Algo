class Solution {
    public int dieSimulator(int n, int[] rollMax) {
     
        int mod = (int)Math.pow(10, 9) + 7 ;
        
        long dp[][] = new long[n + 1][7] ;
        
        for(int i = 0 ; i < 6 ; i++){
            dp[1][i] = 1 ; 
        }
        dp[1][6] = 6 ;
        
        for(int i = 2 ; i <= n ; i++){
            
            long tSum = 0 ;
            
            for(int j = 0 ; j < 6 ; j++){
                
                dp[i][j] = dp[i - 1][6] ; 
                
                if(i - rollMax[j] == 1)
                   dp[i][j]-- ;
                
                if(i - rollMax[j] >= 2){
                  dp[i][j] = dp[i - 1][6] - (dp[i - rollMax[j] - 1][6] - dp[i - rollMax[j] - 1][j])  ; 
                 }
                
                dp[i][j] = dp[i][j] % mod + mod;
                tSum = (tSum + dp[i][j]) % mod ;
            }
            dp[i][6] = tSum ; 
        }
        return (int)dp[n][6] ;
    }
}
