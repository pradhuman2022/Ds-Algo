/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		while(T-->0){
		    String s = sc.nextLine() ;
		    System.out.println(sumOfAllSubstrings(s));
		}
	}
	static long sumOfAllSubstrings(String str){
	    int n = str.length() ; 
	    
	    long dp[] = new long[n] ; 
	    dp[0] = str.charAt(0) - '0' ; 
	    long res = dp[0] ; 
	    for(int i = 1; i < n; i++){
	        
	        int num  = str.charAt(i) - '0'; 
	        
	        dp[i] = dp[i - 1] * 10 + num * (i + 1);
	        res += dp[i] ; 
	        
	    }
	   
	   return  res ; 
	}
}
