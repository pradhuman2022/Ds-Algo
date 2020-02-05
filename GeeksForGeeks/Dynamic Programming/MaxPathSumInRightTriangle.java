import java.io.*;

class GFG {
 static int getMaxSumInTriangle(int arr[][], int n){
	    int dp[][] = new int[n + 1][n + 1] ; 
	    int max =Integer.MIN_VALUE ; 
	    
	    for (int i = 1 ; i <= n ; i++){
	        for (int j = 1 ; j <= i; j++){
	            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i - 1][j - 1] ; 
	            max = Math.max(max, dp[i][j]) ; 
	      }
	        
	    }
	    return max ; 
	}
	
	public static void main (String[] args) {
	 int tri[][] = {{1}, {2,1}, {3,3,2}};
        System.out.println(getMaxSumInTriangle(tri,tri.length));
      }
}
