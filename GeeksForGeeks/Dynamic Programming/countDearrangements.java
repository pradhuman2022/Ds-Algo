import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int mod = (int)Math.pow(10, 9) + 7; 
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0) {
	      int n = sc.nextInt();
	      System.out.println(countDerrangements(n)); 
	    }
	 }
	 /*
     solution k thoda kareeb tha bs do numbers ko swap krna tha wo ni souch paya.
     jese friend pair m krte h ki usko kisi ek friend ka sth pair kr dete. wese hi 
     jb kisi dusre number se swap krege to hmare pass n - 2 numbers ko dearrangement
     dekhna pdega. agr usko kis b position p dal de jo n - 1 hogi to hmare n - 1 choices hai
      so f(n - 1) * (n - 1) kisi p position p dalne k liy or n - 1 number ko dearrange krne k liy,
      f(n - 2) *(n - 1) ki hmare pass n - 1 choice hai swap krne k liy.
      f(n) = (n - 1) * (f(n - 1) + f(n - 2))
   */
	 static long countDerrangements(int N) {
	    long dp[] = new long[N + 1];
	    dp[0] = 1;
	    dp[2] = 1; //{0, 1} -> {1, 0}
	    for(int i = 2; i <= N; i++) {
	        dp[i] = ((i - 1) * ((dp[i - 1] + dp[i - 2]) % mod)) % mod; 
	    }
	   return dp[N]; 
	 }
}
