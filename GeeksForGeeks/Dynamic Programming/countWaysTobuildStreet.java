/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		System.out.println(countWaysToBuildStreet(n)) ;
	}
	
    static int countWaysToBuildStreet(int n){
        int dp[][] = new int[2][n + 1] ; 
        
        dp[1][1] = 2 ; 
        dp[0][1] = 1 ;
        
        for (int i = 2; i <= n; i++){
            
            //if atleast one house and one office 
            dp[1][i] = dp[0][i - 1] * 2 + dp[i - 1][1] ; 
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
        }
        return dp[1][n] + dp[0][n] ;
    }
}
