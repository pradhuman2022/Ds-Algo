class Solution {
    public int longestPalindromeSubseq(String s) {
        int lenOfString = s.length();
        int dp[][] = new int[lenOfString][lenOfString] ;
        return lps(dp,lenOfString, s); 
    }
    
    
    
    static int lps(int dp[][], int lenOfString , String str){
        int n = lenOfString; 
        for(int i = 0; i < n; i++) 
            dp[i][i] = 1 ; 
        
        for (int lenOfPalindrome = 2; lenOfPalindrome <= n ; lenOfPalindrome++) {
            for(int i = 0; i < n - lenOfPalindrome + 1; i++) {
                int j = i + lenOfPalindrome - 1; 
                if(lenOfPalindrome == 2 && str.charAt(i) == str.charAt(j))
                    dp[i][j] = 2 ; 
                else if(str.charAt(i) == str.charAt(j))
                    dp[i][j] = 2 + dp[i + 1][j - 1] ; 
                else 
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][n - 1]; 
    }
}
/*
 Dp[i][j] will represnt longest palindrome subsequence from i to j and of j - i + 1 length String.
 we will cover all possible palindromes length. Minimum length will be 1 and so start from 2 to lenOfString.
*/
