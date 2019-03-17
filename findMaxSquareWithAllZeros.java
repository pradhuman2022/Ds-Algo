public class Solution {
	
	public static int findMaxSquareWithAllZeros(int[][] input){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
        return maxSize(input);
	}
    static int maxSize(int input[][])
    {
        int dp[][] = new int[input.length][input[0].length] ;
        
        for(int col = 0 ; col < input[0].length ; col++)
        {
            if(input[0][col] == 0)
                dp[0][col] = 1 ;
        }
        for(int row = 0; row< input.length ; row++)
        {
            if(input[row][0] == 0)
                dp[row][0] = 1 ;    
        }
        
        for(int row = 1 ; row < input.length; row++)
        {
            for(int col = 1 ; col < input[0].length; col++)
            {
                if(input[row][col] == 0)
                {
                    dp[row][col] = Math.min(dp[row - 1][col - 1] , Math.min(dp[row][col - 1], dp[row - 1][col])) + 1 ;
                    
                }
      
            }
            
            
        }
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < input.length ; i++)
        {
            for(int j = 0 ; j < input[0].length; j++)
            {
                if(max < dp[i][j])
                    max = dp[i][j] ;
                
            }
            
        }
        return max ;
        
    }
   
	
}
