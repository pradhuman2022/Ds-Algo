/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-->0){
		    int n = sc.nextInt();
	        System.out.println(getMinSteps(n)) ; 
		}
	}
	static int getMinSteps(int n){
	    int dp[] = new int[n + 1] ;
	    if(n >= 2)
	    dp[2] = 1 ;
	    
	    if(n >= 3)
	    dp[3] = 1 ;
	    
	    for(int i = 4; i <= n; i++){
	       
	       // dp[i] = Math.min(dp[i / 3], Math.min(dp[i /2], dp[i - 1])) + 1; 
	      int min_steps = Integer.MAX_VALUE ;
	      
	      if(i % 3 == 0)
	       min_steps = 1 + dp[i/ 3] ;
	      if(i % 2 == 0) 
	       min_steps = Math.min(min_steps, 1 + dp[i / 2]) ; 
	       
	      min_steps = Math.min(min_steps, dp[i - 1] + 1);    
	      dp[i] = min_steps;
	        
	    }
	    
	    return dp[n] ;
	}
}
