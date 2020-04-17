/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		String orgStr = "GEEKSFORGEEKS";
		String revStr = reverse(orgStr); 
		printLongestPalindromeSubsequence(orgStr, revStr); 
	}
	static String reverse(String str) { 
        String ans = ""; 
        // convert String to character array  
        // by using toCharArray  
        char[] try1 = str.toCharArray(); 
  
        for (int i = try1.length - 1; i >= 0; i--) { 
            ans += try1[i]; 
        } 
        return ans; 
    } 
	static void printLongestPalindromeSubsequence(String orginalString ,String reversedString) {
	    int lenOfString = orginalString.length(); 
	    int dp[][] = new int[lenOfString + 1][lenOfString + 1];
	    
	    for(int i = 0; i <= lenOfString; i++) {
	        for(int j = 0; j <= lenOfString ; j++) {
	            if(i == 0 || j == 0)
	                continue ; 
	            else if(orginalString.charAt(i - 1) == reversedString.charAt(j - 1))
	                dp[i][j] = 1 + dp[i - 1][j - 1] ; 
	            else 
	                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) ; 
	        }
	    }
	    int i = lenOfString , j = lenOfString; 
	    String ans = "" ; 
	    while(i > 0 && j > 0) {
	        
	        if(orginalString.charAt(i - 1) == reversedString.charAt(j - 1)) {
	            ans += orginalString.charAt(i - 1); 
	            i--; 
	            j--;
	        }else if(dp[i - 1][j] > dp[i][j - 1]){
	            i--;
	        }else {
	            j--;
	        }
	    }
	    System.out.println(ans);
	}
}
