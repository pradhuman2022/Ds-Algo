/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int mod = (int)Math.pow(10, 9) + 7 ; 
	
	public static void main (String[] args) {
		//code
		long dp[] = new long[101] ; 
	    for(int i = 0 ; i <= 100 ; i++)
	     dp[i] = -1 ; 
		//iterative bottom-up
		//for(int i = 2 ; i <= 100 ; i++) 
		 //dp[i] = (dp[i - 1] + ((i - 1) * dp[i - 2] ) % mod) % mod ; 
		 
		 waysOfPairedUp(dp, 100) ; 
		 Scanner sc = new Scanner(System.in) ;
		 int T = sc.nextInt() ; 
		 while(T-- >0){
		     int n = sc.nextInt() ; 
		     System.out.println(dp[n]) ;
		 }
	}
	//recursive approach
	static long waysOfPairedUp(long dp[], int i){
	    
	    if(i < 2) 
	       return dp[i] = 1 ; 
	    
	    if(dp[i] != -1)
	     return dp[i] ; 
	     
	    if(i >= 2)
	      dp[i] = (waysOfPairedUp(dp, i - 1) + (waysOfPairedUp(dp ,i - 2) * (i - 1) % mod)) % mod ; 
	    return dp[i] ; 
	}
}
