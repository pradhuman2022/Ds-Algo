import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static String s1; 
    static String s2; 
    static int dp[][]; 
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    sc.nextLine();
	    while(testCases-->0) {
	        String str[] = sc.nextLine().split(" ");
	        s1 = str[0];
	        s2 = str[1];
	        dp = new int[s1.length()][s2.length()] ;
	        for(int a[] : dp)
	            Arrays.fill(a, Integer.MIN_VALUE) ; 
	        System.out.println(s1.length() + s2.length() - lcs(0, 0)); 
	    }
	 }
	 static int lcs(int i, int j) {
	     if(i == s1.length() || j == s2.length())
	        return 0;
	        
	     if(dp[i][j] != Integer.MIN_VALUE)
	        return dp[i][j] ; 
	        
	     if(s1.charAt(i) == s2.charAt(j))
	        return dp[i][j] = 1 + lcs(i + 1, j + 1); 
	        
	     return dp[i][j] = Math.max(lcs(i + 1, j), lcs(i, j + 1)) ;
	 }
}
