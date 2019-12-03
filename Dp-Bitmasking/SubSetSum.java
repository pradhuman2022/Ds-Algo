/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
	  int arr[] = {1, 3 ,2, 2, 1} ;
	  System.out.println(getCountOfSubSets(5, arr, 4)) ;
	}
	
	static int getCountOfSubSets(int n , int arr[], int targetSum){
	     int count = 0 ; 
	     //use left shift to get 2power
	     int combinations = 1 << n  ;
	     for(int i = 0 ; i < combinations ; i++){
	         int mask = i ;
	         int sum = 0 ; 
	         for(int j = 0 ; j  < n ;j++){
	             if((mask & (1 << j)) != 0)
	               sum += arr[j] ; 
	         }
	         if(sum == targetSum)
	          count++ ;
	     }
	     return count ;
	}
}
