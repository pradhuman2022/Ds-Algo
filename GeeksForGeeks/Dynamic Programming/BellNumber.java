/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		long bellNum[] = new long[10001] ;
		long dp[][] = new long[10001][10001] ; 
		
		for(int i = 0 ; i < dp.length; i++)
		 for(int j = 0 ; j < dp.length ; j++)
		   dp[i][j] = -1 ; 
		
		
		for(int i = 1 ; i <= 10001 ; i++)
		  {
		      for(int j = 1 ; j <= i ; j++)
		      bellNum[i] += S(i, j, dp) ; 
		  }
		
		int T = sc.nextInt() ; 
		while(T-->0){
		    int n = sc.nextInt() ; 
		    System.out.println(bellNum[n]) ; 
		}
	}
	static long S(int n , int k, long dp[][]){
	    
	    if(k == 0 || n == 0 || k > n)
	      return 0 ; 
	    if(k == 1 || n == k)
	      return 1 ; 
	    
	    if(dp[n][k] != -1)
	     return dp[n][k] ; 
	     
	    return dp[n][k] = k * S(n - 1, k, dp) + S(n - 1, k - 1, dp)  ;
	    // S(n - 1, k) * k , it means we have partitions of k Sets so we can add our nth number to any set wo multuply for k choices.
	    // S(n - 1, k - 1) , it means we just make our nth element as kth set, is like just put nth number isolate from other sets.
	}
}
