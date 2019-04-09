import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		//  Write your code here
       Scanner sc = new Scanner(System.in); 
       int Budget = sc.nextInt() ; 
       int n      = sc.nextInt() ;
        while(Budget != 0 && n != 0)
        {
           Party[] p = new Party[n] ;
            for(int i = 0 ; i < n ; i++)
            {
               p[i] = new Party(sc.nextInt(), sc.nextInt());  
            }
         int dp[][] = new int[n + 1][Budget + 1]; 
            for(int i = 1; i <= n ; i++)
            {
                for(int w = 1 ; w <= Budget ; w++)
                {
                    dp[i][w] = dp[i - 1][w] ; 
                    if(p[i - 1].bud <= w)
                     dp[i][w] = Math.max(p[i - 1].fun + dp[i - 1][w- p[i - 1].bud], dp[i][w]);
                }
            }
            int cost = Budget ; 
            
            for(int i = 0 ; i <= Budget ; i++)
            {
                if(dp[n][i] == dp[n][Budget])
                {
                    cost = i ;
                    break ;
                }  
            }
            System.out.println(cost+" "+dp[n][Budget]) ;
            Budget = sc.nextInt() ; 
            n      = sc.nextInt() ;
        }
	}
  
    static class Party
    {
        int fun ;
        int bud ;
       public  Party(int b , int f)
        {
            fun = f ;
            bud = b; 
        }
    }
}
