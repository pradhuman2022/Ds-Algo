import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int coins[];
    static long dp[][] ; 
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
	        
	        dp = new long[totalSum + 1][totalCoins + 1]; 
	        for(long a[] : dp)
	            Arrays.fill(a, Integer.MAX_VALUE); 
	        
	        System.out.println(minimumCoins(totalSum, totalCoins));
	    }
	 }
	 static long minimumCoins(int Sum, int coin) {
	    if(coin == 0)
	        return Integer.MAX_VALUE; 
	    if(Sum == 0)
	        return 0;
	    if(dp[Sum][coin] != Integer.MAX_VALUE)
	        return dp[Sum][coin];
	    long ans = Integer.MAX_VALUE; 
	    if(Sum >= coins[coin - 1])
	        ans = 1 + minimumCoins(Sum - coins[coin - 1], coin); 
	    ans = Math.min(ans , minimumCoins(Sum, coin - 1)); 
	    return dp[Sum][coin] = ans;
	 }
}
