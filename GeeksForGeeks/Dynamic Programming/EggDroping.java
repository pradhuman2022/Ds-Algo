import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0){
	        int N = sc.nextInt();
	        int K = sc.nextInt();
	        System.out.println(minimumTrials(N, K));
	    }
	 }
	 static int minimumTrials(int N, int K) {
	     int dp[][] = new int[N + 1][K + 1]; 
	     for(int i = 1; i <= K; i++) {
	         dp[1][i] = i ; 
	     }
	     for(int i = 1; i <= N; i++) {
	         dp[i][1] = 1;
	     }
	     for(int i = 2; i <= N; i++) {
	         for (int k = 2; k <= K; k++) {
	             dp[i][k] = Integer.MAX_VALUE;
	             int res; 
	             for(int x = 1; x <= k; x++) { 
	                res = 1 + Math.max(dp[i - 1][x - 1], dp[i][k - x]) ;
	                dp[i][k] = Math.min(dp[i][k], res) ;
	             }
	         }
	     }
	   return dp[N][K];
	 }
}
