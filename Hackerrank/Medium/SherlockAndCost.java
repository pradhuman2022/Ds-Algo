import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cost function below.
    static int cost(int[] arr)

       {    int n = arr.length;
            int dp[][] = new int[n][2] ;
        
        for(int j = 1 ; j < n ;j++)
        {
            dp[j][0] = Math.max(dp[j - 1][0], Math.abs(arr[j-1]- 1) + dp[j - 1][1]) ;
            dp[j][1] = Math.max(dp[j - 1][0] + Math.abs(arr[j] - 1),dp[j - 1][1]+Math.abs(arr[j] - arr[j - 1]));
        
       }
       return Math.max(dp[n - 1][0], dp[n -1][1]) ;
    }
    static int cost(int i , int b[])
    {
        if(i == b.length)
          return  0 ;
        
        int option1 = b[i]-cost(i + 1,b);
        int option2 = 1 - cost(i + 1,b) ;
        return Math.max(option1, option2) ;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            int result = cost(B);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
