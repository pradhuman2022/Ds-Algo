/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		
		int T = sc.nextInt();
		
		while(T-->0){
		    int n = sc.nextInt() ;
		    int w = sc.nextInt() ;
		    
		    int cost[] = new int[n];
		    for (int i = 0; i < n; i++)
		        cost[i] = sc.nextInt();
		    
		    System.out.println(minCost(cost, n, w));    
		}
	}
	static int minCost(int cost[], int n, int W){
	    
	    int size = 0 ; 
	    
	    ArrayList<Integer> val = new ArrayList<Integer>() ;
	    ArrayList<Integer> wt = new ArrayList<Integer>() ;
	    
	    
	    for(int i = 0; i < n ; i++){
	        if(cost[i] != -1){
	            size++;
	            val.add(cost[i]);
	            wt.add(i + 1) ; 
	        }
	    }
	   
	   n = size ; 
	   int dp[][] = new int[n + 1][W + 1] ; 
	    
	    for(int i = 0; i <= W; i++)
	      dp[0][i] = Integer.MAX_VALUE;
	    
	    for(int i = 1; i <= n; i++)
	      dp[i][0] = 0 ;
	      
	      
	    for(int i = 1; i <= n; i++){
	        for(int j = 1; j <= W; j++)
	          if(wt.get(i - 1) > j)
	           dp[i][j] = dp[i - 1][j] ;
	           else
	           dp[i][j] = Math.min(dp[i][j - wt.get(i - 1)] + val.get(i - 1), dp[i - 1][j]);
	    }
	    
	    if(dp[n][W] == Integer.MAX_VALUE || dp[n][W] == (Integer.MAX_VALUE * -1))
	     return -1 ;
	    
	    return dp[n][W] ;
	}
}
