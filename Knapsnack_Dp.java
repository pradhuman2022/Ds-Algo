import java.util.* ;
public class Knapsnack_itr {
   public static void main(String ar[])
   {
       Scanner sc = new Scanner(System.in) ;
       int n = sc.nextInt() ;
       int wt[] = new int[n] ;
       int val[] = new int[n] ;
       for(int i = 0 ; i < n ; i++)
       {
           wt[i] = sc.nextInt() ;
       }
        for(int i = 0 ; i < n ; i++)
        {
            val[i] = sc.nextInt() ;
        }
        int W = sc.nextInt() ;
        int dp[][] = new int[n + 1][W + 1] ;
        for(int i = 1 ; i <= n ; i++)
        {
            for(int w = 1 ; w <= W ; w++)
            {
                dp[i][w] = dp[i - 1][w] ;
                if(wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i][w]) ;
            }
        }
        System.out.println(dp[n][W]) ;
   }
   static int Recur(int wt[], int val[] , int n, int W, int dp[][])
   {
       if(W <= 0 || n <= 0)
            return 0 ;
       if(dp[n][W] != 0)
           return dp[n][W] ; 
       int ans = Recur(wt, val, n - 1, W, dp);
       if(wt[n - 1] <= W)
           ans = Math.max(Recur(wt, val, n - 1 ,W - wt[n - 1], dp), ans);
       dp[n][W] = ans ;
       return dp[n][W] ;
   }
   
}
