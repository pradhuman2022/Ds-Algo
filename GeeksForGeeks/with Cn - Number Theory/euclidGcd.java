
public class Solution {
	
	public static int gcd(int a,int b)
	{
		// Write your code here
        if(a < b)
            return gcd(b, a) ;
        if(b == 0)
            raeturn a  ;
        return gcd(b, a % b) ;
	}		
}
