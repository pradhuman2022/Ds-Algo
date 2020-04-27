import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in); 
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        
	        int arr[] = new int[n];
	        for (int i = 0; i < n; i++)
	            arr[i] = sc.nextInt();
	        System.out.println(countOfSubsets(arr, n, k));
	    }
	 }
	 /*
	    Approach to aagya tha , but maximum value kya hogi xor ka wo ni aya.
	    max value xor ki lene k bad mene ek case handle ni kia ki value k 
	    agr max value of xor se jyda hojaye. jiski wjh se outofBoundException
	    ara tha.
	    but overall apporach shi tha.
	 */
	 static int countOfSubsets(int arr[], int n, int k) {
	    int max = Integer.MIN_VALUE;
	    for(int val : arr)
	        max = Math.max(max, val);
	    int bitCounts = (int)(Math.log(max) / Math.log(2) + 1); 
	    int m = (1 << bitCounts) - 1;
	    
	    if(m < k) {
	        bitCounts = (int)(Math.log(k) / Math.log(2) + 1);
	        m = (1 << bitCounts) - 1;
	    }
	    
	    int dp[][] = new int[n + 1][m + 1];
	    dp[0][0] = 1;
	    for (int i = 1; i <= n; i++) {
	        for(int j = 0; j <= m; j++)
	            dp[i][j] = dp[i - 1][j] + dp[i - 1][j ^ arr[i - 1]];
	    }
	    return dp[n][k];
	 }
}
