// updatintg coding ninjas
public class solution {
	
	long solve(int[][] chocos,int N){
		
		//Write your code here.
		
		long dp[] = new long[1 << N] ; 
		for(int i = 0 ; i < dp.length ; i++)
		 dp[i] = Integer.MAX_VALUE ;
	     return waysToDist(chocos, 0, N, dp, 0) ;
	}
	
	static long waysToDist(int chocos[][], int mask, int n, long dp[], int Sn){
	    if(mask == (1 << n) - 1)
	      return 1 ;
	    
	    if(dp[mask] != Integer.MAX_VALUE)
	      return dp[mask] ; 
	     
	    long totalWays = 0 ;  
	    for(int i = 0 ; i < n ; i++){
	        if((mask & (1 << i)) == 0 && chocos[Sn][i] == 1)
	         totalWays += waysToDist(chocos, mask|(1 << i), n, dp, Sn + 1) ;
	    }  
	    return dp[mask] = totalWays ;
	}
	
}
