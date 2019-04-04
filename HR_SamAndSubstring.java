import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrings function below.
    static long substrings(String n) {
        long lastValue = n.charAt(0) - '0' ; 
    long totalSm = n.charAt(0) - '0';
        int mod = (int)Math.pow(10,9)+7 ;
        for(int i = 1 ; i < n.length(); i++)
        {
           lastValue = lastValue * 10 + (n.charAt(i) - '0') * (i + 1) ;
           lastValue %= mod ;
           totalSm = (totalSm + lastValue) % mod ;

            }

     return totalSm ; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String n = scanner.nextLine();

        long result = substrings(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
