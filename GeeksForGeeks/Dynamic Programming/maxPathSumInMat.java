/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in) ;
		int n = sc.nextInt(); 
		int m = sc.nextInt();
		
		int mat[][] = new int[n][m] ; 
		for (int i = 0 ; i < n; i++){
		    for(int j = 0; j < m; j++)
		      mat[i][j] = sc.nextInt() ;
		}
		System.out.println(getMaxPathSum(mat, n, m)) ;
	}
	
	static int getMaxPathSum(int mat[][], int n, int m){
	    
	    int dp[][] = new int[n][m + 2] ; 
	    
	    for(int i =0 ; i < m; i++)
	     dp[0][i + 1] = mat[0][1] ; 
	     
	    for(int i = 1 ; i < n; i++){
	        for(int j = 1 ; j <= m ; i++)
	          {
	              dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i- 1][j + 1], dp[i - 1]][j - 1]) ;
	          }
	    } 
	    
	    int ans = 0 ; 
	    for(int i = 0 ; i <= m ; i++)
	      ans = Math.max(ans, dp[n - 1][i])
	}
}
