/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	static int mod = (int)Math.pow(10, 9) + 7 ;
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		
		long dp[][] = new long[1001][1001] ; 
		 
		
		fillBellTriangle(dp) ; 
		
		int T = sc.nextInt() ; 
		while(T-->0){
		    int n = sc.nextInt() ; 
		    System.out.println(dp[n][0]) ; 
		}
	}
	
	
	//Iterative Solution Using Bell Triangle
	static void fillBellTriangle(long triangle[][]){
	    
	    triangle[0][0] = 1 ; 
	    
	    for(int i = 1  ; i < triangle.length ; i++){
	        
	        triangle[i][0] = triangle[i - 1][i - 1] ; 
	        for(int j = 1 ; j <= i ; j++)
	         triangle[i][j] += ((triangle[i - 1][j - 1] % mod) + (triangle[i][j - 1] % mod)) % mod ;
	         //just filling triangle 
	    }
	}
}
