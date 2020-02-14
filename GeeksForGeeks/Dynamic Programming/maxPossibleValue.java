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
		    int houses = sc.nextInt() ;
		    int value[] = new int[houses] ; 
		    
		    for (int i = 0; i < houses; i++)
		        value[i] = sc.nextInt();
		    System.out.println(maxValueSum(value, houses)) ;       
	}}
	static int maxValueSum(int arr[], int n){
	    if(n == 1)
	     return arr[0] ;
	     
	    int dp[] = new int[n] ; 
	    dp[0] = arr[0];
	    
	    dp[1] = Math.max(dp[0], arr[1]) ;
	    
	    for (int i = 2; i < n; i++){
	        dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]) ;  
	    }
	    return dp[n - 1] ;
	}
}
