import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int dp[][];
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0){
	        int x = sc.nextInt();
	        int y = sc.nextInt();
	        dp = new int[x + 1][y + 1];
	        for(int a[] : dp)
	            Arrays.fill(a, -1);
	        System.out.println(findMinCuts(x, y));
	    }
	 }
	 static int findMinCuts(int i, int j) {
	    if(i == j)
	        return 1;
	    if(i == 0 || j == 0)
	        return 0;
	    if(dp[i][j] != -1)
	        return dp[i][j];
	    int minValue = Math.min(i, j);
	    int ans = Integer.MAX_VALUE;
	    for(int k = 1; k <= minValue; k++) {
	        ans = Math.min(ans, Math.min(findMinCuts(i - k, k) + findMinCuts(i, j - k), findMinCuts(i - k, j) + findMinCuts(k, j - k)));
	    }
	    return dp[i][j] = 1 + ans;
	 }
}
