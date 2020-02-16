/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int n = sc.nextInt() ; 
		System.out.println(countWaysToDivideCircle(n)) ;
	}
	
	//when we draw chords between two points then set will divide into two smalls sets, if we draw chord from a point of S1 to a point of S2
	//then one of chord will interect.
	// if we select set of i elements then n - i - 1 will be remaining in other set , if find count ways using i and n - i - 1 elements then
	// our ans will be ways(n) = S-> 0 to n - 1 (ways(i) * ways(n - i - 1)) ; 
	
 	static int countWaysToDivideCircle(int chords){
	    int points = chords * 2 ; 
	    
	    int dp[] = new int[points + 1] ;
	    dp[0] = 1 ;
	    dp[2] = 1 ;
	    
	    for(int i = 4; i <= points; i += 2){
	        for(int j = 0; j < i - 1; j += 2)
	         dp[i] += dp[j] * dp[i - 2 - j] ;
	    }
	    return dp[points] ;
	}
}
