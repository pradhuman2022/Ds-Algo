import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc = new Scanner(System.in) ;

    int n = sc.nextInt() ;
    int d = sc.nextInt() ;
        int arr[] = new int[n] ;
        for(int i = 0 ; i < n ; i++)
        {
            int newPos = Math.abs(i + (n - d));
            newPos %= n ;
            arr[newPos] = sc.nextInt() ;
        }
        for(int x : arr)
        System.out.print(x+" ") ;
    }
}

