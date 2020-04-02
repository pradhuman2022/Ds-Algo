/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		while(testCases-->0)  {
		    int n = sc.nextInt();
		    int set[] = new int[n];
		    for (int i = 0; i < n; i++) 
		        set[i] = sc.nextInt();
		    if(canPartition(n, set))
		        System.out.println("YES");
		    else
		        System.out.println("NO");
		}
	}
	static boolean canPartition(int n, int set[]) {
        int total = 0;
        for (int i = 0; i < n; i++)
            total += set[i];
        
        //if totalSum is odd then we cannt divide elements;
        if(total % 2 != 0)
            return false;
        //if totalSum is even then we only need to check   
        total /= 2;
        boolean dp[][] = new boolean[total + 1][n + 1];
        for (int i = 0; i <= n; i++)
            dp[0][i] = true;
            
        for(int i = 1; i <= total; i++)
            dp[i][0] = false ;
        for (int i = 1; i <= total; i++) {
            for(int j = 1; j <= n; j++) {
                if(i >= set[j - 1])
                    dp[i][j] = dp[i - set[j - 1]][j - 1];
                dp[i][j] = dp[i][j] || dp[i][j - 1]; 
            }
        }
        return dp[total][n] ; 
	}
}
