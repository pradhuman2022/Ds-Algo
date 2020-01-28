/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG { 
    static long dp[][] = new long[1001][1001] ; 
    static int mod = (int)Math.pow(10, 9) + 7 ;
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		for(int i = 0 ; i < 1001 ; i++)
		 for(int j = 0 ; j < 1001; j++)
		   dp[i][j] = -1  ;
		while(T-- >0)
		 {
		     int n = sc.nextInt() ; 
		     System.out.println(printHalfSubsequence(n, 0))  ;
		 }
	}
	
	static long printHalfSubsequence(int n, int diff){ 
	    
	    if(n < Math.abs(diff))
	      return 0 ; 
	    
	    if(n == 1 && diff == 0) 
	      return 2;
	    if(n == 1 && Math.abs(diff) == 1)
	      return 1 ;
	      
	    if(dp[n][n + diff] != -1)
	      return dp[n][n + diff]  ;
	    
      
      //if we set first and last bit of both half respectively then we will have 2 cases for remaining n - 1 bits...
	    long option1 = (2 * printHalfSubsequence(n - 1, diff)) % mod ; 
      
      //if we set first bit of left half then remaining n - 1 bit of left half will be 1lesss than n - 1 half of right...
	    long option2 = printHalfSubsequence(n - 1, diff - 1) % mod;
      
      
      //if we set first bit of left half then remaining n - 1 bit of left half will be 1more than n - 1 half of right...
	    long option3 = printHalfSubsequence(n - 1, diff + 1) % mod;
	    
	    return dp[n][n + diff] = (option1 + option2 + option3) % mod ; 
	}
}


/*
Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits.
*/

// it could be done in O(n) using ncr properties.
