/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		
		while(T-- >0){
		    int n = sc.nextInt();
		    int m = sc.nextInt() ; 
		    sc.nextLine(); 
		    String s1 = sc.nextLine() ; 
		    String s2 = sc.nextLine() ; 
		    System.out.println(longestSubsequence(s1, s2, n, m)) ; 
		}
	}
  //iterative way
     static int longestSubsequence(String s1, String s2, int n , int m){
         int dp[][] = new int[n + 1][m + 1] ; 
         
         for(int i = 0 ; i <= n ; i++){
             for(int j = 0; j <= m ; j++){
                 if(i == 0 || j == 0)//if we have nothing in any one of string then ans should be 0.
                   dp[i][j] = 0 ; 
                 else if(s1.charAt(i - 1) == s2.charAt(j - 1))// if both char is same then we need to add a char thats why +1 
                  dp[i][j] = dp[i - 1][j - 1] + 1 ;  //and get max longest subsequence till [i - 1, j - 1] and add it.
                 else
                  dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) ; //if both char is diff then we need to check if any of [i - 1, j] 
                                                                   //and [i, j - 1] having longest subsequence.
             }
         }
         return dp[n][m] ;
     }
	//space optimized
	static int longestSubsequence(String s1, String s2, int n , int m){
         int dp[][] = new int[2][m + 1] ; 
         int bi = 0 ; 
         
         for(int i = 0 ; i <= n ; i++){
             
             //just a way to toggle array.
             bi = i & 1 ; 
             
             
             for(int j = 0; j <= m ; j++){
                 if(i == 0 || j == 0)
                   dp[bi][j] = 0 ; 
                 else if(s1.charAt(i - 1) == s2.charAt(j - 1)) 
                   dp[bi][j] = dp[1 - bi][j - 1] + 1 ;
                 else
                  dp[bi][j] = Math.max(dp[1 - bi][j], dp[bi][j - 1]) ; 
             }
         }
         return dp[bi][m] ;
     }
}
