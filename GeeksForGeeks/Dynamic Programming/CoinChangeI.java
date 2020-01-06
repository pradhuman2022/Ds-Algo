/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		while(T-->0)
		 {
		     int coins = sc.nextInt() ;
		     int coin[] = new int[coins + 1] ;
		     int dp[][]  ; 
		     for(int i= 1 ; i < coin.length ; i++)
		       coin[i] = sc.nextInt() ; 
		  
		     int n = sc.nextInt() ; 
		     dp = new int[n + 1][coins + 1] ; 
		     for(int a[] : dp)
		     Arrays.fill(a, -1) ;
		     int ans = countWays(n , coins, coin, dp) ; 
		     System.out.println(ans) ;
		 }
	}
	

	 static int countWays(int n, int coins, int coin[], int dp[][]){
	     
	     if(n == 0)
	       return 1 ; 
	    
	     if(n < 0 || coins < 1)
	       return 0  ;
	      
	      if(dp[n][coins] != -1)
	        return dp[n][coins] ; 
	        
	     return dp[n][coins] = countWays(n, coins - 1, coin, dp) + countWays(n - coin[coins], coins, coin, dp) ; 
	 }
}
