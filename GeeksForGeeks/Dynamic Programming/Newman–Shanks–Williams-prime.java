/*package whatever //do not write package name here */

import java.io.*;
import java.util.* ; 

class GFG {
	public static void main (String[] args) {
	   Scanner sc = new Scanner(System.in); 
	   int n = sc.nextInt() ; 
	   int dp[] = new int[n + 1] ;
	   dp[0] = 1 ; 
	   dp[1] = 1 ;
	   for(int i = 2 ; i <= n; i++)
	     dp[i] = 2 * dp[i - 1] + dp[i - 2];
	   
	   System.out.println(dp[n]) ;   
	}
}
/*
In mathematics, a Newman–Shanks–Williams prime (NSW prime) is a prime number p which can be written in the form:
{ \Huge S_{2m+1} = \frac{ {(1+\sqrt{2})^{2m+1} + (1-\sqrt{2})^{2m+1} } }{2} }

Recurrence relation for Newman–Shanks–Williams prime is:

S_0 = 1
S_1 = 1
S_n = 2*S_{n-1} + S{n-2}
The first few terms of the sequence are 1, 1, 3, 7, 17, 41, 99, ….
*/
