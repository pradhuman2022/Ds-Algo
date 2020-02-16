import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int mod = (int)Math.pow(10, 9) + 7 ;
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 
	 int T = sc.nextInt();
	 
	 while(T -->0){
	  int n = sc.nextInt();
	  int m = sc.nextInt();
	  System.out.println(countWaysToTile(n, m));
	 }
	 }
	 
	 static int countWaysToTile(int n, int m){
	     int dp[] = new int[n + 1] ;
	     
	     for(int i = 1; i <= n; i++){
	         
	         if(i < m)
	          dp[i] = 1 ; 
	         else if(i == m)
	          dp[i] = 2; 
	         else
	           dp[i] = (dp[i - 1] + dp[i - m]) % mod ;
	     }
	     return dp[n];
	 } 
	 
}
