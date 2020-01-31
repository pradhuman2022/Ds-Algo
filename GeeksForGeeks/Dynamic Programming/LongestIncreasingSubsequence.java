/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		
		while(T-- > 0){
		    int n = sc.nextInt() ; 
		    int arr[] = new int[n] ; 
		    for(int i = 0 ; i < n ; i++)
		     arr[i] = sc.nextInt() ; 
		    
		    System.out.println(Lis(arr,n));    
		}
	}
	static int Lis(int arr[], int n){
	    int dp[] = new int[n] ; 
	    dp[0] = 1 ;
	    for(int i = 1 ; i < n ; i++){
	        dp[i] = 1;
	        int max = 0 ; 
	        for(int j = i - 1 ; j >= 0 ; j--)
	          if(arr[i] > arr[j])
	             max = Math.max(max, dp[j]) ; 
	             
	       dp[i] += max ;       
	    }
	   int max = 0 ; 
	   for(int ans : dp)
	    max = Math.max(max, ans) ; 
	   return max ;  
	}
}
