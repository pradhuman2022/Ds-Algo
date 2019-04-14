import java.lang.* ;
class Solution {
    
    public int superEggDrop(int e, int f) { // O(n * k *k)
     
    
        
        
        
      /* int dp[][] = new int[e  + 1][f + 1] ; //f[1][n] = n // f[e][1] = 1 ;
        for(int i = 1 ; i <= f ; i++)
            dp[1][i] = i ;
        for(int i = 1 ; i <= e ; i++)
            dp[i][1] = 1 ;
      
        for(int i = 2 ; i <= e ; i++)
        {
            for(int j = 2 ; j <= f ; j++)
            {
                dp[i][j] = Integer.MAX_VALUE ;
                for(int x = 1 ;x <= j ; x++)
                {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]));
                }
            }
        }
      return dp[e][f];
        */
        
    }
    /*
     public int superEggDrop(int K, int N, int dp[][]) {
        if(K==1) return N;
    if(N==0) return 0;
    if(N==1) return 1;
    if(dp[K][N] != 0)
        return dp[K][N] ;
    int minimum=Integer.MAX_VALUE;

    //Recursion to find egg(n,k). The loop iterates i: 1,2,3,...h
    for(int x=1;x<=N;x++) 
        minimum=Math.min(minimum,(1+ Math.max(superEggDrop(K,N-x),superEggDrop(K-1,x-1))));

    return dp[K][N] = minimum;
      /  
    }*/
}
