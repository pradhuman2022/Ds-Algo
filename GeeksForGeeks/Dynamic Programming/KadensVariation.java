/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
	    int arr[] = {3, -4, 2, -3, -1, 7, -5};
	    int arr1[] = {2, 6, 8, 1, 4};
		System.out.println(largestContigousSum(5, arr1));
	}
		 static int largestContigousSum(int n, int arr[]){
	     int dp[] = new int[n];
	     int ans = arr[0];
	     dp[0] = arr[0] ;
	     for(int i = 1; i < n; i++){
	        
	        dp[i] = Math.min(dp[i - 1], 0) + arr[i] ;
	        ans = Math.min(dp[i], ans);
	     }
	  
	    return ans ;
	 }
}
