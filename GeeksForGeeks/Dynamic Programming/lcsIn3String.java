/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt() ; 
		
		while(T-->0){
		    
		    int n = sc.nextInt() ; 
		    int m = sc.nextInt() ; 
		    int k = sc.nextInt() ; 
		    sc.nextLine() ;
		    String str1 = sc.nextLine();
		    String str2 = sc.nextLine();
		    String str3 = sc.nextLine(); 
		    System.out.println(longestThreeSubsequence(str1, str2, str3, n , m , k));
		}
	}
	
	
	static int longestThreeSubsequence(String str1, String str2, String str3, int n, int m, int k){
	    
	    int dp[][][] = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1] ; 
	    
	    for(int i = 0 ; i <= str1.length() ; i++)
	    {
	        for(int j = 0 ; j <= str2.length(); j++)
	         {
	             for(int l = 0 ; l <= str3.length() ; l++)
	             {
	                  if(i == 0 || j == 0 || l == 0)
	                    dp[i][j][l] = 0 ;
	                  else if(str1.charAt(i - 1) == str2.charAt(j - 1) && str1.charAt(i - 1) == str3.charAt(l - 1))
	                   dp[i][j][l] = 1 + dp[i - 1][j - 1][l - 1];
	                  else 
	                   dp[i][j][l] = Math.max(dp[i - 1][j][l], Math.max(dp[i][j - 1][l], dp[i][j][l - 1]));
	             }
	        }
	    }
	    return dp[str1.length()][str2.length()][str3.length()] ;
	}
	
}
