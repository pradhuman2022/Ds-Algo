import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int arr[];
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	        int N = sc.nextInt();
	        arr = new int[N];
	        for(int i = 0; i < N; i++)
	            arr[i] = sc.nextInt();
	        System.out.println(minimumTime(N));
	    }
	 }
	 public static int minimumTime(int N){
	    int dp[] = new int[N + 1];
	    dp[1] = arr[0];
	    for(int i = 2; i <= N; i++)
	        dp[i] = arr[i - 1] + Math.min(dp[i - 1], dp[i - 2]);
	    return Math.min(dp[N - 1], dp[N]);
	 }
}
