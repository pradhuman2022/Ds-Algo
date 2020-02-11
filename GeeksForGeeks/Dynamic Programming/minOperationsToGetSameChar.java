/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- >0){
		    int n = sc.nextInt() ;
		    int insrt = sc.nextInt();
		    int del = sc.nextInt();
		    int cpy = sc.nextInt();
		   
		    System.out.println(getMinOperations(n, insrt, del, cpy)); 
		}
	}
	
	static int getMinOperations(int n, int insrt, int del, int cpy){
	    int dp[] = new int[n + 1]; 
	    
	    if(n == 1)
	     return 1;
	    
	    for(int i = 1; i <= n; i++){
	        
	        if(i % 2 == 0)
	          dp[i] = Math.min(dp[i - 1] + insrt, dp[i / 2] + cpy); 
	        else
	          dp[i] = Math.min(dp[i - 1] + insrt, dp[(i + 1) / 2] + del + cpy); 
	    }
	    return dp[n] ; 
	}
}
