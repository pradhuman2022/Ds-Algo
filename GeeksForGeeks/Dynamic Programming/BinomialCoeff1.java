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
	    binomialCoff(dp) ; 
	    
		while(T-- >0)
		{
		    int n = sc.nextInt() ; 
		    int k = sc.nextInt() ;
		    
		    if(k > n) 
		     System.out.println(0) ; 
		     else
		     System.out.println(dp[n][k]) ;  
	}}
	
	static void binomialCoff(long dp[][]){
	  int n = 1001 ; 
      int k = 800  ;
      
      for(int i = 0 ; i < n ; i++)
       {
           for(int j = 0 ; j <= Math.min(i, k) ; j++)
            {
                if(i == j || j == 0)
                  {
                       dp[i][j] = 1 ;
                       continue ;
                  }
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod ; 
            }
       }
	  
	}
}
