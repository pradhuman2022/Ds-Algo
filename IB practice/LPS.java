class Solution {
    public int longestPalindromeSubseq(String s) {
        
    int dp[][] = new int[s.length() + 1][s.length() + 1] ;
		for(int k = 0 ; k < dp.length ; k++)
		{
			dp[k][k] = 1 ;
		}
        if(s.length() == 1)
             return 1 ;
		return lps(s, dp); 
	}
	
	//Iterative
	static int lps(String str, int dp[][])
	{
        int max = Integer.MIN_VALUE ;
		int n = str.length() ;
		for(int i = 2 ; i <= n; i++)
		{
			for(int k = 0 ; k <= n - i ; k++)
			{
				int j = i + k - 1 ;
				
				 if(str.charAt(k) == str.charAt(j) && i == 2)
				 {
					 dp[k][j] = 2 ;
				     max = Math.max(dp[k][j], max) ;
                     continue ;
				 }
				 if(str.charAt(k) == str.charAt(j))
					  dp[k][j] = 2 + dp[k + 1][j - 1] ;
				 else
					 dp[k][j] = Math.max(dp[k][j - 1], dp[k + 1][j]); 
			    max = Math.max(dp[k][j], max) ; 
            }
		}
        return max ;
	}
 
  StringBuilder printLps(int dp[][], String str)
 {
    int llps = lps(str, dp) ; 
    int i = 0 ; 
    int j = str.length() - 1 ; 
    StringBuilder ans =  new StringBuilder("") ;
      
     while(llps >= 0 && i <= j)
    {
         if(str.charAt(i) == str.charAt(j))
         {
             ans.append(str.charAt(i)) ; 
             i++ ;
             j-- ;
             llps-- ;
         }else
         {
             if(dp[i + 1][j] > dp[i][j - 1])
             {
                 i++ ;
             }else
             {
                 j-- ;
             }
         }
    }
      return ans ;
 } 

}
