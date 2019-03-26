
public class Solution {

	
	public static int lcs(String s1, String s2){
		
	/* Your class should be named Solution
	 * Don't write main().
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	*/
      int m = s1.length()  ;
      int n = s2.length()  ;
      int dp[][] = new int[m + 1][n + 1] ; 
      for(int i = 0 ; i < dp.length ; i++)
     {
          for(int j = 0 ; j < dp[0].length; j++)
          {
              dp[i][j] = -1 ;
          }
     }
         return lcs1(s1,s2,0,0,dp) ;
	 }
    static int lcs1(String s1, String s2, int m ,int n , int dp[][])
    {
       if(m == s1.length() || n==s2.length())
           return 0 ; 
        if(dp[m][n] > -1)
            return dp[m][n] ;
        if(s1.charAt(m) == s2.charAt(n))
            return 1 + lcs1(s1,s2,m + 1, n + 1, dp) ;
        int ans1 = lcs1(s1,s2,m + 1, n,dp) ; 
        int ans2 = lcs1(s1,s2,m ,n + 1,dp) ;
        int ans = Math.max(ans1, ans2) ;
        return dp[m][n] = ans ;
    }

	
}
