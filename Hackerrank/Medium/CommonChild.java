import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
         int dp[][] = new int[s1.length() + 1][s2.length()  +1] ;
         return child(s1, s2, 0, 0 , dp) ;

    }
    static int child(String s1 , String s2, int i , int j, int dp[][])
    {
        if(i == s1.length() || j == s2.length())
        {
           return 0 ;
        }
        if(dp[i][j] != 0)
        return dp[i][j] ;
         
        if(s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j] = 1 + child(s1 , s2 , i+1, j+1, dp) ;
        }
        else
        {
            int ans1 = child(s1, s2, i + 1, j , dp) ;
            int ans2 = child(s1, s2, i, j + 1, dp) ;
            return dp[i][j] = Math.max(ans1, ans2) ;
        }


       
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
