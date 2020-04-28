/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		System.out.println(countAllNDigit(3, 6)) ;
	}
	static int countAllNDigit(int n, int Sum) {
	    int dp[][] = new int[n + 1][Sum + 1]; 
	    dp[0][0] = 1; 
	    
	    for(int i = 1; i <= n; i++) {
	        for(int j = 1; j <= Sum; j++) {
	            int k = 0; 
	            if(i == 1) 
	                k = 1;
	            for(;k <= 9 ; k++) 
	                if(j - k >= 0)
	                    dp[i][j] += dp[i - 1][j - k];
	        }
	    }
	   return dp[n][Sum]; 
	}
}
