import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.System.out;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(tileStacking(n, m, k));
	 }
	 
    static int tileStacking(int n, int m, int k)
	 {
	    int dp[][] = new int[n + 1][m + 1];
	    for(int i = 0 ; i <= m ; i++)
	         dp[0][i] = 1; 
	  
	    for(int j = 1; j <= m; j++) {
	        for(int i = 1; i <= n; i++) {
	            for(int x = 0; x <= k; x++) {
	                    if(i >= x)
	                      dp[i][j] += dp[i - x][j - 1] ; 
	            }
	        }
	    }
	    return dp[n][m]; 
	 }
}
