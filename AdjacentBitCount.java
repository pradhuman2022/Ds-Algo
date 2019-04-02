import java.util.Scanner;

public class AdjacentBitCount {

     static int dp[][][] ; 
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n  = sc.nextInt() ;
        for(int l = 0 ; l < n ; l++)
        {    
        int ds = sc.nextInt() ; 
        int len  = sc.nextInt() ;
        int bitcount  = sc.nextInt() ;
        dp =  new int[len + 1][bitcount + 1][2] ;
        for(int i = 0 ; i <= len; i++)
        {
            for(int j = 0 ; j <= bitcount; j++)
            {
                for(int k = 0 ; k <= 1 ;k++)
                    dp[i][j][k] = -1 ;
            }
        }
        int mod = (int) Math.pow(10, 9) + 7 ;
        int ans = ((solve(len, bitcount , 0) % mod))  ;
        ans  = (ans + solve(len, bitcount , 1) % mod) % mod ; 
        System.out.println(ds+" "+ans);
        }
}
    public static int solve(int n, int k , int first)
    {
        if(n == 1)
        {
               if(k == 0)
                   return 1 ; 
               
            return 0 ;
            
        }
        if(k < 0)
             return 0 ;
        
        if(dp[n][k][first] != -1)
            return dp[n][k][first] ;
        int mod = (int)Math.pow(10, 9) + 7 ;
        if(first == 0)
        {
            int output1 = solve(n - 1 , k, 1)  ;
            int output2 = solve(n - 1, k, 0) ;
            int temp = ((output1 % mod) + (output2 % mod)) % mod ;  
            dp[n][k][first] = temp ;
        }
        else
        {
            int output1 = solve(n - 1 , k - 1 , 1) ; 
            int output2 = solve(n - 1 , k , 0); 
            int temp = ((output1 % mod) + (output2 % mod)) % mod ; 
            dp[n][k][first] = temp ;
        }
        return dp[n][k][first] ; 
    }
}
