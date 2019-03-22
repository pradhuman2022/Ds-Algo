public class Minimum_Count {
static int count(int n)
{
    int dp []= new int[n + 1] ; 
    dp[1] = 1 ;
    dp[2] = 2 ;
    dp[3] = 3 ;
    int sqrt ;
    for(int i = 4 ; i <= n; i++)
    {
        sqrt =  (int)Math.floor(Math.sqrt(i));
       
        if(sqrt *sqrt == i)
            dp[i] = 1;
        else{
             dp[i] = Integer.MAX_VALUE;
            for(int k = 1 ; k <= sqrt ; k++)
            {
                dp[i] = Math.min(dp[k*k]+dp[i - (k *k)],dp[i]);
                System.out.println(i - (k *k)+" "+k+" "+i);
            }
        }
    }
   // System.out.println(sqrt) ;
   return dp[n];
}

}
