import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the getWays function below.
    static long getWays(int n, int[] c) {
      long dp[][] = new long[52][252] ;
      for(int i = 0 ; i < dp.length; i++)
      {
          for(int j = 0 ; j < dp[0].length; j++)
          dp[i][j] = -1 ;
      }
      return ways(n, 0 , c, dp) ;
    }
    static long ways(int n , int i , int c[], long dp[][])
    {
        if(n == 0)
         return 1 ;
        if(n < 0 || i >= c.length)
        return 0 ;
        if(dp[i][n] != -1)
        return dp[i][n] ;

        long option1 = ways(n - c[i] , i, c, dp) ;
        long option2 = ways(n, i + 1 , c, dp) ;
        
        return dp[i][n] = option1 + option2 ;        
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       
       Scanner sc = new Scanner(System.in) ;
        
        int n = sc.nextInt() ;
        int m = sc.nextInt() ;

        int[] c = new int[m];

        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);

        System.out.println(ways) ;
        scanner.close();
    }
}
