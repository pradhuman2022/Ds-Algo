class Solution {
    public int longestPalindromeSubseq(String s) {
        int lenOfString = s.length();
        int dp[][] = new int[lenOfString][lenOfString] ; 
        for(int a[] : dp)
                Arrays.fill(a, Integer.MIN_VALUE);
        return lps(dp, 0, lenOfString - 1, s); 
    }
    
    static int lps(int dp[][], int start, int end, String str){
        
        if(start == end)
            return 1 ;
        if(end == start + 1 && str.charAt(start) == str.charAt(end))
            return 2; 
        if(dp[start][end] != Integer.MIN_VALUE)
            return dp[start][end];
        
        if(str.charAt(start) == str.charAt(end))
            return dp[start][end] = 2 + lps(dp, start + 1, end - 1, str);
        
        return dp[start][end] = Math.max(lps(dp, start + 1, end, str), lps(dp, start, end - 1, str));
    }
}
