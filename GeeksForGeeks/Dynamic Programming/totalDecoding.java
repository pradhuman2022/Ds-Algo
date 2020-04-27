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
	        int N = sc.nextInt();
	        sc.nextLine();
	        String str = sc.nextLine(); 
	        System.out.println(countAllDecodings(N, str));
	    }
	 }
	 /*
	 I was troubling with cases where 0 leading element tha.
	 apporach shi thi.
	 */
	 static int countAllDecodings(int size, String encodedString) {
	     if(encodedString.charAt(0) == '0')
	        return 0; 
	     int dp[] = new int[size + 1]; 
	     dp[1] = 1; 
	     dp[0] = 1;
	     for (int i = 2; i <= size; i++) {
	        if(encodedString.charAt(i - 1) != '0')
	            dp[i] = dp[i - 1];
	            
	        if(encodedString.charAt(i - 2) - '0' != 0 && canBeAlphabet((encodedString.charAt(i - 2) - '0') * 10 + (encodedString.charAt(i - 1) - '0')))	            
	            dp[i] += dp[i - 2];
	     }
	     return dp[size]; 
	 }
	 static boolean canBeAlphabet(int num) {
	     if(num >= 1 && num <= 26)
	        return true;
	     return false; 
	 }
}
