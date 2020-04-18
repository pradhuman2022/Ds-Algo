import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static String str1 ;
    static String str2 ;
    static boolean dp[][]; 
    static boolean visited[][]; 
    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        str1 = a;
        str2 = b;
        dp = new boolean[a.length() + 1][b.length() + 1];
        visited = new boolean[a.length() + 1][b.length() + 1];
        if(str1.length() < str2.length())
            return "NO";
        if(isPossible(0, 0))
            return "YES";
        return "NO" ; 
    }
    static boolean isPossible(int indexOfA, int indexOfB) {

        if(indexOfA == str1.length() && indexOfB == str2.length())
            return true; 
        
        if(str1.length() == indexOfA)
            return false; 

        if(visited[indexOfA][indexOfB])
            return dp[indexOfA][indexOfB]; 
           
        visited[indexOfA][indexOfB] = true; 
        if(str2.length() == indexOfB){
            if(Character.isUpperCase(str1.charAt(indexOfA)))
               return dp[indexOfA][indexOfB] = false; 
            else 
            return dp[indexOfA][indexOfB] =  isPossible(indexOfA + 1, indexOfB);
        }
        else {
            if(str1.charAt(indexOfA) == str2.charAt(indexOfB)) {
                return dp[indexOfA][indexOfB] = isPossible(indexOfA + 1, indexOfB + 1);
            }
            else {
            //first check if it is possible to cpnvert
                if(Character.isUpperCase(str1.charAt(indexOfA)))
                    return dp[indexOfA][indexOfB] = false;
                else if(Character.toUpperCase(str1.charAt(indexOfA)) == str2.charAt(indexOfB))
                    return dp[indexOfA][indexOfB] = isPossible(indexOfA + 1, indexOfB + 1) || isPossible(indexOfA + 1, indexOfB);
                else
                    return dp[indexOfA][indexOfB] = isPossible(indexOfA + 1, indexOfB);
            }
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
/*
ababbaAbAB AABABB false

aAbAb ABAB true

baaBa BAAA false

abAAb AAA true

babaABbbAb ABAA false
*/
