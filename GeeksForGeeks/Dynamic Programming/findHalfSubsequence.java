/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ;
		int T = sc.nextInt() ;
		
		while(T-->0){
		    int m = sc.nextInt() ; 
		    int n = sc.nextInt() ; 
		    System.out.println(findSubsequence(m , n)) ; 
		}
	}
	
	//recursive approach
	static int findSubsequence(int m, int n){
	    
	    //if length is greater than m.
	    if(m < n)
	     return 0 ; 
	     
	    //if we already consider every element 
	    if(n == 0)
	     return 1 ; 
	     
	    //if nth element is m. 
	    int option1 = findSubsequence(m / 2 , n - 1); 
	    
	    //if nth element is not m.
	    int option2 = findSubsequence(m - 1, n) ; 
	    
	    return option1 + option2 ; 
	}
	
	
	//iterative approach
	/*static int findSubsequence(int m , int n){
	    int dp[][] = new int[m + 1][n + 1] ; 
	    for(int i = 0 ; i < )
	}
	*/
	/*
  Given two integers m & n, find the number of possible sequences of length n such that each of the next element is greater 
  than or equal to twice of the previous element but less than or equal to m.
  */
}
