class Solution {
    String s;
    String p;
    int dp[][];
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        dp = new int[s.length() + 1][p.length() + 1];
        for(int a[]: dp)
            Arrays.fill(a, -1);
        
        return isMatchDP(0, 0) == 0 ? false : true;
    }
    
    
    public int isMatchDP(int sl, int pl) {
        
        // if pl is ended and sl not then false
        // if sl is at the end and pl not just move if pl is * 
        // if both are on end and satisfy condition return true
        if(sl == s.length() && pl == p.length())
            return 1;
        
        if(pl == p.length() && s.length() > sl)
            return 0;
        
        if(dp[sl][pl] != -1)
            return dp[sl][pl];
        
        if(pl < p.length() && sl == s.length()) {
            if(p.charAt(pl) == '*') 
                return dp[sl][pl] = isMatchDP(sl, pl + 1);
            else 
                return 0;   
        }   

        if(s.charAt(sl) == p.charAt(pl) || p.charAt(pl) == '?') 
            return dp[sl][pl] = isMatchDP(sl + 1, pl + 1);
        
        if(p.charAt(pl) == '*')
            return dp[sl][pl] = isMatchDP(sl + 1, pl) | isMatchDP(sl, pl + 1);
        
        return 0;
    }
}
