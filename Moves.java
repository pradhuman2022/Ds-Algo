	class Moves
  {
  
  public static void main(String ar[])
  {
  //Write code here l
        Scanner sc = new Scanner(System.in) ;
        int T = sc.nextInt() ; 
        while(T > 0)
        { 
            T--''
            int n = sc.nextInt() ; 
            int dp[] = new int[10000001] ; 
            System.out.println(getMoves(n, 0, dp)) ;
        }


   }
   static int getMoves(int n , int moves, int dp[])
   {
       if(n == 1)
          {
              dp[n] = moves ; 
          }
          if(n < 0)
            return 0 ; 
          if(dp[n] != 0)
          {
              return dp[n] ; 
          } 
          int ans ;
          if((n & 1) == 1)
          {
              int a = getMoves(n - 1, moves + 1 , dp) ;
              int b = getMoves(n + 1 , moves + 1 , dp) ;
              ans = Math.min(a, b) ; 
          } 
          else
          {
              ans = getMoves(n / 2 , moves + 1 , dp) ; 
          }
          dp[n] = ans ; 
          return ans ;
   }
   }
