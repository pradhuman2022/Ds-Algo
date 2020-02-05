	  

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		int arr[] ; 
		
		
		while (T-->0){
		    int n = sc.nextInt() ;
		    arr = new int[n] ; 
		    for (int i = 0 ; i < n ; i++)
		     arr[i] = sc.nextInt() ; 
		     
		    int k = sc.nextInt() ; 
		    if(n == 0)
		     System.out.println(0) ; 
		    else
		    System.out.println(getMaxSum(arr, n , k));
		}
	}
	static int getMaxSum(int arr[], int N, int k){
	      Arrays.sort(arr);
        int [] dp = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1];

            if (arr[i] - arr[i - 1] < k) {
                if (i >= 2) {
                    dp[i] = Math.max(dp[i], dp[i - 2] + arr[i] + arr[i - 1]);
                } else {
                    dp[i] = Math.max(dp[i], arr[i] + arr[i - 1]);
                }
            }
        }

        return dp[arr.length - 1];
	}
}
