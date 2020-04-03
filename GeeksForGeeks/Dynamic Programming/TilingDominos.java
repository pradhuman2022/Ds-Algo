/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		System.out.println(countWays(8));
	}
	static int countWays(int n) {
	    int B[] = new int[n + 1];
	    int A[] = new int[n + 1];
	    A[0] = 1;
	    B[0] = 0;
	    B[1] = 1;
	    A[1] = 1;
	    
	    for(int i = 2; i <= n; i++) {
	        A[i] = A[i - 2] + B[i - 1] * 2 ;
	        B[i] = A[i - 1] + B[i - 2] ;
	    }
	    return A[n];
	}
}
