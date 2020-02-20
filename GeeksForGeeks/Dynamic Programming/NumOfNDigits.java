/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
	    System.out.println(countIntegers(n)) ;
	}
	static int countIntegers(int n){
	    int dp[][] = new int[n + 1][10]; 
	    
	    for(int i = 0 ; i <= 9; i++){
	        dp[1][i] = 1;
	    }
	    
	    for(int i = 2; i <= n; i++){
	        for(int j = 0 ; j <= 9; j++){
	            for(int k = 0; k <= j ; k++){
	                dp[i][j] += dp[i - 1][k];
	            }
	        }
	    }
	    
	    int ans = 0 ; 
	    
	    for(int i = 0 ; i <= 9; i++){
	        ans += dp[n][i] ; 
	    }
	    return ans ;
	}
}
