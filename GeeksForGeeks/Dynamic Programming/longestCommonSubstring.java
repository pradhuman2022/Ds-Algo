/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ;
		int T = sc.nextInt();
		
		while(T-->0){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    sc.nextLine();
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    System.out.println(longestCommonSubstring(s1, s2, n, m));
		}
	}
	
	static int longestCommonSubstring(String s1, String s2, int n, int m){
	    
	    int dp[][] = new int[n + 2][m + 2] ;
	    int max = Integer.MIN_VALUE; 
	    
	    for(int i = n ; i >= 1 ; i--){
	        for(int j = m; j >= 1; j--){
	            
	            if(s1.charAt(i - 1) == s2.charAt(j - 1))
	                dp[i][j] = 1 + dp[i + 1][j + 1] ;
	            else
	                dp[i][j] = 0;
	           max = Math.max(max, dp[i][j]);     
	        }
	    }
	    return max; 
	    
	}
}
