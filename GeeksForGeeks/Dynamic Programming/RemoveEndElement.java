/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
	    
	    int arr[] = new int[n];
	    for(int i = 0; i < n; i++)
	        arr[i] = sc.nextInt();
	    int dp[][] = new int[n][n] ;
	    for(int i = 0; i < n ; i++)
	        for(int j = 0; j < n ; j++)
	            dp[i][j] = Integer.MIN_VALUE;
	    System.out.print(getMaxScore(arr, dp , 1, 0, n - 1)) ;
	}
	static int getMaxScore(int arr[], int dp[][], int turn, int i, int j){
	    
	    //baseCase 
	    if(i == j) 
	        return arr[i] * turn ; 
	    
	    if(dp[i][j] != Integer.MIN_VALUE)
	        return dp[i][j] ; 
	    
	    int removeLeft = arr[i] * turn + getMaxScore(arr, dp, turn + 1, i + 1, j) ;
	    int removeRight = arr[j] * turn + getMaxScore(arr, dp, turn + 1, i, j - 1) ;
	    
	    dp[i][j] = Math.max(removeRight, removeLeft);
	    
	    return dp[i][j] ; 
	}
}
