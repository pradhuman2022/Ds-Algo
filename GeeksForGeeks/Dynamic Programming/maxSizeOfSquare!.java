/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 
		
		while(T-- >0){
		    int n = sc.nextInt() ; 
		    int m = sc.nextInt() ; 
		    
		    int mat[][] = new int[n][m] ;
		    for(int i = 0; i < n; i++)
		      for(int j = 0; j < m; j++)
		        mat[i][j] = sc.nextInt() ; 
		        
		    System.out.println(findMaxSquare(mat, n, m)) ;
		}
	}
	static int findMaxSquare(int mat[][], int n , int m){
	    
	    int aux[][] = new int[n][m] ; 
	    
	    for (int i = 0 ; i < n ; i++)
	      aux[i][0] = mat[i][0] ; 
	      
	    for (int i = 0 ; i < m ; i++)
	      aux[0][i] = mat[0][i] ;
	      
	    for(int i = 1; i < n ; i++){
	        for(int j = 1; j < m; j++){
	            if(mat[i][j] == 1)
	              aux[i][j] = Math.min(aux[i - 1][j], Math.min(aux[i][j - 1], aux[i - 1][j - 1])) + 1 ; 
	        }
	    }
	    
	    int max = Integer.MIN_VALUE ; 
	    
	    for(int i = 0 ; i < n ; i++){
	        for(int j = 0 ; j < m ; j++)
	          max = Math.max(max, aux[i][j]) ; 
	    }
	    
	    return max ; 
	}
}
