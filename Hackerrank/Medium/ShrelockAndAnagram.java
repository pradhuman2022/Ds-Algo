import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    
    
      static Map<String, Integer> hs ; 
      
      
    // Complete the sherlockAndAnagrams function below.
    
    
    //implementation start here -----------------
    static int sherlockAndAnagrams(String s) {
       hs = new HashMap(); 
           int sigCon = (int)Math.pow(10,9) + 7 ;
     for(int i = 0; i < s.length(); i++)
     {
         for(int j = i  ; j < s.length(); j++)
         {
             String ana = s.substring(i,j + 1) ;
             setSignature(ana, sigCon) ;      
         }
     }
     long ans = 0 ;
     Iterator <Map.Entry<String, Integer>>itr = hs.entrySet().iterator() ;
     while(itr.hasNext())
     {
         Map.Entry<String, Integer> entry = itr.next() ;
         int n = entry.getValue() ;
         n = (n * (n - 1)) / 2 ;
         ans += n ;
     }
     return (int)ans;

    }
   static void setSignature(String ana, int sigCon)
  {
      int sig[] = new int[26] ;
      for(int x = 0 ; x < ana.length() ; x++)
      {
         sig[ana.charAt(x) - 97]++ ;
      }
        
      String s = "" ;
      for(int i = 0 ; i < 26 ;i++)
      {
         s += Integer.toString(sig[i]) ;
      }
      s = s.trim() ;
     hs.put(s, hs.getOrDefault(s, 0) + 1) ;//get(sig, default) ;
      
  }//-------------------------implementation end here :
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
