/*
mene last mai final ans ke liy sum ni kia tha just, B[n] * S[n] return krdia tha , but
mujko sare combination chaiye so mne fir sum kia agr m last place p building ya space rkhta hu 
to , then sum ka square because we all combination.
my approach was correct , but faulty implementation.
*/

import java.io.*;

class GFG {
	public static void main (String[] args) {
	    int N = 1; 
	    System.out.println(printCountWays(N)); 
	}
	static int printCountWays(int N) {
	    int B[] = new int[N + 1]; 
	    int S[] = new int[N + 1];
	    B[1] = 1; 
	    S[1] = 1;
	    
	    for(int i = 2; i <= N; i++) {
	        S[i] = S[i - 1] + B[i - 1];
	        B[i] = S[i - 1]; 
	    }
	    int ans = B[N] + S[N]; 
	    
	    return ans *ans ; 
	}
}
/*
 - - - - - 
 B B  B
 S S
B(i) = S(i - 1); 
S(i) = S(i - 1) + B(i - 1); 

if(places == 0)
    return 1; 
*/
