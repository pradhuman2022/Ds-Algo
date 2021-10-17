/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int mod = (int)Math.pow(10,9) + 7 ; 
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		while(T-->0){
		  int n = sc.nextInt() ; 
		  int k = sc.nextInt() ;
		  System.out.println(paintingTheFence(n, k));
		}
	}
	static long paintingTheFence(int n, int k){
	    
	    long dp[] = new long[n + 1] ; 
	    long diff = k;
	    dp[1] = k ; 
	    long same = 0;
	    for(int i = 2 ; i <= n; i++){
	        same = diff ; 
	        diff = (k - 1) * dp[i - 1] ; 
	        diff %= mod ;
	        dp[i] = same + diff ; 
	        dp[i] %= mod ; 
	    }
	    return dp[n] ; 
	}
}
// F(i) to paint i fences with different colors
// F`(i) to paint i and i - 1 with same colors
/***
  F(i) = F(i - 1) * (k - 1)
  F`(i) = F(i - 2) * (k - 1)
  ans = F(i) + F`(i)
**/
