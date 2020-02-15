/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static final int MOD = 1000000007; 
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0){
            int h = sc.nextInt() ;
            System.out.println(countBalancedTrees(h)) ;
		}
	}
	static long countBalancedTrees(int h){
	    long[] dp = new long[h + 1]; 
          
        // base cases 
        dp[0] = 1; 
        dp[1] = 1; 
          
        for(int i = 2; i <= h; ++i)  
            dp[i] = (dp[i - 1] * ((2 * dp [i - 2])% MOD + dp[i - 1]) % MOD) % MOD; 
              
            return dp[h]; 
	}
}
