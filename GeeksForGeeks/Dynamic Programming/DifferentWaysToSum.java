/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println(countDiffWays(n, m));
	}
	static int countDiffWays(int n, int m){
	    int dp[][] = new int[n + 2][n + 2];
	    
	    dp[0][n + 1] = 1;
	    
	    for(int i = 0; i <= n; i++){
	        for(int j = n; j >= m; j--){
	            if(i - j >= 0)
	                dp[i][j] = dp[i - j][j];
	            dp[i][j] += dp[i][j + 1];
	        }
	    }
	    return dp[n][m] ;
	}
}
