public class Solution {
    int coins[];
    int dp[][];
    public int maxcoin(int[] a) {
        coins = a;
        int n = a.length;
        dp = new int[a.length+1][a.length+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return maxcoin(0,a.length-1);
    }    
     
    public int maxcoin(int i,int j){ 
        
        if((i < 0 || i >= coins.length)||(j < 0 || j >= coins.length))
            return 0;
        if(dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        if(Math.abs(i-j) == 1)
            return Math.max(coins[i],coins[j]);
        /*
        We have two options when we select a coin i.e. if opponent player choose ith index coin then opponent will chosse value
        at (i+1)st index or choose jth index coin such that when player again chooses from options available i.e. (i+2)th index
        or j-1 index respectively he chooses the one which gives minimum score as opponent and player are equally smart. 
        */
        int option1 = coins[i] + Math.min(maxcoin(i+2,j),maxcoin(i+1,j-1));
        int option2 = coins[j] + Math.min(maxcoin(i+1,j-1),maxcoin(i,j-2));
        return dp[i][j] = Math.max(option1,option2);
        
    }
}
