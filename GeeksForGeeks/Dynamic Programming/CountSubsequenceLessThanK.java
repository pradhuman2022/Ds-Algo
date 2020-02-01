/*package whatever //do not write package name here */

import java.io.*;
import java.util.* ; 

class GFG {
	public static void main (String[] args) {
	   Scanner sc = new Scanner(System.in); 
	   int n = sc.nextInt() ; 
	   int arr[] = new int[n]; 
	   
	   System.out.println(countProduct(n, arr, k)) ;   
	}
	static int countProduct(int n , int arr[], int k){
	    
      ///recur(i, product) = recur(i + 1, product) + recur(i + 1, product * arr[i])	    
	  //base case1: if product is less K and we considered all elements then return 1 ; 
	  //base case2: if product is lesss than 0 then return 0 ; 
	  
	  int dp[][] = new int[n + 1][k + 1] ; 
	  
	  for(int i = 0 ; i <= k ; i++)
	   dp[0][i] = 1 ; 
	   
	  for(int i = 1; i <= n ; i++){
	      for(int j = 1 ; j <= k; i++)
	       {
	           
	           dp[i][j] = dp[i - 1][j] ; 
	           
	           if(arr[i - 1] =< k && arr[i - 1] > 0)
	           {
	               dp[i][j] += dp[i - 1][j / arr[i - 1]] ; 
	           }
	           
	       }
	    return dp[n][k] ; 
	}
}
