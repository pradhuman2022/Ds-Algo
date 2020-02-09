/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	
	public static void main (String[] args) {
	    
		Scanner sc = new Scanner(System.in) ; 
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int arr[] = new int[n] ; 
		
		for (int i = 0 ; i < n; i++){
		    arr[i] = sc.nextInt() ;
		}
		Arrays.sort(arr);
        System.out.println(countRemovals(arr, n, k));
	    }





     static int countRemovals(int arr[], int n, int k){
	    
	    int dp[][] = new int[n + 2][n + 1] ; 
	    
	    for(int i = 0 ; i <= n; i++)
	     dp[n + 1][i] = Integer.MAX_VALUE ;
	     
	    for(int i = n ; i >= 1; i--){
	        for(int j = i + 1; j <= n ; j++)
	         {
	           
	            if(i >= j || arr[j - 1] - arr[i - 1] <= k)
	                dp[i][j] = 0; 
	             else
	                dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]) ;
	         }
	    }/*
9
1 3 4 9 10 11 12 17 20
4 

0 0 1 2 3 4 5 6 0 
0 0 1 1 2 3 4 5 0 
0 0 0 0 1 2 3 4 0 
0 0 0 0 0 1 2 3 0 
0 0 0 0 0 0 1 2 0 
0 0 0 0 0 0 1 2 0 
0 0 0 0 0 0 0 1 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
	    */	    
	    for(int i = 1 ; i <= n ; i++){
	        System.out.print(arr[i - 1]);
	        for(int j = 1 ; j <= n ; j++)
	         System.out.print(" "+dp[i][j]+" ");
	         
	         System.out.println();
	    }
	    return dp[1][n] ; 
	}
}
