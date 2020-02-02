/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt() ; 
		
		while(T -- >0){
		    int n = sc.nextInt() ; 
		    int arr[] = new int[n];
		    
		    for(int i = 0 ; i < n ; i++)
		     arr[i] = sc.nextInt() ; 
		    System.out.println(longestSubsequence(arr, n));
		}
	}
	static int longestSubsequence(int arr[], int n){
	    int dp[] = new int[n] ; 
	    dp[0] = 1 ; 
	    
	    for(int i = 1 ; i < n ; i++){
	        dp[i] = 1 ; 
	        for(int j = i - 1; j >= 0 ; j--){
	            
	            if(arr[i] == arr[j] + 1 || arr[i] == arr[j] - 1)
	              dp[i] = Math.max(dp[j] + 1, dp[i]) ; 
	        }
	    }
	    
	   int max = Integer.MIN_VALUE ; 
	   for(int a : dp)
	    max = Math.max(a, max) ; 
	   return max ;  
	}
	
}
