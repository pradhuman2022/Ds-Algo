class Solution {
    int dp[][];
    String s, p;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        
        dp = new int[s.length() + 1][p.length() + 1];
        for (int d[]: dp)
            Arrays.fill(d, -1);
        
        return isMatch(0, 0) == 0 ? false: true;
    }
    
   public int isMatch(int i , int j) {

        if (dp[i][j] != -1)
            return dp[i][j];
        
        int firstMatch = 0;
        
        if (j == p.length()) {
            return dp[i][j] = s.length() == i ? 1 : 0;
        }
        
        if (i < s.length())
            firstMatch = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')  ? 1 : 0;
        
        int ans = 0;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') { // check if pattern is a* 
            ans = isMatch(i, j + 2);
            if (firstMatch == 1) {
                ans |= isMatch(i + 1, j);
            }
        } else {
            if (firstMatch == 1)
                ans = isMatch(i + 1, j + 1);
        }
        
        return dp[i][j] = ans;
    } 
    
}
