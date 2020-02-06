/*package whatever //do not write package name here */

import java.util.*;

class GFG {
    static int a , b, c; 
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		int arr[] = new int[n] ; 
		
		for (int i = 0 ; i < n; i++)
		  arr[i] = sc.nextInt() ; 
		System.out.println(maxSum(arr, n)) ;
	}
	
	static int maxSum(int arr[], int n){
	  
	  int max = Integer.MIN_VALUE ;
	  
	  for(int i = 0 ; i< n;i++)
	  {
	      max = Math.max(max, arr[i]) ; 
	  }
	  
	  int freq[] = new int[max + 1] ;
	  for(int i = 0 ; i < n ; i++)
	   freq[arr[i]]++ ;
	   
	   
	  int dp[] = new int[max + 1]  ;
	  dp[1] = freq[1] ;
	  
	  for(int i = 2 ; i <= max; i++)
	    dp[i] = Math.max(dp[i - 1], dp[i - 2] + freq[i] * i) ; 
	  
	  return dp[max] ; 
	}
}
