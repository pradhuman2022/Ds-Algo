import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int dp[]; 
    static int arr1[];
    static int arr2[];
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	        int n = sc.nextInt();
	        arr1 = new int[n];
	        for (int i = 0; i < n; i++)
	            arr1[i] = sc.nextInt();
	            
	        int m = sc.nextInt();
	        arr2 = new int[m]; 
	        for (int i = 0; i < m; i++)
	            arr2[i] = sc.nextInt();
	        dp = new int[m]; 
	        
	        for (int i = 0; i < n; i++) {
	            int current = 0;
	            for (int j = 0; j < m; j++) {
	                if(arr1[i] == arr2[j]){ 
	                    if(current + 1 > dp[j]) {
	                        dp[j] = current + 1;     
	                    }
	                }
	                if(arr1[i] > arr2[j]) 
	                    if(current < dp[j])
	                        current = dp[j]; 
	            }
	        }
	        int max = Integer.MIN_VALUE;
	        for (int i = 0; i < m; i++)
	            max = Math.max(max, dp[i]);
	            
	        System.out.println(max);
	    }
	 }
}
