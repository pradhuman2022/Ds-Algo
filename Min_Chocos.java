public class MinChocos {

	public static int getMin(int arr[], int N){
        int dp[] = new int[arr.length] ;
        dp[0] = 1 ;
        for(int i = 1 ; i < arr.length ; i++)
        {
            dp[i] = 1 ;
            if(arr[i] > arr[i - 1])
                dp[i] += dp[i - 1] ;
        }
        int sum = dp[arr.length - 1] ;
        for(int i = arr.length - 2 ; i >= 0 ; i--)
        {
            if(arr[i] > arr[i + 1])
            {
                dp[i] = Math.max(dp[i + 1] + 1, dp[i]) ;
            }
            sum += dp[i] ;
        }
        return sum ;
    }
}
