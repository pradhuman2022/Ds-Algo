import java.util.*;

public class Main {

	static int mod = (int)Math.pow(10, 9) + 7 ;
	public static void main(String[] args) {
		// Write your code here
              Scanner sc = new Scanner(System.in) ;
              int T = sc.nextInt() ;
              sc.nextLine();
              while(T-- > 0)
              {
                  String s = sc.nextLine() ;
                  System.out.println(getDistSub(s)) ;
              }
	}
    static long getDistSub(String s)
    {
        int last[] = new int[256] ;
        int dp[] = new int[s.length() + 1] ;
        dp[0] = 1 ;
        Arrays.fill(last, -1) ;
        int mod = (int)Math.pow(10, 9) + 7;
        for(int i = 1 ; i < dp.length ; i++)
        {
            dp[i]  = dp[i - 1] << 1 ;
            if(dp[i] > mod)
                dp[i] -= mod ;
            if(last[s.charAt(i - 1)] != -1)
                dp[i] -= dp[last[s.charAt(i - 1)]] ;
            if(dp[i] < 0)
                dp[i] += mod;
            last[s.charAt(i - 1)] = i - 1 ;
        }
        return dp[dp.length - 1] ;
        
    }
}
