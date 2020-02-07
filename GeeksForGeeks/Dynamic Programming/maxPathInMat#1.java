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
		    int n = sc.nextInt(); 
		    
		    
		    int mat[][] = new int[n][n] ; 
		    for (int i = 0; i < n; i++){
		        for (int j = 0; j < n; j++)
		            mat[i][j] = sc.nextInt() ;
		    }
		    
		    System.out.println(minPathCost(mat, n)) ;
		}
	}
	
	static int minPathCost(int mat[][], int n){
	    
	    int dp[][] = new int[n + 1][n + 2] ; 
	    
	    //fill first row 
	    for(int i = 0 ; i < n; i++)
            dp[1][i + 1] = mat[0][i] ; 	    
	    
	    for(int i = 1 ; i <= n; i++){
	        for(int j = 1 ; j <= n ; j++)
	          dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j + 1])) + mat[i - 1][j - 1]; 
	    }
	    
	    int largest = 0 ; 
	    
	    for(int i = 0 ; i <= n ; i++)
	      largest = Math.max(largest, dp[n][i]) ; 
	    
	    
	    return largest ; 
	}
}
