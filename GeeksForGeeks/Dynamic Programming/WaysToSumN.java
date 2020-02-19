import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int mod = (int)Math.pow(10, 9) + 7;
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    
	    while(T-->0){
	        int m = sc.nextInt();
	        int n = sc.nextInt();
	        
	        int arr[] = new int[m];
	        for(int i= 0; i < m; i++)
	            arr[i] = sc.nextInt();
	            
	        System.out.println(countWaysToSum(arr, m ,n)) ; 
	    }
	 
	 }
	 static long countWaysToSum(int arr[], int m, int n){
	     long dp[] = new long[n + 1] ; 
	     
	     dp[0] = 1 ;
	     
	     for(int j = 1; j <= n; j++)
	     for(int i = 0; i < arr.length; i++)
	                if(j >= arr[i])
	                dp[j] = (dp[j] + dp[j - arr[i]]) % mod ;/// we need to traverse every element because order doesnt matter
	    return dp[n] ;                                      //6 , 1 and 1, 6 for 7 both are possible case
	 }
	 
	 
}
