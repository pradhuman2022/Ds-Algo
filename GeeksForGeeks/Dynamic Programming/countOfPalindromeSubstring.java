import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in); 
	    int testCase = sc.nextInt();
	    while(testCase-->0) {
	        int n = sc.nextInt();
	        sc.nextLine();
	        String str = sc.nextLine();
	        System.out.println(countSubstrings(str, n)) ; 
	    }
	 }
	 static int countSubstrings(String str, int len) {
	     int countSubstrings[][] = new int[len][len] ;
	     boolean dp[][] = new boolean[len][len]; 
	     
	     for(int i = 0; i < len; i++)
	        dp[i][i] = true;
	     
	     for(int i = 0; i < len - 1; i++) {
	        if(str.charAt(i) == str.charAt(i + 1)) {
	            dp[i][i + 1] = true; 
	            countSubstrings[i][i + 1] = 1; 
	        }
	     }
	     
	     for(int l = 3; l <= len; l++) {
	         for(int i = 0; i < len - l + 1; i++) {
	            int j = i + l - 1;  
	            if(dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j))
	                dp[i][j] = true; 
	            
	            if(dp[i][j]) {
	                countSubstrings[i][j] = 1 + countSubstrings[i + 1][j] + countSubstrings[i][j - 1] - countSubstrings[i + 1][j - 1];
	            }else {
	                countSubstrings[i][j] = countSubstrings[i + 1][j] + countSubstrings[i][j - 1] - countSubstrings[i + 1][j - 1]; 
	            }
	         }
	     }
	     return countSubstrings[0][len - 1]; 
	     
	     
	 }
}
