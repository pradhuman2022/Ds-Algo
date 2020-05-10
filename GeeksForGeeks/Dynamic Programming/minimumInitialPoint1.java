import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int mat[][];
    static int dp[][];
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0){
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        mat = new int[n][m];
	        dp = new int[n][m];
	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < m; j++)
	                mat[i][j] = sc.nextInt();
	        }
	        for(int a[] : dp)
	            Arrays.fill(a, -1);
	        System.out.println(minimumInitialEnergy(0, 0));
	    }
	 }
	 public static int minimumInitialEnergy(int n, int m){ 
        if(n == mat.length - 1 && m == mat[0].length - 1){
            if(mat[n][m] < 0)    
                return Math.abs(mat[n][m]) + 1;
            else
                return 1;
        }
        if(n >= mat.length || m >= mat[0].length)
            return Integer.MAX_VALUE;
            
        if(dp[n][m] != -1)
            return dp[n][m];
        int option1 = minimumInitialEnergy(n + 1, m);
        int option2 = minimumInitialEnergy(n, m + 1);
        int minInitialPointRequired = Math.max(Math.min(option1, option2) - mat[n][m], 1);
        return dp[n][m] = minInitialPointRequired;
    }
}
