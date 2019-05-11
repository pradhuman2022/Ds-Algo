/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes*/
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class ChopDownTrees {
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

       Scanner sc = new Scanner(System.in) ;
       int n = sc.nextInt() ;
       int k = sc.nextInt() ;
       int arr[] = new int[n] ;
       int max = Integer.MIN_VALUE ;
       for(int i = 0 ; i < n ; i++)
       {
           arr[i] = sc.nextInt() ;
           max = Math.max(max, arr[i]) ;
       }
       int rounds = (int)Math.ceil(((double)max)/k) ;
       long dp[] = new long[n] ;
       for(int i= 0 ;i <n ;i++)
       {
           dp[i] = arr[i] - ((rounds-1)* k) ;
       }
       int ans = -1 ;
       for(int i = 0 ; i < n ;i++)
       {
           if(dp[i] >= 0)
           ans = i ;
       }
       System.out.println(ans+1) ;
       
    
        // Write your code here

    }
}
