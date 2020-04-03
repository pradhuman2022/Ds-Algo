/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ;
		int T = sc.nextInt() ;
		
		while(T-->0){
		    int m = sc.nextInt() ; 
		    int n = sc.nextInt() ; 
		    System.out.println(findSubsequence(m , n)) ; 
		}
	}
	static int findSubsequence(int m, int n){
	    int dp[][] = new int[n + 1][m + 1] ;     
	    for (int i = 0; i <= n; i++) {
	        for (int j = 0; j <= m; j++) {
	            if(i == 0 || j == 0 || j < i)
	                dp[i][j] = 0;
	            else if(i == 1)
	                dp[i][j] = j; 
	            else 
	                dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1] ; 
	        }
	    }
	    return dp[n][m];
	}
}
