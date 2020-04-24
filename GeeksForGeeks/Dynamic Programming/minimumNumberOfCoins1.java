import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int coins[];
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in); 
	    int testCase = sc.nextInt();
	    while(testCase-->0) {
	        int totalSum = sc.nextInt();
	        int totalCoins = sc.nextInt();
	        coins = new int[totalCoins]; 
	        for(int i = 0; i < totalCoins; i++)
	            coins[i] = sc.nextInt(); 
	        System.out.println(minimumCoins(totalSum, totalCoins));
	    }
	 }
	 static long minimumCoins(int Sum, int coin) {
	    long dp[][] = new long[coin + 1][Sum + 1];
	    for(int i = 1; i <= Sum; i++) 
	        dp[0][i] = Integer.MAX_VALUE;
	   
	    for(int j = 1; j <= Sum; j++) {
	        for(int i = 1 ; i <= coin; i++) {
	            if(j >= coins[i - 1])
	                dp[i][j] =  Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
	            else
	                dp[i][j] = dp[i - 1][j];
	       }
	    }
	    return dp[coin][Sum] == Integer.MAX_VALUE ? -1 : dp[coin][Sum];
	 }
}
