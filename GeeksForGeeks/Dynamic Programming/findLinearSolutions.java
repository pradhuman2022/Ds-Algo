/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		int coeff[] = new int[n]; 
		
		for(int i = 0 ; i < n; i++){
		    coeff[i] = sc.nextInt();
		}
		int rsh = sc.nextInt() ;
		System.out.println(printLinearSolutions(coeff, n, rsh)) ;
	}
	  //it is like coin change problem where we can select any coin for any time.
    static int printLinearSolutions(int coeff[], int n, int rsh){
        int dp[][] = new int[n + 2][rsh + 1] ; 
        
        for(int i = 0; i <= n; i++)
            dp[i][0] = 1 ; 
        
        for (int i = n; i >= 1; i--){
            for (int j = 1; j <= rsh; j++){
                if(j - coeff[i- 1] >= 0)
                dp[i][j] = dp[i][j - coeff[i - 1]];
                dp[i][j] += dp[i + 1][j];    
            }
        }
        return dp[1][rsh] ;
    }
}
