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
		    int n = sc.nextInt() ; 
		    int arr[][] = new int[2][n] ; 
		    
		    for (int i = 0; i < 2; i++)
		      for(int j = 0 ; j < n ; j++)
		      arr[i][j] = sc.nextInt() ;
		      
		    System.out.println(getMaxSum(arr, n));
		}
	}
	static int getMaxSum(int arr[][], int n){
	    int dp[] = new int[n] ; 
	    
	    dp[0] = Math.max(arr[0][0], arr[1][0]) ; 
	    dp[1] = Math.max(dp[0], Math.max(arr[0][1], arr[1][1])) ; 
	    
	    for(int i = 2; i < n; i++)
	      dp[i] = Math.max(dp[i - 1] , dp[i - 2] + Math.max(arr[0][i], arr[1][i])); 
	    
	    return dp[n - 1] ;   
	}
}
