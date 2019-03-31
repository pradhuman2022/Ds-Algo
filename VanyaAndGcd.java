import java.util.Scanner;
public class VanyaAndGcd {
    	public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        
        int arr[] = new int[n + 1]  ;
        for(int i = 0 ; i < n ; i++) 
         arr[i] = sc.nextInt() ; 
        System.out.println(getTotalGcdOf_1(arr)) ;
    }
    static long getTotalGcdOf_1(int arr[]) 
    {
        long dp[][] = new long[arr.length][101] ; 
         for(int i = 0 ; i < arr.length ;i++)
             dp[i][arr[i]] = 1 ;
         for(int i = 1 ; i < arr.length; i++)
         {
             for(int j = i - 1 ; j >= 0 ;j--)
             {
                if(arr[i] > arr[j])
                {
                for(int g = 1 ; g < 101 ; g++)
                {
                    if(dp[j][g] > 0)
                    {
                        int gcd = gcd(g , arr[i]) ;
                        dp[i][gcd] += dp[j][g] ; 
                    }
                 }
                }
             }
         }
        long sum = 0 ;
         int mod = (int)Math.pow(10, 9) + 7 ;
         for(int i = 0 ; i < arr.length; i++)
         {  sum += dp[i][1] ;
            sum %= mod ;
         }
         return sum ;
    }
  	public static int gcd(int a, int b) { 
        if (a == 0) return b; 
        return gcd(b % a, a); 
    } 
  
}
