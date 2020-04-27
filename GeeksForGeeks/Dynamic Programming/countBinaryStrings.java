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
	        System.out.println(count(n));
	    }
	 }
	static int count(int n){
	    int count1[] = new int[n + 1];
	    int count0[] = new int[n + 1];
	    count1[1] = 1;
	    count0[1] = 1; 
	    for (int i = 2; i <= n; i++) {
	        count1[i] = count0[i - 1];
	        count0[i] = (count0[i - 1] + count1[i - 1]) % mod; 
	    }
	    return (count1[n] + count0[n]) % mod;
	} 
}
