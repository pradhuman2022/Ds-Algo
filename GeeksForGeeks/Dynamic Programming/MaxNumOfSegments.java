/*package whatever //do not write package name here */

import java.util.*;

class GFG {
    static int a , b, c; 
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ;
		
	    a = sc.nextInt() ; 
	    b = sc.nextInt() ; 
	    c = sc.nextInt() ; 
		
		System.out.println(maxSegments(1, n)) ;
	}
	
	static int maxSegments(int i, int n){
	  
	  int dp[] = new int[n + 1]; 
	  Arrays.fill(-1) ; 
	  
	  dp[0] = 0 ; 
	  for (int i = 0 ; i < n; i++){
	      
	      if(dp[i] = -1){
	          
	          //option1 we can break j to i and a so i + a = j 
	          if(i + a < n)
	           dp[i + a] = Math.max(dp[i] + 1, dp[i + a]);
	           
	          if(i + b < n)
	           dp[i + b] = Math.max(dp[i] + 1, dp[i + b]); 
	           
	          if(i + c < n)
	           dp[i + c] = Math.max(dp[i] + 1, dp[i + c]) ; 

	      }
	      
	      
	  }
	  return dp[n] ; 
	}
}
