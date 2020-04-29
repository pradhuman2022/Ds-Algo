import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int N;
    static String str;
    static int dp[][];
    static int MAX = 40;
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	        N = sc.nextInt();
	        sc.nextLine();
	        str = sc.nextLine();
	        dp = new int[901][N + 1];
	        for(int a[]:dp)
	            Arrays.fill(a, -1); 
	        System.out.println(countGroupings(0, 0)); 
	    }
	 }
	 static int countGroupings(int previousSum, int position) {
	     if(position == str.length())
	            return 1;
	     
	     if(dp[previousSum][position] != -1)
	        return dp[previousSum][position] ; 
	     int sum = 0;
	     int ans = 0;
         for(int i = position; i < N; i++) {
            sum += str.charAt(i) - '0';
            if(sum >= previousSum)
               ans += countGroupings(sum, i + 1);
         }
        return dp[previousSum][position] = ans; 
	 }
}
