import java.io.*;
import java.util.* ; 

class GFG {
	public static void main (String[] args) {
	   Scanner sc = new Scanner(System.in); 
	   int n = sc.nextInt() ; 
	   int arr[] = new int[n] ;
	    
	   for(int i = 0 ; i < n; i++)
	    arr[i] = sc.nextInt() ; 
	   
	   System.out.println(getMaximumSum(arr, n)) ;   
	}
	static int getMaximumLength(int arr[], int n){
	    
	    int dp[] = new int[n] ; 
	    dp[0] = 1 ; 
	    
	    for(int i = 1 ; i < n ; i++){
	        dp[i] = 1 ; 
	        for(int j = i - 1 ; j >= 0; j--){
	            if(Math.abs(arr[i] - arr[j]) <= 1)
	              dp[i] = Math.max(dp[i], dp[j] + 1)  ;
	        }
	    }
	    int max = Integer.MIN_VALUE ; 
	    for(int a : dp)
	    max = Math.max(max, a); 
	    return a ; 
	    
	}
}
