class GfG
{
    static int mod = (int)Math.pow(10, 9) + 7;
    int dp[][] ; 
    String s; 
    String t; 
    int  subsequenceCount(String S, String T)
    {
	// Your code here
	    this.s = S; 
	    this.t = T; 
	    dp = new int[s.length() + 1][t.length() + 1]; 
	    for (int a[] : dp) {
	        Arrays.fill(a, -1); 
	    }
	    return countWays(s.length(), t.length()); 
    }
    int countWays(int n, int m) {
        
        if(m == 0)
            return 1; 
        if(n == 0)
            return 0; 
        if(dp[n][m] != -1)
            return dp[n][m] ; 
            
        if(s.charAt(n - 1) == t.charAt(m - 1))
            return dp[n][m] = (countWays(n - 1, m - 1) + countWays(n - 1, m)) % mod; 
        else
            return dp[n][m] = countWays(n - 1, m) % mod; 
    }
}
