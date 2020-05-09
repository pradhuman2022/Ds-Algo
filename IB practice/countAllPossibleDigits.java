public class Solution {
    int target;
    int dp[][];
    int mod = (int)Math.pow(10, 9) + 7;
    public int solve(int A, int B) {
        this.target = B;
        int ans = 0 ;
        dp = new int[B + 1][A + 1];
        for(int a[] : dp) 
            Arrays.fill(a, Integer.MIN_VALUE);
        for(int i = 1; i <= 9; i++) {
            ans = (ans + findAllPossibleNums(i, A - 1)) % mod;
        }
        return ans;
    }
    
    public int findAllPossibleNums(int sum, int n){
        if(sum == target && n == 0)
            return 1; 
        if(n < 0 || sum > target)
            return 0;
        if(dp[sum][n] != Integer.MIN_VALUE)
            return dp[sum][n];
        int ans = 0;  
        for(int i = 0; i <= 9; i++) {
            ans = (ans + findAllPossibleNums(sum + i,n - 1)) % mod;
        }
        return dp[sum][n] = ans; 
    }
    
    
}
