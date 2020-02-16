import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 
	 int T = sc.nextInt();
	 while(T-->0){
	     System.out.println(NumOfWays(sc.nextInt())) ;
	 }
	 
	 }
	 static int mod = (int)Math.pow(10, 9) + 7 ;
	 
	 static long NumOfWays(int n){
	     long dp[] = new long[n + 1] ; 
	     
	     for(int i = 1; i <= n; i++){
	         
	         if(i < 4)
	         dp[i] = 1;
	         else if(i == 4)
	         dp[i] = 2; 
	         else
	         dp[i] = (dp[i - 1] + dp[i - 4]) ;
	     }
	     return dp[n];
	 }
}
