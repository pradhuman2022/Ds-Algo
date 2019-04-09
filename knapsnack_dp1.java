public class Solution {
	
	
	
	public static int knapsack(int[] weight,int value[],int maxWeight){

	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
       int n = weight.length ;
       int dp[] = new int[maxWeight + 1] ; 
        for(int i = 1 ; i <= n ; i++)
        {
            int ans [] = new int[maxWeight + 1] ;
            
            for(int w = 0 ; w <= maxWeight ; w++)
            {
               
                if(weight[i - 1] <=w)
                    ans[w] = Math.max(value[i - 1] + dp[w - weight[i - 1]] ,dp[w]);
                 else
                      ans[w] = dp[w] ;
            }
           
            dp = ans ;
        }
        
        return dp[maxWeight] ;
       	}
 
	
}
