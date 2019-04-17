public class Solution {

	public static int smallestSuperSequence(String s1, String s2) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input. Input is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		 */
        int m = s2.length() ;
        int n = s1.length() ;
        int dp[][] = new int[m + 1][n + 1] ;
        
        for(int i = 0 ; i <= m; i++)
            dp[i][n] = m - i ;
        for(int i = 0 ; i <= n ; i++)
            dp[m][i] = n - i ; 
        
        for(int i = m - 1 ; i >= 0 ; i--)
        {
            for(int j = n - 1 ; j >= 0 ; j--)
            {
                if(s2.charAt(i) == s1.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1] ;
                else 
                    dp[i][j] = 1 + Math.min(dp[i + 1][j] , dp[i][j + 1]) ;
            }
        }
        return dp[0][0] ;
       // return getLen(str1, str2 ,n,m, dp) ;
	}
    static int getLen(String s1 , String s2 , int n , int m ,int dp[][])
    {
        if(n == 0  && m != 0)
            return m;
        if(n != 0 && m == 0)
            return n ;
        if(n <= 0 && m <= 0)
            return 0 ;
        if(dp[m][n] != 0)
            return dp[m][n];
        if(s1.charAt(n - 1) == s2.charAt(m - 1))
            return dp[m][n] = 1 + getLen(s1, s2 , n - 1, m - 1,dp) ;
        else
            return dp[m][n] = 1 + Math.min(getLen(s1, s2 , n - 1, m, dp), getLen(s1 ,s2 ,n ,m - 1, dp));
        
    }
}
