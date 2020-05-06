import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int points[][];
    static int dp[][];
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0){
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        points = new int[n][m];
	        dp = new int[n][m];
	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < m; j++)
	                points[i][j] = sc.nextInt();
	        }
	        for(int a[] : dp)
	            Arrays.fill(a, -1);
	        System.out.println(getMinInitialPoints(n - 1, m - 1) + 1);
	    }
	 }
	 static int getMinInitialPoints(int n, int m){
	    if(n < 0 || m < 0)
	        return Integer.MAX_VALUE;
	    if(n == 0 && m == 0){
	        if(points[n][m] > 0)
	            return dp[n][m] = 1; 
	        else
	            return dp[n][m] = (points[n][m] * -1) + 1; 
	    }
	    if(dp[n][m] != -1)
	        return dp[n][m]; 
	    int option1 = getMinInitialPoints(n - 1, m);
	    int option2 = getMinInitialPoints(n, m - 1);
	    dp[n][m] = Math.max(Math.min(option1, option2) - points[n][m], 1);
	    return dp[n][m];
	 }
}
