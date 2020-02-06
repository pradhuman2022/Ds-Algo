/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
	   Scanner sc = new Scanner(System.in) ;
	   int T = sc.nextInt() ; 
	   
	   while(T-- >0){
	       int n = sc.nextInt();
	       System.out.println(maxSum(n));
	   }
	}
	static int maxSum(int n){
	
	int dp[] = new int[n + 1] ;
	dp[0] = 0 ; 
	dp[1] = 1 ; 
	
	for(int i = 2; i <= n ; i++)
	    dp[i] = Math.max(dp[i / 2] + dp[i / 3] + dp[i / 4], i) ; 

	return dp[n];
	}
}
