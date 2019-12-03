/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int n = 17 ; 
		int dp[] = new int[n + 1] ; 
		for(int i = 0 ; i <= n ; i++)
		 dp[i] = Integer.MAX_VALUE ;
		 fillArray(dp, 1, 1, 1, n) ;
		 System.out.println(dp[17]) ;
	}
	
	static void fillArray(int dp[], int curr, int count, int index, int n) {
	    if(index > n || count < 0)
	      return ; 
	    //System.out.println(curr+" "+count+" "+index+" "+dp[curr]);
	    if(count == 0){
	        if(dp[curr + 1] != Integer.MAX_VALUE)
	          fillArray(dp, curr + 1, dp[curr + 1], index, n) ; 
	        else
	          fillArray(dp, curr + 1, curr + 1, index, n) ;
	    }
	    dp[index] = curr ; 
	    fillArray(dp, curr, --count , index + 1, n) ;
	}
}
