import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int mod = (int)Math.pow(10, 9) + 7;
    
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 
	 int T = sc.nextInt();
	 
	 while(T-->0){
	     int n = sc.nextInt();
	     int m = sc.nextInt();
	     System.out.println(countAllPaths(n, m)) ;
	 }
	 
	 }
	 
	 static int countAllPaths(int n, int m){
	     int dp[][] = new int[n + 1][m + 1] ; 
	     dp[n - 1][m - 1] = 1 ; 
	     
	     for(int i = n - 1; i >= 0; i--){
	         for(int j = m - 1; j >= 0; j--){
	             if(i == n - 1 && j == m - 1)
	             continue ;
	             dp[i][j] = (dp[i + 1][j] + dp[i][j + 1]) % mod;
	         }
	     }
	     return dp[0][0];
	 }
	 
}
