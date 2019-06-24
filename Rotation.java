/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
         
         Scanner sc= new Scanner(System.in) ;
          int n  = sc.nextInt() ; 
           sc.nextLine() ;
          String s = sc.nextLine() ;
          String t = sc.nextLine() ;
        //  System.out.println(t+" "+s);
          int len = 0 ;
          for(int i = n - 1; i >= 0;)
          {
              int tLen = 0 ;
              int j = n - 1; 
              while(j >= 0 && i >= 0 && s.charAt(j) == t.charAt(i))
              {
                  j--;
                  i--;
                  tLen++ ;
              }
              i--;
              len = Math.max(tLen, len);
              
          }
             if(len == 0 || len == 1)
              System.out.println(n) ;
             else
              System.out.println(n - len) ;
        // Write your code here

    }
}
