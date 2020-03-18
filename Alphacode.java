import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write y our code here
        Scanner sc = new Scanner(System.in) ;
        String n =   sc.nextLine() ;
            
        while(!n.equals("0")) 
        {
            System.out.println(alphacode1(n));
            n = sc.nextLine() ;   
        }
        
        }
    static int alphacode(String n , int len , int dp[])
    {
        if(n.length() == 0 || n.length() == 1)
            return 1 ;
        if(dp[len] > 0)
            return dp[len] ;
        if(Integer.parseInt(Character.toString(n.charAt(len)))== 0)
        {
             return alphacode(n.substring(0 ,len - 1),len - 2, dp);
        }
        int output = alphacode(n.substring(0, len), len - 1, dp) ;
        if(Integer.parseInt(Character.toString(n.charAt(len - 1))) == 0)
           return output ;
        if(Integer.parseInt(Character.toString(n.charAt(len - 1))) * 10 + Integer.parseInt(Character.toString(n.charAt(len))) <= 26)
        {
            
            output += alphacode(n.substring(0 ,len - 1),len - 2, dp);
        }
        dp[len] = output ;
        return output ;
    }
    
    
    
    //Bottom up approach
    static int alphacode1(String n)
    {
        int dp [] = new int[n.length() + 1] ;
        dp[0] = 1 ;
        dp[1] = 1 ;
        int mod = (int)Math.pow(10,9) + 7 ;
        for(int i = 1 ; i < n.length(); i++)
        {
            if(n.charAt(i) != '0')
            dp[i + 1]  = ((dp[i + 1] % mod) + (dp[i]  % mod)) % mod;
        if(n.charAt(i - 1) != '0'&& Integer.parseInt(Character.toString(n.charAt(i - 1))) * 10 + Integer.parseInt(Character.toString(n.charAt(i))) <= 26)
        {
            dp[i + 1] =((dp[i + 1] % mod) + (dp[i - 1]  % mod)) % mod ;
        } 
        }
        return dp[dp.length - 1] ;
    }

}
