import java.util.* ;
public class RoyAndCoinBoxes {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int s[] = new int[n + 1] ;
        int e[] = new int[n + 1] ;
        int m = sc.nextInt() ; 
        for(int i = 0 ; i < m; i++)
        {
            s[sc.nextInt()]++ ;
            e[sc.nextInt()]++ ;
        }
        
        int dp[] = new int[n + 1] ;
        dp[1] = s[1] ;
        for(int i = 2 ; i <= n; i++)
        {
            dp[i] = (s[i] + dp[i - 1]) - e[i - 1] ;
        }
        int dp1[] = new int[n + 1] ;
        for(int j = 1 ; j <= n ; j++ )
        {
            dp1[dp[j]]++ ;
        }
        int dp2[] = new int[n + 1] ;
        dp2[n] = dp1[n] ;
        for(int i = n - 1 ; i >= 0 ; i--)
        {
            dp2[ i ] = dp1[i]+ dp2[i + 1] ;
        }
        int q = sc.nextInt() ;
        while(q > 0)
        {
            q--; 
            System.out.println(dp2[sc.nextInt()]) ;
        }
    }
}
