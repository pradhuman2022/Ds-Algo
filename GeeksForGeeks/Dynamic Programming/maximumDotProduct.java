import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int A[];
    static int B[];
    static int dp[][]; 
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        A = new int[n];
	        B = new int[m];
	        dp = new int[n][m];
	        for(int ar[]: dp)
	            Arrays.fill(ar, Integer.MAX_VALUE);
	        for(int i = 0; i < n; i++)
	            A[i] = sc.nextInt();
	        
	        for(int i = 0; i < m; i++)
	            B[i] = sc.nextInt();
	        System.out.println(maxDotProduct(0,0));
	    }
	 }
	 static int maxDotProduct(int i, int j) {
	    if(j == B.length || i == A.length)
	        return 0; 
	    if(dp[i][j] != Integer.MAX_VALUE)
	        return dp[i][j]; 
	    int option1 = A[i] * B[j] + maxDotProduct(i + 1, j + 1); 
	    int option2 = maxDotProduct(i + 1, j);
	    return dp[i][j] = Math.max(option1, option2);
	 }
}
