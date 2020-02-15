/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		System.out.println(countingPairs(n)) ;
	}
	
    static int countingPairs(int n){
        int dp[] = new int[n + 1]; 
         
        dp[0] = 1;
        dp[1] = 1 ; 
        
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] * (i - 1) ;
        }
        return dp[n];
    }
}
