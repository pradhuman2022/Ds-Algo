/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
		    int n = sc.nextInt();
		    
		    int arr[] = new int[n];
		    
		    for(int i = 0 ; i < n ; i++)
		      arr[i] = sc.nextInt();
		    
		    System.out.println(maxSubBiotinic(arr, n));    
		}
	}
	static int maxSubBiotinic(int arr[], int n){
	    
	    int dp1[] = new int[n];
	    int dp2[] = new int[n]; 
	    
	   //this is for max sum increaing Subsequence 
	   
	    dp1[0] = arr[0] ; 
	    for(int i = 0 ; i < n ; i++)
	      {
	          dp1[i] = arr[i] ;//what if for curr ith there is nothing which is lesser than it then ans be itself.
	          for(int j = i - 1 ; j >= 0; j--)
	           {
	               if(arr[i] > arr[j] && dp1[i] < arr[i] + dp1[j]) 
	                  dp1[i] = arr[i] + dp1[j] ; 
	           }
	      }
	   
	   //this is for max sum decresing Subsequence
	   
	    dp2[n - 1] = arr[n - 1] ; 
	    for(int i = n - 2 ; i >= 0 ; i--)
	      {
	          dp2[i] = arr[i] ;
	          for(int j = i + 1 ; j < n; j++)
	           {
	               if(arr[i] > arr[j] && dp2[i] < arr[i] + dp2[j])
	                 dp2[i] = arr[i] + dp2[j] ; 
	           }
	      }
	      
	   int ans = Integer.MIN_VALUE ; 
	   for(int i = 0 ; i < n ; i++)
	   {
	       ans = Math.max(ans, dp1[i] + dp2[i] - arr[i]) ; 
	   }
	   return ans ; 
	    
	}
}
