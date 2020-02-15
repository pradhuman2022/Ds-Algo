/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static final int MOD = 1000000007; 
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		
		
            int n = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            
            System.out.println(countOfArrays(n, k , x)) ;
		
	}
	static long countOfArrays(int n, int k ,int x){
	   
	    int dp[] = new int[n];
	    dp[1] = 1;
        for(int i = 2; i < n; i++)  {
            //if select i - 1 element as 1 so 
            int option1 = dp[i - 2] * (k - 1);
            
            //if we select i - 1 is not equal to 1
            int option2 = dp[i - 1] * (k - 2) ; 
            dp[i] = option1 + option2;
        }
            return x == 1 ? dp[n - 2] * (k - 1) : dp[n - 1]; 
	}
}
