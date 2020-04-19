/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        while(testCase-- > 0){
        longestPalindromeSubstring(sc.nextLine());
        }
	}
	static void longestPalindromeSubstring(String str) {
	    int n = str.length();
	    boolean dp[][] = new boolean[n][n]; 
	    
	    for(int i = 0; i < n ; i++)
	        dp[i][i] = true; 
	   
	    int start = 0 ; 
	    int maxLength = 1; 
	    for(int i = 0; i < n - 1; i++){
	        if(str.charAt(i) == str.charAt(i + 1)) {
	            dp[i][i + 1] = true;
	           if(maxLength < 2) {
	            maxLength = 2 ; 
	            start = i ; 
	           }
	        }
	    }
	    for(int len = 3; len <= n; len++) {
	        for(int i = 0; i < n - len + 1; i++) {
	            int j = i + len - 1 ; 
	            if(dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
	                dp[i][j] = true;
	                if(maxLength < len){
	                    maxLength = len ; 
	                    start = i ; 
	                }
	            }
	        }
	    }
	    System.out.println(str.substring(start, start + maxLength)) ; 
	}
}
