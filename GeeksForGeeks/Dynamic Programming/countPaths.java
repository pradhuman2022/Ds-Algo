import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in) ;
	 int T = sc.nextInt();
	 
	 while(T-->0){
	     int n = sc.nextInt();
	     int m = sc.nextInt();
	     
	     System.out.println(getNumOfPaths(n, m));
	 }
	 }
	 
	 static int getNumOfPaths(int n, int m){
	     int dp[][] = new int[n + 1][m + 1] ; 
	     
	     for(int i = 0; i <= n ;i++)
	        dp[i][0] = 1 ; 
	     
	     for(int j = 0 ; j <= m; j++)
	        dp[0][j] = 1 ; 
	     
	     for(int i = 1; i <= n; i++){
	         for(int j = 1; j <=m; j++)
	          dp[i][j] = dp[i][j - 1] + dp[i - 1][j] ; 
	     }     
	     return dp[n][m] ; 
	 }
}
