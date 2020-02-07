/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ;
		int T = sc.nextInt() ; 
		int arr[] ; 
		
		while(T-->0){
		    int n = sc.nextInt() ; 
		    arr = new int[n] ; 
		    
		    for(int i = 0; i < n; i++)
		      arr[i] = sc.nextInt();
		   
		    System.out.println(getMinSteps(arr, n));
		       
		}
	}
	 
	 static int getMinSteps(int arr[], int n){
	     
	     int dp[] = new int[n + 1] ; 
	     
	     Arrays.fill(dp, Integer.MAX_VALUE) ; 
	     dp[0] = 0 ; 
	     
	     for(int i = 0 ; i < n - 1; i++){
	         if(dp[i] != Integer.MAX_VALUE){
	         for(int j = 1; j <= arr[i]; j++)
	           if(i + j <= n)
	            dp[i + j] = Math.min(dp[i] + 1, dp[i + j]) ;
	         }
	     }
	    if(dp[n - 1] != Integer.MAX_VALUE) 
	    return dp[n - 1] ; 
	    else
	    return -1;
	 }
}
