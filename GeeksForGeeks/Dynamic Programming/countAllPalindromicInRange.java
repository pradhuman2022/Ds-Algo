import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    
	    while(testCases-->0) {
            int len = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine(); 
            int left = sc.nextInt();
            int right = sc.nextInt();
            int temp;
            if(left > right) {
                temp = right;
                right = left;
                left = temp ;
            }
            System.out.println(countOfPalindrome(left, right, str, len)) ;
	    }
	 }
	 static int countOfPalindrome(int left, int right, String str, int len) {
	     boolean dp[][] = new boolean[len][len] ; 
	     int count[][] = new int[len][len]; 
	     
	     for(int i = 0; i < len; i++) {
	        dp[i][i] = true ;
	     }
	     
	     for(int i = 0; i < len - 1; i++) {
	         if(str.charAt(i) == str.charAt(i + 1)) {
	             dp[i][i + 1] = true; 
	             count[i][i + 1] = 1; 
	         }
	     }
	     
	     for(int l = 3; l <= len; l++) {
	         for(int i = 0; i < len - l + 1; i++) {
	             int j = l + i - 1 ; 
	             if(dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
	                dp[i][j] = true; 
	                count[i][j] = 1 + count[i + 1][j] + count[i][j - 1] - count[i + 1][j - 1]; 
	             }else {
	                count[i][j] = count[i + 1][j] + count[i][j - 1] - count[i + 1][j - 1];
	             }
	         }
	     }
	     return count[left][right]  + (right - left + 1); 
	 }
}
