import java.util.Scanner;

public class Main {

	
	 
	 public static void main(String[] args) {
        // Write your code here
       Scanner sc = new Scanner(System.in) ;
       int T = sc.nextInt(); 
       while(T-- > 0)
       {
           int n = sc.nextInt() ; 
           int k = sc.nextInt() ;
           boolean arr[] = new boolean[(2 * n)] ;
           for(int i = 0 ; i < k ; i++)
           {
            arr[sc.nextInt() - 1] = true ;   
           }
           
           int dp[][] = new int[n + 1][n  + 1] ;
           System.out.println(getBrackets(0 , 0, 0 ,dp, arr)) ;
         //  System.out.flush() ;
       }
            
    }
    
    static int getBrackets(int n , int o , int c , int dp[][] , boolean a[])
    {
        if(o >= dp.length || c >= dp.length)
        {
            return 0 ;
        }
        if(o == dp.length - 1&& c == dp.length - 1)
            return 1 ;
        if(dp[o][c] > 0)
            return dp[o][c] ;
        
       if(o == c || a[o + c] == true )
       {
         return dp[o][c] = getBrackets(n + 1, o + 1, c, dp ,a);
       }
        else  if(o == dp.length - 1)
                return dp[o][c] = getBrackets(n + 1, o, c + 1,dp, a) ;
        else
        {
            int ans = 0 ; 
            int a1 = getBrackets(n + 1,o + 1 , c , dp,a) ;
            int a2 = getBrackets(n + 1 , o , c + 1 ,dp, a) ;
            return dp[o][c] = a1 + a2 ;
        }
        
    }

  
}
