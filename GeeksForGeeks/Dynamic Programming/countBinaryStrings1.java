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
	    int testCases = sc.nextInt();
	    while(testCases-->0){
	        int N = sc.nextInt();
	        int K = sc.nextInt();
	        System.out.println(countBinaryStrings(N, K));
	    }
	 }
	 /*
	  logic to ara tha ki 0 rkhe kisi place p ya 1 rkhe but 3d dp ka
	  definition ni bn para tha.
	 */
	 static int countBinaryStrings(int n, int k) {
	     int dp[][][] = new int[n + 1][k + 1][2];
	     dp[1][0][0] = 1;
	     dp[1][0][1] = 1;
	     
	     for(int i = 2; i <= n; i++) {
	         for(int j = 0; j <= k; j++) {
	             dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % mod;
	             dp[i][j][1] = dp[i - 1][j][0];
	             
	             if(j - 1 >= 0)
	                dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j - 1][1]) % mod;
	             
	         }
	     }
	    return (dp[n][k][0] + dp[n][k][1]) % mod; 
	 }
}
