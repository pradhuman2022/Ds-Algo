import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int lengthOfString; 
    static int dp[][][]; 
	public static void main (String[] args)
	 {
	 
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases-->0) {
            lengthOfString = sc.nextInt();
            dp = new int[lengthOfString + 1][2][3] ; 
           for (int i = 0; i < lengthOfString + 1; i++)  
            { 
            for (int j = 0; j < 2; j++)  
            { 
                for (int k = 0; k < 3; k++)  
                { 
                    dp[i][j][k] = -1; 
                } 
            } 
        } 
            System.out.println(printCountOfStrings(lengthOfString, 1, 2)) ;
        } 
	 }
	 /*
	  mai ending krke souch rha tha ki b se end hoga to kya state hogi, 
	  wo method b shi tha but it is easy ki agr mai b ko rkh du or count km 
	  krdu and same for c k liy bhi.
	 */
	 static int printCountOfStrings(int len , int countOfBs, int countOfCs) {
	   
	    if(countOfBs < 0 || countOfCs < 0)
	        return 0; 
	    
	    if(len == 0 || countOfBs == 0 && countOfCs == 0)
	        return 1; 
	        
	    if(dp[len][countOfBs][countOfCs] != -1)
	        return dp[len][countOfBs][countOfCs]; 
	        
	    int ans = 0; 
	    ans = printCountOfStrings(len - 1, countOfBs - 1, countOfCs); 
	    ans += printCountOfStrings(len - 1, countOfBs, countOfCs - 1);
	    ans += printCountOfStrings(len - 1, countOfBs, countOfCs); 
	    return dp[len][countOfBs][countOfCs] = ans ; 
	 }
}
