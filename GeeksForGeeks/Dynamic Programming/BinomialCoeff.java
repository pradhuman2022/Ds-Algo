/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int mod = (int)Math.pow(10, 9) + 7 ; 
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
	    long dp[][] = new long[1001][801] ; 
	    for(int i = 0 ; i < dp.length ; i++)
	     for(int j = 0 ; j < 801 ; j++)
	       dp[i][j] = -1 ;
	    for(int i = 0 ; i < dp.length ; i++)
	      for(int j = 0 ; j < 801 ; j++)
	        binomialCoff(i, j , dp) ; 
	    
		while(T-- >0)
		{
		    int n = sc.nextInt() ; 
		    int k = sc.nextInt() ;
		    
		    if(k > n) 
		     System.out.println(0) ; 
		     else
		     System.out.println(dp[n][k]) ;  
	}}
	//
	static long binomialCoff(int n , int k, long dp[][]){
	    if(k > n)
	     return 0 ; 
	       
	    if(n == k || k == 0)
	      return 1 ; 
	   
	   if(dp[n][k] != -1)
	     return dp[n][k] ; 
	    
	  return dp[n][k] = (binomialCoff(n - 1, k - 1, dp) + binomialCoff(n - 1, k ,dp)) % mod ;    
	}
}
