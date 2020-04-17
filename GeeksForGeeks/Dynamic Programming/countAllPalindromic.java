class GfG
{
    int dp[][] ;
    String str;
    int countPS(String str)
    {
        // Your code here
        if(str == null)
            return 0;
        int n = str.length();
        dp = new int[n][n];
        for(int a[] : dp)
            Arrays.fill(a, -1);
        this.str = str;
        return countPossiblePalindrome(0, n - 1);
    }
    
    int countPossiblePalindrome(int start, int end){
    
        if(start == end)
            return 1; 
        if(start > end)
            return 0;
        if(dp[start][end] != -1)
            return dp[start][end] ; 
        if(str.charAt(start) == str.charAt(end))
            return dp[start][end] = 1 + countPossiblePalindrome(start + 1, end) + countPossiblePalindrome(start, end - 1) ; 
        else
            return dp[start][end] = countPossiblePalindrome(start + 1, end) + countPossiblePalindrome(start, end - 1) - countPossiblePalindrome(start + 1, end - 1);
    }
}
