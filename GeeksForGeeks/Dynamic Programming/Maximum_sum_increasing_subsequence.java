/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T--> 0)
		{
		    
		  int n = sc.nextInt();
		  int arr[] = new int[n] ;
		  
		  for(int i = 0 ; i < n ; i++)
		  {
		      arr[i] = sc.nextInt();
		  }
		  System.out.println(maxSumLongestIncreasing(arr, n)) ; 
		}
	}
	
	static int maxSumLongestIncreasing(int arr[], int n){
	    int dp[] = new int[n]; 
	    
	    for(int i = 0 ; i < n ; i++){
	        dp[i] = arr[i] ; 
	        for(int j = i - 1 ; j >= 0 ; j--){
	            
	            if(arr[i] > arr[j] && dp[i] < arr[i] + dp[j])
	              dp[i] = arr[i] + dp[j] ; 
	        } 
	    }
	  int max = Integer.MIN_VALUE ; 
	  
	  for(int a : dp)
	   max = Math.max(max, a) ; 
	  return max ;  
	}
}
