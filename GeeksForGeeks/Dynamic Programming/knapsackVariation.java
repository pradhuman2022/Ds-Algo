import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int W[] ;
    static  int Value[] ;
    static int dp[];
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	        int N = sc.nextInt();
	        int totalWeight = sc.nextInt();
	        W = new int[N];
	        Value = new int[N];
	        for(int i = 0 ; i < N; i++)
	            Value[i] = sc.nextInt();
	        for(int i = 0 ; i < N; i++)
	             W[i] = sc.nextInt();
	        dp = new int[totalWeight + 1];
	       // for(int a[] : dp)
	         //   Arrays.fill(a, Integer.MIN_VALUE);
	        System.out.println(knapsack(N, totalWeight));
	    }
	 }

	 static int knapsack(int N, int totalWeight) {

	      for(int i = 0; i < N; i++) {
	          for(int j = W[i]; j <= totalWeight; j++)
	                dp[j] = Math.max(dp[j - W[i]] + Value[i], dp[j]);
	      }
	      return dp[totalWeight];
	 }
}
