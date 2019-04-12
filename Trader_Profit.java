import java.util.Scanner;

public class Trader_Profit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while (q-- > 0) {
     		int k = sc.nextInt();
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
            int dp1[][][] = new int[31][10][2] ;
            for(int i = 0 ; i < 31 ; i++)
            {
                for(int j = 0 ; j < 10 ; j++)
                {
                    dp1[i][j][0] = -1 ;
                    dp1[i][j][1] = -1 ;
                }
            }
         int option2 = getProfit(n , k, 0 , arr, dp1,0) ;
            System.out.println(option2) ;
			
	}
    }
    static int getProfit(int n, int k , int status , int arr[], int dp[][][] ,int index)
    {
     if(n <= 0)
     {
       return 0 ;  
     }
     if(dp[n][k][status] > -1)
          return dp[n][k][status] ;
     
      int option1 = getProfit(n - 1 , k , status,  arr, dp, index + 1) ;
      int option2 = 0 ;
      if(status == 1)
      {
         option2 = getProfit(n - 1, k  - 1, 0, arr, dp, index + 1) + arr[index] ; 
      }
        else
        {
            if(k > 0)
                option2 = getProfit(n - 1 , k, 1, arr, dp, index + 1) - arr[index] ;
        }
     
        dp[n][k][status] = Math.max(option1, option2) ;
        return dp[n][k][status];
        
    }
}
