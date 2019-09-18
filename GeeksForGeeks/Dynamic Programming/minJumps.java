/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int  T = sc.nextInt();
		
		while(T-- > 0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		   
		    for(int i = 0; i < n ; i++)
		    arr[i] = sc.nextInt();
		  
		    long dp[] = new long[arr.length] ;
		      
            for(int i = 0 ; i < arr.length ; i++)
              dp[i] = -1 ;
        
          int ans = (int)minJumps(0, arr.length - 1, arr, dp) ;
          System.out.println(ans == Integer.MAX_VALUE ? -1 : ans) ;
		}
    
	}
	
   static long minJumps(int n , int dist, int A[], long dp[]) 
    {
        if(dist <= n)
          return  0 ; 
        
        if(dp[n] != -1) 
           return dp[n] ;
        
        long ans = Integer.MAX_VALUE ;
        
        for(int pos = n + 1 ; n < A.length && pos <= A[n] + n;  pos++)
        {
           long k = 1 + minJumps(pos, dist, A, dp) ; 
           ans = Math.min(k, ans) ; 
        }
        return dp[n] = ans ;
    }
    
}
    
    
