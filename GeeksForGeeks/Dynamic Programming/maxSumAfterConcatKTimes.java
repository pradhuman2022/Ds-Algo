/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() ;
		int k = sc.nextInt() ;
		int arr[] = new int[n] ; 
		for (int i = 0 ; i < n; i++)
		  arr[i] = sc.nextInt() ; 
		  
		System.out.println(getMaxSumAfterConcat(arr, n, k));  
	}
	public static int getMaxSumAfterConcat(int arr[], int n, int k){
	    int best_prefix_sum = Integer.MIN_VALUE ;
	    int current_prefix_sum = 0 ;
	    int best_suffix_sum = Integer.MIN_VALUE ;
	    int current_suffix_sum = 0 ;
	    
	    for (int i = 0; i < n; i++){
	        current_prefix_sum += arr[i] ; 
	        best_prefix_sum = Math.max(current_prefix_sum, best_prefix_sum) ; 
	    }
	    
	    for (int i = n - 1; i >= 0 ; i--){
	       current_suffix_sum += arr[i] ; 
	       best_suffix_sum = Math.max(current_suffix_sum, best_suffix_sum) ; 
	    }
	    
	    int kadensSum = Kadens(arr, n) ;
	    
	    int totalSum = current_prefix_sum ; 
	    int ans ;
	    if(totalSum > 0)
	     ans = Math.max(best_suffix_sum + best_prefix_sum + (k - 2) * totalSum, kadensSum) ; 
	    else 
	     ans = Math.max(best_prefix_sum + best_suffix_sum, kadensSum) ; 
	    
	   return ans ;
	}
	
	
	static int Kadens(int arr[], int n){
	    int currSum = 0 ;
	    int maxSum = Integer.MIN_VALUE ; 
	    
	    for(int i = 0; i < n ; i++){
	        currSum += arr[i] ; 
	        maxSum = Math.max(maxSum, currSum) ; 
	        /*
	        *Kaden Algorithm
	        */
	        if(currSum < 0)
	         currSum = 0 ; 
	    }
	    return maxSum ; 
	}
}
