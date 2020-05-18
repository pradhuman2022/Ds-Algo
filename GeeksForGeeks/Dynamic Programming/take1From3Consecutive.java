import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int arr[];
    static int dp[];
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCase = sc.nextInt();
	    while(testCase-->0) {
	        int n = sc.nextInt();
	        arr = new int[n];
	        for(int i = 0; i < n; i++)
	            arr[i] = sc.nextInt();
	        if(n == 1) {
	            System.out.println(arr[0]);
	            continue;
	        }
	        if(n == 2) {
	            System.out.println(Math.min(arr[1], arr[0]));
	             continue;
	        }
	        dp = new int[n + 1];
	        Arrays.fill(dp, -1);
	        System.out.println(minimumSum(n));
	    }
	 }/*
	    solution to kr para tha but case tha ki agr windwo 3 se km hojaye to 
	    0 return krna tha kyuki hmko koi jrurt ni h select krne ki.
	 */
	 static int minimumSum(int n){
	     if(n == 1)
	        return 0;
	     if(n == 2)
	        return 0;
	     if(n == 3)
	        return Math.min(arr[0], Math.min(arr[1], arr[2]));
	     if(dp[n] != -1)
	        return dp[n];
	     int option1 = arr[n - 1] + minimumSum(n - 1);
	     int option2 = arr[n - 2] + minimumSum(n - 2);
	     int option3 = arr[n - 3] + minimumSum(n - 3);
	     return dp[n] = Math.min(option1, Math.min(option2, option3));
	 }
	 
}
