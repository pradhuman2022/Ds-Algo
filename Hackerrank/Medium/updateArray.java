import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
     static class Pair {
         Integer a ; 
         Integer b ;
         int value ;
     }
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
         
         long prefixSum[] = new long[n + 2];

         for (int i = 0; i < queries.length; i++) {
             prefixSum[queries[i][0]] += queries[i][2];
             prefixSum[queries[i][1] + 1] -= queries[i][2];
         }
        long max = prefixSum[1];
        for (int i = 1; i < n; i++) {
            prefixSum[i] += prefixSum[i - 1];
            max = Math.max(max, prefixSum[i]);
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
